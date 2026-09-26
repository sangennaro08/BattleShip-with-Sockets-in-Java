package ScritturaCSV;

import java.io.BufferedWriter;
import java.io.FileWriter;

import CampoBattaglia.Campo;

public class Scrittura
{

    public void createFileCSV(String [][] campo)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("campo.csv")))
        {
            for(String[] riga : campo)
            {
                for(int j = 0; j < riga.length; j++)
                    writer.write( (j != riga.length - 1) ? riga[j] + "," : riga[j]);

                writer.newLine();    
            }

            writer.close();

        } catch (Exception e)
        {
            System.out.println("File CSV non completato");
        }
    }

}
