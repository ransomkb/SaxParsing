/*
 * test program that uses KanjiHandler to parse XML to an object
 * 
 */
package com.hart_book.saxparsing;

import java.io.File;
import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.ByteArrayInputStream;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;

/**
 *
 * @author Ransom Barber
 */
public class SaxParsing 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try 
        {
            saxParserFactory.setFeature("http://xml.org/sax/features/validation", false);
        }  
        catch (SAXNotRecognizedException | SAXNotSupportedException e) 
        {
            System.out.println(e.getMessage());
        }
        catch (ParserConfigurationException e) 
        {
            System.out.println(e.getMessage());
        }
            
        saxParserFactory.setValidating(false);
        
        try
        {
            //System.out.println(System.getProperty("file.encoding"));
            //System.out.println("Got to try");
            SAXParser saxParser = saxParserFactory.newSAXParser();
            
            KanjiHandler handler = new KanjiHandler();
            saxParser.parse(new File ("src/saxparsing/kanjidic2.xml"), handler);
            //Get KanjiEntry list
            List<KanjiEntry> entryList = handler.getEntryList();
            //print entry information
            //for(KanjiEntry ent : entryList)
                //System.out.println(ent);
            
            System.out.println("Parsed and out");
        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            System.out.println(e.getMessage());
        }
        //System.out.println("defaultCharacterEncoding by code after updating file.encoding : " + getDefaultCharEncoding());
    }
    /**
    public static String getDefaultCharEncoding()
    {
        byte [] bArray = {'w'};
        InputStream is = new ByteArrayInputStream(bArray);
        InputStreamReader reader = new InputStreamReader(is);
        String defaultCharacterEncoding = reader.getEncoding();
        return defaultCharacterEncoding;
    }
    */
}
