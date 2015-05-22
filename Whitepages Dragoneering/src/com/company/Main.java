package com.company;
import java.io.*;
import java.util.ArrayList;
public class Main {
    public static final String FAILURE = "failure";
    public static final String OUT = "out";
    /**
     * Method to get the sequence of array indices
     * @param arrayList : ArrayList of integers that has been given as input
     */
    public static void minFlight(ArrayList<Integer> arrayList) {

        ArrayList<Integer> outList = new ArrayList<Integer>();
        int last = 0, size = arrayList.size();

        if (size > 0 || arrayList.get(0) != 0)
            outList.add(0);
        else{
            System.out.println(FAILURE);
            return;
        }

        while (last + arrayList.get(last) < size) {
            int record = -1;
            int max = 0;
            for (int i = last + 1; i <= last + arrayList.get(last); i++) {
                if (arrayList.get(i) == 0)
                    continue;
                int temp = i + arrayList.get(i);
                if (temp > max) {
                    max = temp;
                    record = i;
                }
            }

            if (record == -1 || arrayList.get(record) == 0) {
                System.out.println(FAILURE);
                return;
            }

            outList.add(record);
            last = record;
        }
        writeOut(outList);
    }

    /**
     * Method to format and write result to STDOUT
     * @param result: Result arrayList that contains the sequence of indices.
     */
    private static void writeOut(ArrayList<Integer> result)
    {
        for (int i : result)
        {
            System.out.print(i + ", ");
        }
        System.out.println(OUT);
    }


    public static void main(String[] args) {
        try {
            ArrayList<Integer> inputList = new ArrayList<Integer>();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while ((str = input.readLine()) != null) {
                if (str.length() == 0)
                    break;
                int val = Integer.parseInt(str);
                if(val>=0)
                    inputList.add(val);     //check for negative numbers
                else {
                    System.out.println(FAILURE);
                    return;
                }
            }
            minFlight(inputList);
        } catch (Exception e) {
            System.out.println(FAILURE);
        }

    }
}