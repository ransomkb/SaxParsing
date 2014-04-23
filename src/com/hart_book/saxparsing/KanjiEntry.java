/*
 * KanjiEntry object representing entries in dictionaries
 */
package com.hart_book.saxparsing;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Ransom Barber
 */
public class KanjiEntry 
{
    private boolean rMean = false;
    private boolean bMean = false;
    
    //private String charact = "character";
    private String liter;
    //private String reading_meaning;
    //private String rmgroup;
    public List<String> readingList = new ArrayList<>();
    public List<String> meaningList = new ArrayList<>();

    
    public boolean isrMean()
    {
        return rMean;
    }

    public void setrMean(boolean rMean)
    {
        this.rMean = rMean;
    }

    public boolean isbMean()
    {
        return bMean;
    }

    public void setbMean(boolean bMean)
    {
        this.bMean = bMean;
    }
    
    public String getLiter()
    {
        return liter;
    }

    public void setLiter(String liter)
    {
        this.liter = liter;
    }
 
    /**
    public String getCharact() 
    {
        return charact;
    }
    */
    
    @Override
    public String toString()
    {
        return "Entry:: Literal = "+this.liter;
    }
    
    public String listToString(List<String> list)
    {
        //int count = 0;
        String listCat = "";
        Iterator<String> iter = list.iterator();
        
        while(iter.hasNext())
        {
            listCat = listCat + iter.next();
            if(iter.hasNext())
                listCat = listCat + ", ";
        }
        
        return listCat;
    }
}
