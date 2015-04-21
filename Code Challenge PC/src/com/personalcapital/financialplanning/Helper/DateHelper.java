package com.personalcapital.financialplanning.Helper;

/**
 /////////////////////////////////////////////////////////////////////////////
 // DateHelper.java - Helper class to get and set the rolling date as well  //
 //					  the current date.                                     //
 // ver 1.0                                                                 //
 // ----------------------------------------------------------------------- //
 // copyright © Ankit Kumar, 2015                                           //
 // All rights granted provided that this notice is retained                //
 // ----------------------------------------------------------------------- //
 // Language:    Java JDK 1.8, IntelliJ IDEA 14.0.2                         //
 // Platform:    Asus ROG GL551JM-EH71, Core i7, Windows 8.1 64-bit         //
 // Application: Personal Capital code challenge , 2015                     //
 // Author:      Ankit Kumar, Syracuse University						    //
 //              (315) 728-8955, akumar15@syr.edu	                        //
 /////////////////////////////////////////////////////////////////////////////
 *
 * Public Interface:
 * -----------------
 * Calendar currDate = DateHelper.CURRENT_DATE;
 * Calendar date = DateHelper.getRollingDate();
 *
 */


import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateHelper {

    //------<Get the current date>---------------
    public static Calendar CURRENT_DATE= new GregorianCalendar();

    //------<Get the rolling date for past year>---------------
    public static Calendar getRollingDate() {
        Calendar START_ROLLING_DATE = new GregorianCalendar();
        START_ROLLING_DATE.set(Calendar.MONTH, Calendar.JANUARY);
        START_ROLLING_DATE.set(Calendar.DATE, 1);
        if (CURRENT_DATE.get(Calendar.MONTH) < Calendar.JANUARY)//setting rolling date from April 1 of each financial year
            START_ROLLING_DATE.set(Calendar.YEAR, CURRENT_DATE.get(Calendar.YEAR) - 1);
        //System.out.println(START_ROLLING_DATE.getTime());
        //System.out.println(CURRENT_DATE.getTime());
        return START_ROLLING_DATE;
    }
}
