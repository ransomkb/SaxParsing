/*
 * Created own Handler class by extending DefaultHandler class
 */
package com.hart_book.saxparsing;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author Ransom Barber
 */
public class KanjiHandler extends DefaultHandler
{
    boolean bLiteral = false;
    boolean bReading = false;
    boolean bMeaning = false;
    
    private int count = 0;
    //List to hold Entries object
    private List<KanjiEntry> entList = null;
    private KanjiEntry ent = null;
   
    
    public KanjiHandler()
    {
        entList = new ArrayList<>();   
    }
    //getter method for employee list
    public List<KanjiEntry> getEntryList()
    {
        return entList;
    }
    
   @Override
   public void startElement(String uri, String localName, String qName, Attributes attributes)
           throws SAXException
   {
       /**
       if(count > 99)
       {
           System.out.println("Reached 100");
           System.exit(-1);
       }
       else 
       **/    
       if(qName.equalsIgnoreCase("character"))
       {
           //create a new KanjiEntry and put it in Map
           ent = new KanjiEntry();
           //count++;
           //System.out.println(count);
       }
       else if(qName.equalsIgnoreCase("literal"))
       {
           bLiteral = true;
       }
       else if(qName.equalsIgnoreCase("reading"))
       {
           String type = attributes.getValue("r_type");
           
           if(type.equals("ja_on") || type.equals("ja_kun"))
           {
               bReading = true;
           }
       }
       else if(qName.equalsIgnoreCase("meaning"))
       {
           String lang = attributes.getValue("m_lang");
           
           if(lang == null || lang.equalsIgnoreCase("en"))
           {
               bMeaning = true;
           }
       }
   }
   
   @Override
   public void endElement(String uri, String localName, String qName)
   {
       if(qName.equalsIgnoreCase("character"))
       {
           //add KanjiEntry object to list
           if(ent.isrMean() && ent.isbMean())
           {
                count++;
                System.out.println(count);
                System.out.println(ent.getLiter());
                System.out.println(ent.listToString(ent.readingList));
                System.out.println(ent.listToString(ent.meaningList));
           }
           entList.add(ent);
       }
   }
   
   @Override
   public void characters(char ch[], int start, int length) throws SAXException
   {
       if(bLiteral)
       {
           ent.setLiter(new String(ch, start, length));
           bLiteral = false;
           //System.out.println(ent.getLiter());
       }
       else if(bReading)
       {
           ent.setrMean(bReading);
           ent.readingList.add(new String(ch, start, length));
           bReading = false;
           //System.out.println(new String(ch, start, length));
           //System.out.println(ent.listToString(ent.readingList));
       }
       else if(bMeaning)
       {
           ent.setbMean(bMeaning);
           ent.meaningList.add(new String(ch, start, length));
           bMeaning = false;
           //System.out.println(new String(ch, start, length));
           //System.out.println(ent.listToString(ent.meaningList));
       }
   }
}
