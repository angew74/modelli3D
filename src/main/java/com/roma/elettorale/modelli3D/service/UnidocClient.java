package com.roma.elettorale.modelli3D.service;

import com.roma.elettorale.modelli3D.helpers.MultipartUtil;
import com.roma.elettorale.modelli3D.helpers.TransformationFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.roma.elettorale.modelli3D.entity.unidoc.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Component
public class UnidocClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(UnidocClient.class);

    @Autowired
    Environment env;


    @Autowired
    TransformationFile ttransformation;




    /*
    Verifica che esista già un documento del genere per quella persona se è negativo risponde con una stringa vuota
    altrimenti restistuisce l'id del file già in archivio
     */


    public FileResponseList searchFiles(ArrayOfUnidocFolder folders, ArrayOfUnidocTypes types, ArrayOfArrayOfUnidocsMetadata metadata) throws Exception {

        FileResponseList fileResponseList = new FileResponseList();
        try {
            URL urlUnidocService = new URL(env.getProperty("serviziounidoc"));
            ControllerOperazioniWS controllerOperazioniWS = new ControllerOperazioniWS(urlUnidocService);
            String operatore = "AND";
            ArrayOfStrings status = new ArrayOfStrings();
            List<String> strings = new ArrayList<>();
            strings.add("1");
            int da = 0;
            int per = 100;
            fileResponseList = controllerOperazioniWS.getControllerOperazioniWSSoap().searchFiles(folders, types, metadata, operatore, status, da, per);
        } catch (Exception ex) {
            logger.error("ERR_12" + ex.getMessage() + " causa " + ex.getCause().getMessage());
            System.out.println("Exception: " + ex.getMessage() + " causa " + ex.getCause().getMessage());
            throw new Exception(ex.getMessage() + " causa " + ex.getCause().getMessage());
        }
        return fileResponseList;
    }

    public FileResponse addFile(FileRequest fileRequest) {
        FileResponse fileResponse = new FileResponse();
        try {
            URL urlUnidocService = new URL(env.getProperty("serviziounidoc"));
            ControllerOperazioniWS controllerOperazioniWS = new ControllerOperazioniWS(urlUnidocService);
            //  String service = env.getProperty("servizioverifica");
            fileResponse = controllerOperazioniWS.getControllerOperazioniWSSoap().addFile(fileRequest);

        } catch (Exception ex) {
            logger.error("ERR_15" + ex.getMessage());
            System.out.println("Exception: " + ex.getMessage());
        }
        return fileResponse;
    }

    public FolderResponse creaNuovaCartella(FileRequest fileRequest) {
        FolderResponse folderResponse = new FolderResponse();
        try {
            URL urlUnidocService = new URL(env.getProperty("serviziounidoc"));
            ControllerOperazioniWS controllerOperazioniWS = new ControllerOperazioniWS(urlUnidocService);
            String service = env.getProperty("servizioverifica");
            folderResponse = controllerOperazioniWS.getControllerOperazioniWSSoap().creaNuovaCartella(fileRequest);
        } catch (Exception ex) {
            logger.error("ERR_12" + ex.getMessage());
            System.out.println("Exception: " + ex.getMessage());
        }
        return folderResponse;
    }

    public String postFileUploadRaw(byte[] File, String idfile) {
        String service = env.getProperty("uploadFile");
        StringBuilder response = new StringBuilder();
        response.append("OK");
        try {
            URL url = new URL(service);
            MultipartUtil multipartUtil = new MultipartUtil(service,"UTF-8",false);
            PrintWriter printWriter =  multipartUtil.setup_writer();
            multipartUtil.addFilePart(idfile,idfile,File);
            HttpURLConnection httpURLConnection =  multipartUtil.finish();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            int status = httpURLConnection.getResponseCode();
            UploadResponse uploadResponse = ttransformation.convertXmltoUploadResponse(content.toString());
            Reader streamReader = null;
            if (status > 299) {
                streamReader = new InputStreamReader(httpURLConnection.getErrorStream());
                response = new StringBuilder();
                response.append("ERR_28 Errore di connessione status: " + status);
                logger.error("ERR_28 Errore di connessione status " + status);
            }
            in.close();
            httpURLConnection.disconnect();
        }
        catch (Exception ex) {
            logger.error("ERR_16BIS: " + ex.getMessage());
            response = new StringBuilder();
            response.append("ERR_16BIS: " + ex.getMessage());
            System.out.println("Exception: " + ex.getMessage());
        }
        return response.toString();
    }

    public String postFileUpload(byte[] File, String idfile) {
        String service = env.getProperty("uploadFile");
        StringBuilder response = new StringBuilder();
        response.append("OK");
        try {
            URL url = new URL(service);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            StringBuilder parameters = new StringBuilder();
            parameters.append("fileName=");
            parameters.append(idfile);
            parameters.append("&file=");
            parameters.append(URLEncoder.encode(new String(File), "UTF-8"));
            // parameters.put("", File);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("charset", "UTF-8");
            con.setRequestProperty("Content-Length", Integer.toString(parameters.toString().getBytes().length));
            con.setRequestMethod("POST");
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(parameters.toString());
            wr.flush();
            wr.close();
            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            UploadResponse uploadResponse = ttransformation.convertXmltoUploadResponse(content.toString());
            Reader streamReader = null;
            if (status > 299) {
                streamReader = new InputStreamReader(con.getErrorStream());
                response = new StringBuilder();
                response.append("ERR_28 Errore di connessione status: " + status);
                logger.error("ERR_28 Errore di connessione status " + status);
            }
            in.close();
            con.disconnect();
            if (!uploadResponse.getMessage().getCodice().equals("OK")) {
                response = new StringBuilder();
                logger.error("ERR_27" + uploadResponse.getMessage().getDescrizioneMessaggio());
                response.append("ERR_27 " + uploadResponse.getMessage().getDescrizioneMessaggio());
                System.out.println("Exception: " + uploadResponse.getMessage().getDescrizioneMessaggio());
            }
        } catch (Exception ex) {
            logger.error("ERR_16" + ex.getMessage());
            response = new StringBuilder();
            response.append("ERR_16 " + ex.getMessage());
            System.out.println("Exception: " + ex.getMessage());
        }
        return response.toString();
    }
}

