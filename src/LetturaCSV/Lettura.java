package LetturaCSV;

import java.io.BufferedReader;
import java.io.FileReader;

public class Lettura
{

    public void leggiCSV(String [][] campo)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("campo.csv")))
        {
            String riga;
            int numeroRiga = 0;

            while((riga = reader.readLine()) != null)
            {
                campo[numeroRiga] = riga.split(",");
                numeroRiga++;
            }
            
        }catch(Exception e)
        {
            System.out.println("file letto in modo errato");
        }
    }  
}
