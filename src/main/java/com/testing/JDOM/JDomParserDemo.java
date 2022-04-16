package com.testing.JDOM;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class JDomParserDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("astronomy.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("satellite");
            System.out.println("----------------------------");

                        for(int temp = 0; temp < nList.getLength(); temp++){
                            Node nNode = nList.item(temp);
                            System.out.println("\nCurrent Element : "+nNode.getNodeName());

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;

                                System.out.println("Satellite ID : "
                                        + eElement.getAttribute("tag2ID"));
                                System.out.println("Satellite Name : "
                                        + eElement
                                        .getElementsByTagName("name")
                                        .item(0)
                                        .getTextContent());
                                System.out.println("Group : "
                                        + eElement
                                        .getElementsByTagName("group")
                                        .item(0)
                                        .getTextContent());
                                System.out.println("Magnitude : "
                                        + eElement
                                        .getElementsByTagName("magnitude")
                                        .item(0)
                                        .getTextContent());
                                System.out.println("Diameter : "
                                        + eElement
                                        .getElementsByTagName("diameter")
                                        .item(0)
                                        .getTextContent());
                                System.out.println("Characteristics : "
                                        + eElement
                                        .getElementsByTagName("characteristics")
                                        .item(0)
                                        .getTextContent());
                                System.out.println("Discoverer : "
                                        + eElement
                                        .getElementsByTagName("discoverer")
                                        .item(0)
                                        .getTextContent());
                                System.out.println("Year : "
                                        + eElement
                                        .getElementsByTagName("year")
                                        .item(0)
                                        .getTextContent());
                                System.out.println("\n");
                                  System.out.println("==============================================");
                            }
                        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}