package com.testing.JDOM;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class JDOMCreate {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.newDocument();

            Element rootElement = doc.createElement("astronomy");
            doc.appendChild(rootElement);
            Element commonObjects = doc.createElement("planet");
            Attr atrib = doc.createAttribute("name");
            atrib.setValue("Jupiter");
            commonObjects.setAttributeNode(atrib);
            rootElement.appendChild(commonObjects);
            Attr atrib2 = doc.createAttribute("Id");
            atrib2.setValue("1");
            commonObjects.setAttributeNode(atrib2);
            rootElement.appendChild(commonObjects);

            Element sat = doc.createElement("satellite");
            Attr atrib3 = doc.createAttribute("tag2ID");
            atrib3.setValue("001");
            sat.setAttributeNode(atrib3);
            commonObjects.appendChild(sat);

            Element cat1 = doc.createElement("name");
            cat1.appendChild(doc.createTextNode("Metis"));
            sat.appendChild(cat1);

            Element cat2 = doc.createElement("group");
            cat2.appendChild(doc.createTextNode("Inner"));
            sat.appendChild(cat2);

            Element cat3 = doc.createElement("magnitude");
            cat3.appendChild(doc.createTextNode("10.5"));
            sat.appendChild(cat3);

            Element cat4 = doc.createElement("diameter");
            cat4.appendChild(doc.createTextNode("45km"));
            sat.appendChild(cat4);

            Element cat5 = doc.createElement("characteristics");
            Element cat6 = doc.createElement("characteristic");
            Element cat7 = doc.createElement("characteristic");
            cat6.appendChild(doc.createTextNode("Inclination = 2.226"));
            cat7.appendChild(doc.createTextNode("Eccentricity = 0.0077"));
            cat5.appendChild(cat6);
            cat5.appendChild(cat7);
            sat.appendChild(cat5);

            Element cat8 = doc.createElement("discoverer");
            cat8.appendChild(doc.createTextNode("Synnott"));
            sat.appendChild(cat8);

            Element cat9 = doc.createElement("year");
            cat9.appendChild(doc.createTextNode("1979"));
            sat.appendChild(cat9);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("CreateAstronomy.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}