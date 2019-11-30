package com.roma.elettorale.modelli3D.helpers;

import com.roma.elettorale.modelli3D.entity.unidoc.Metadato;
import com.roma.elettorale.modelli3D.entity.unidoc.UploadResponse;
import com.roma.elettorale.modelli3D.entity.veri.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.beans.Introspector;
import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TransformationFile {

    Logger logger = LoggerFactory.getLogger(TransformationFile.class);
    @Autowired
    Environment env;


    public Document convertStringToXMLDocument(String xmlString) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new ByteArrayInputStream(xmlString.replace("#", "").getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("ERR_05: " + e.getMessage());
        }
        return document;
    }


    static void recurse(NodeList list) {
        if (list == null || list.getLength() == 0) {
            return;
        } else {
            for (int i = 0; i < list.getLength(); i++) {
                Node item = list.item(i);
                System.out.println(item);
                recurse(item.getChildNodes());
            }
        }
    }

    public VERICODRESPONSE convertXmltoVericodResponse(String xmlString) {
        JAXBContext jaxbContext;
        VERICODRESPONSE vericodresponse = null;
        try {
            jaxbContext = JAXBContext.newInstance(com.roma.elettorale.modelli3D.entity.veri.VERICODRESPONSE.class, ObjectFactoryVeriCodResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            vericodresponse = (VERICODRESPONSE) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
            System.out.println(vericodresponse);
        } catch (JAXBException e) {
            e.printStackTrace();
            logger.debug("ERR_04: " + e.getMessage());
        }
        return vericodresponse;
    }


    public UploadResponse convertXmltoUploadResponse(String xmlString) {
        JAXBContext jaxbContext;
        UploadResponse uploadResponse = null;
        try {
            jaxbContext = JAXBContext.newInstance(UploadResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            uploadResponse = (UploadResponse) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
        } catch (JAXBException e) {
            e.printStackTrace();
            logger.error("ERR_26: " + e.getMessage());
        }
        return uploadResponse;
    }

    public static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }
        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

    public Document convertClassToDocument(Object o) {

        Document document = null;
        try {
            Class<?> clazz = o.getClass();
            JAXBContext context = JAXBContext.newInstance(clazz);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); // remove xml prolog
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // formatted output
            final QName name = new QName(Introspector.decapitalize(clazz.getSimpleName()));
            JAXBElement jaxbElement = new JAXBElement(name, clazz, o);
            StringWriter sw = new StringWriter();
            marshaller.marshal(jaxbElement, sw);
            document = convertStringToXMLDocument(sw.toString());
            return document;
        } catch (JAXBException e) {
            logger.debug("ERR_07: " + e.getMessage());
            throw new DataBindingException(e);
        }
    }

    public Metadato createMetaDato(String nomeMetadato, String valoreMetaDato) {

        Metadato m = new Metadato();
        m.setValoreMetadato(valoreMetaDato);
        m.setNomeMetadato(nomeMetadato);
        return m;
    }


    public Document ConvertFileToXmlDocument(File fileToCheck)
    {
        FileInputStream fis = null;
        // Creating a byte array using the length of the file
        // file.length returns long which is cast to int
        byte[] bArray = new byte[(int) fileToCheck.length()];
        try {
            fis = new FileInputStream(fileToCheck);
            fis.read(bArray);
            fis.close();

        } catch (IOException ioExp) {
            ioExp.printStackTrace();
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new ByteArrayInputStream(bArray));
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("ERR_55: " + e.getMessage());
        }
        return document;

    }

    public Document ConvertStringToXmlDocument(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();
            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } catch (Exception e) {
            logger.error("ERR_22 dettagli: " + e.getMessage() + " " + e.getCause());
            e.printStackTrace();
        }
        return null;
    }

    public void wrtiteToDisk(String path, byte[] out) {

        try {

            File file = new File(path);
            OutputStream
                    os
                    = new FileOutputStream(file);
            os.write(out);
            System.out.println("Successfully"
                    + " byte inserted");
            os.close();
        } catch (Exception e) {
            logger.debug("ERR_09: " + e.getMessage());
            System.out.println("Exception: " + e);
        }
    }

    public String jaxbObjectToXMLVericod(VERICOD vericod) {
        Locale.setDefault(Locale.ENGLISH);
        String xmlContent = "";
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(com.roma.elettorale.modelli3D.entity.veri.VERICOD.class, ObjectFactoryVeriCod.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(vericod, sw);
            xmlContent = sw.toString();
        } catch (JAXBException e) {
            logger.debug("ERR_10: " + e.getMessage());
            e.printStackTrace();
        }
        return xmlContent;
    }

    public String jaxbObjectToXMLVeriric(VERIRIC veriric) {
        Locale.setDefault(Locale.ENGLISH);
        String xmlContent = "";
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(com.roma.elettorale.modelli3D.entity.veri.VERIRIC.class, ObjectFactoryVeriRic.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(veriric, sw);
            xmlContent = sw.toString();
        } catch (JAXBException e) {
            logger.debug("ERR_10: " + e.getMessage());
            e.printStackTrace();
        }
        return xmlContent;
    }


    public String convertDocumentToString(Document doc) throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        StringWriter sw = new StringWriter();
        trans.transform(new DOMSource(doc), new StreamResult(sw));
        return sw.toString();
    }

    public byte[] convertDocumentToByteArray(Document doc) throws TransformerException {
        byte[] array = null;
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        StringWriter sw = new StringWriter();
        trans.transform(new DOMSource(doc), new StreamResult(sw));
        array = sw.toString().getBytes();
        return array;
    }


    public String ParsingTag(String tag, Document document) {
        String ret = "";
        if(document.getElementsByTagName(tag) != null) {
            if (document.getElementsByTagName(tag).getLength() > 0) {
                return document.getElementsByTagName(tag).item(0).getTextContent();
            } else {
                return "";
            }
        }
        return  ret;
    }

    public String getMimeTypeFromInputStream(InputStream is) throws IOException {
        String mimeType = URLConnection.guessContentTypeFromStream(is);
        return mimeType;
    }


    public String getMimeTypeFromByteArray(byte data[]) throws Exception {
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
        String mimeType = URLConnection.guessContentTypeFromStream(is);
        return mimeType;
    }

    public File convertByteArrayToFile(byte[] file, String path) throws IOException {
        File fileConverted = new File(path);
        OutputStream
                os
                = new FileOutputStream(fileConverted);

        // Starts writing the bytes in it
        os.write(file);
        return fileConverted;
    }

    public XMLGregorianCalendar convertToXMLGregorianCalendar(String d) throws DatatypeConfigurationException, ParseException {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format.parse(d);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        return xmlGregCal;
    }


    public String convertByteArrayToStringXml(byte[] file) {
        String converted = new String(file, StandardCharsets.UTF_8);
        return converted;
    }

    public Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
/*
    public HashMap<String, Document> joinHashMap(HashMap<String, Document> map1, HashMap<String, Document> map2 ) {
        HashMap<String, Document> map3 = EntryStream.of(map1)
                .append(EntryStream.of(map2))
                .toMap((e1, e2) -> e1);
        return  map3;
    }*/





    public byte[] convertFileToByteArray(File fileToCheck) {
        FileInputStream fis = null;
        // Creating a byte array using the length of the file
        // file.length returns long which is cast to int
        byte[] bArray = new byte[(int) fileToCheck.length()];
        try {
            fis = new FileInputStream(fileToCheck);
            fis.read(bArray);
            fis.close();

        } catch (IOException ioExp) {
            ioExp.printStackTrace();
        }
        return bArray;
    }

    public byte[] convertInputStreamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        byte[] byteArray = buffer.toByteArray();
        return byteArray;
    }
}
