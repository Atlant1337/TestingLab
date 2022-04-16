package com.testing.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class SaxParserDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("astronomy.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    boolean bname = false;
    boolean bgroup = false;
    boolean bmagnitude = false;
    boolean bdiameter = false;
    boolean bcharacteristic = false;
    boolean bdiscoverer = false;
    boolean byear = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("satellite")) {
            String rollNo = attributes.getValue("tag2ID");
            System.out.println("\nRoll No : " + rollNo);
        } else if (qName.equalsIgnoreCase("name")) {
            bname = true;
        } else if (qName.equalsIgnoreCase("group")) {
            bgroup = true;
        } else if (qName.equalsIgnoreCase("magnitude")) {
            bmagnitude = true;
        } else if (qName.equalsIgnoreCase("diameter")) {
            bdiameter = true;
        } else if (qName.equalsIgnoreCase("characteristic")) {
            bcharacteristic = true;
        } else if (qName.equalsIgnoreCase("discoverer")) {
            bdiscoverer = true;
        } else if (qName.equalsIgnoreCase("year")) {
            byear = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("satellite")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bname) {
            System.out.println("Satellite Name : " + new String(ch, start, length));
            bname = false;
        } else if (bgroup) {
            System.out.println("Group : " + new String(ch, start, length));
            bgroup = false;
        } else if (bmagnitude) {
            System.out.println("Magnitude : " + new String(ch, start, length));
            bmagnitude = false;
        } else if (bdiameter) {
            System.out.println("Diameter : " + new String(ch, start, length));
            bdiameter = false;
        } else if (bcharacteristic) {
            System.out.println("Characteristic : " + new String(ch, start, length));
            bcharacteristic = false;
        } else if (bdiscoverer) {
            System.out.println("Discoverer : " + new String(ch, start, length));
            bdiscoverer = false;
        } else if (byear) {
            System.out.println("Year : " + new String(ch, start, length));
            byear = false;
        }
    }
}