package com.testing.SAX;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxQueryDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("astronomy.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler2 userhandler = new UserHandler2();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class UserHandler2 extends DefaultHandler {

    boolean bname = false;
    boolean bgroup = false;
    boolean bmagnitude = false;
    boolean bdiameter = false;
    boolean bcharacteristic = false;
    boolean bdiscoverer = false;
    boolean byear = false;
    String rollNo = null;

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("satellite")) {
            rollNo = attributes.getValue("tag2ID");
        }
//        System.out.println("rollNo" +rollNo);
        if("001".equals(rollNo) && qName.equalsIgnoreCase("satellite")) {
            System.out.println("Start Element :" + qName);
        }
        if (qName.equalsIgnoreCase("name")) {
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
    public void endElement(
            String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("satellite")) {

            if(("001").equals(rollNo)
                    && qName.equalsIgnoreCase("satellite"))
                System.out.println("End Element :" + qName);
        }
    }


    @Override
    public void characters(
            char ch[], int start, int length) throws SAXException {

        if (bname && ("001").equals(rollNo)) {

            System.out.println("Satellite Name : " + new String(ch, start, length));
            bname = false;
        } else if (bgroup && ("001").equals(rollNo)) {
            System.out.println("Group : " + new String(ch, start, length));
            bgroup = false;
        } else if (bmagnitude && ("001").equals(rollNo)) {
            System.out.println("Magnitude : " + new String(ch, start, length));
            bmagnitude = false;
        } else if (bdiameter && ("001").equals(rollNo)) {
            System.out.println("Diameter : " + new String(ch, start, length));
            bdiameter = false;
        } else if (bcharacteristic && ("001").equals(rollNo)) {
            System.out.println("Characteristic : " + new String(ch, start, length));
            bcharacteristic = false;
        } else if (bdiscoverer && ("001").equals(rollNo)) {
            System.out.println("Discoverer : " + new String(ch, start, length));
            bdiscoverer = false;
        } else if (byear && ("001").equals(rollNo)) {
            System.out.println("Year : " + new String(ch, start, length));
            byear = false;
        }
    }
}