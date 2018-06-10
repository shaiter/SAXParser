package com.company;

import org.xml.sax.SAXException;

import javax.security.sasl.SaslException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        Handler handler = new Handler();
        try {
            SAXParser parser = parserFactory.newSAXParser();
            parser.parse(new File("/Users/artemsajter/Desktop/ООП/SAXParser/testFiles/feed-test.xml"), handler);

        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
