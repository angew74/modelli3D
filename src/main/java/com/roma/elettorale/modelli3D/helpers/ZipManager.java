package com.roma.elettorale.modelli3D.helpers;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Component
public class ZipManager {

    public HashMap<String, Document> unZipFolder(File fileToCheck) {
        HashMap<String, Document> files = new HashMap<>();
        try {
            ZipFile zip = new ZipFile(fileToCheck);
            for (Enumeration e = zip.entries(); e.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) e.nextElement();
                if (!entry.isDirectory()) {
                    if (FilenameUtils.getExtension(entry.getName()).equals("xml")) {
                        Document out = getTxtFiles(zip.getInputStream(entry));
                        files.put(entry.getName(), out);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return files;
    }

    public Document getTxtFiles(InputStream in) throws UnsupportedEncodingException {
        Document doc = null;
        try {
            Reader reader = new InputStreamReader(in, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
        } catch (IOException e) {
            // do something, probably not a text file
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
