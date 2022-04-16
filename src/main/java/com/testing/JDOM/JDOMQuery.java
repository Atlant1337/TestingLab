package com.testing.JDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class JDOMQuery {
    public static void main(String[] args) {
        try{
            File inputFile = new File("astronomy.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.print("Root element : ");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList tag2 = doc.getElementsByTagName("satellite");

            for(int i = 0; i < tag2.getLength(); i++){
                Node node = tag2.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getAttribute("tag2ID");
                    if (id.equals("003")) {

                        System.out.print("\nCurrent element : ");
                        System.out.println(node.getNodeName());

                        System.out.println("Satellite Name : "
                                + element
                                .getElementsByTagName("name")
                                .item(0)
                                .getTextContent());
                        System.out.println("Group : "
                                + element
                                .getElementsByTagName("group")
                                .item(0)
                                .getTextContent());
                        System.out.println("Magnitude : "
                                + element
                                .getElementsByTagName("magnitude")
                                .item(0)
                                .getTextContent());
                        System.out.println("Diameter : "
                                + element
                                .getElementsByTagName("diameter")
                                .item(0)
                                .getTextContent());
                        System.out.println("Characteristics : "
                                + element
                                .getElementsByTagName("characteristics")
                                .item(0)
                                .getTextContent());
                        System.out.println("Discoverer : "
                                + element
                                .getElementsByTagName("discoverer")
                                .item(0)
                                .getTextContent());
                        System.out.println("Year : "
                                + element
                                .getElementsByTagName("year")
                                .item(0)
                                .getTextContent());
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}