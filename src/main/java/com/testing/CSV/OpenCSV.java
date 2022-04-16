package com.testing.CSV;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class OpenCSV {
    public static void main(String[] args)
    {
        CSVReader reader = null;
        try
        {

            reader = new CSVReader(new FileReader("students.csv"));
            String [] nextLine;

            while ((nextLine = reader.readNext()) != null)
            {
                for(String token : nextLine)
                {

                    System.out.println(token);
                }
                System.out.println("\n");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
