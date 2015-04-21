package com.personalcapital.financialplanning.Helper;

/**
 /////////////////////////////////////////////////////////////////////////////
 // CalculateSpending.java - Helper class to calculate the average spending //
 //					         and annual spending of each given financial    //
 //					         account                                        //
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
 * ----------------
 * HashMap<FinancialAccount, ArrayList<SpendingTransaction>> transMap;
 * int spending = CalculateSpending.annualSpendingforUser(transMap);
 * int avgSpending = CalculateSpending.averageSpendingforUser(transMap);
 *
 */


import com.personalcapital.financialplanning.account.FinancialAccount;
import com.personalcapital.financialplanning.transaction.SpendingTransaction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CalculateSpending {

    //------<Calculate the annual spending and also scales the spending as per account opened date>---------------
    private static Double annualSpending(FinancialAccount financialAccount) {
        double sum = 0.00;
        for(SpendingTransaction st : financialAccount.getSpendingTransactionList()) {
            if(st.getExpDate().after(DateHelper.getRollingDate()) &&
                    st.getExpDate().before(DateHelper.CURRENT_DATE)&&
                    st.getExpDate().after(financialAccount.getDateOpened()))
            {
                sum += st.getExpAmount();
            }
        }
        if(DateHelper.getRollingDate().before(financialAccount.getDateOpened()))//to scale the spending
        {
            int diffYear = DateHelper.CURRENT_DATE.get(Calendar.YEAR) - financialAccount.getDateOpened().get(Calendar.YEAR);
            int monthsOpen = diffYear * 12 + DateHelper.CURRENT_DATE.get(Calendar.MONTH) - financialAccount.getDateOpened().get(Calendar.MONTH);
            if(DateHelper.CURRENT_DATE.get(Calendar.DATE)>financialAccount.getDateOpened().get(Calendar.DATE))
                monthsOpen++;
            int scaleFor =  financialAccount.getDateOpened().get(Calendar.MONTH) - DateHelper.getRollingDate().get(Calendar.MONTH);
            if(monthsOpen>0)
            sum = sum * (scaleFor + monthsOpen) / monthsOpen;
        }
        return sum;
    }
    //------<Calculate the average spending(relative to scaled expenditure)>---------------
    private static Double averageSpending(FinancialAccount financialAccount) {
        double sum = annualSpending(financialAccount);
        int diffYear = DateHelper.CURRENT_DATE.get(Calendar.YEAR) - DateHelper.getRollingDate().get(Calendar.YEAR);
        int monthsOpen = diffYear * 12 + DateHelper.CURRENT_DATE.get(Calendar.MONTH) - DateHelper.getRollingDate().get(Calendar.MONTH);
        if(DateHelper.CURRENT_DATE.get(Calendar.DATE)>financialAccount.getDateOpened().get(Calendar.DATE))
            monthsOpen++;
        if(monthsOpen == 0)
            monthsOpen = 1;
        return sum/monthsOpen;
    }

    public static Double annualSpendingforUser(HashMap<FinancialAccount, ArrayList<SpendingTransaction>> transMap)
    {
        Double annual = 0.00;
        for (FinancialAccount entry : transMap.keySet()) {
            annual+=annualSpending(entry);
        }
        return annual/transMap.size();
    }
    public static Double monthlyAverageforUser(HashMap<FinancialAccount, ArrayList<SpendingTransaction>> transMap)
    {
        Double sum = 0.00;
        for (FinancialAccount entry : transMap.keySet()) {
            sum+=averageSpending(entry);
        }
        return sum/transMap.size();
    }
}
