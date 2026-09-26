package CampoBattaglia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/*
    
    Dove aggiungo acqua decido di usare uno String "Ac" senza creare la classe

    l'inserimento delle navi è randomico, assieme alla sua direzione, posizioni decenti


    rimuove prima occorrenza di quel numero
    numeri.remove(Integer.valueOf(10));
 */

public class Campo extends CampoGenerale
{
    private final Random rand = new Random();

    private ArrayList<Integer> lunghezzaNave = new ArrayList<>(
            Arrays.asList(5, 4, 4, 3, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1));

    public Campo()
    {
        for(int i = 0; i < dimensione; i++)
            for(int j = 0; j < dimensione; j++)
                campo[i][j] = "A";
    }

    public int getDimensione(){return dimensione;}

    public void inserisciNavi()
    {

        for( ; !lunghezzaNave.isEmpty() ; )
            TrovaPosizioneNave((int)lunghezzaNave.remove(rand.nextInt(lunghezzaNave.size())));
        
    }

    private void TrovaPosizioneNave(int lunghezza)
    {

        boolean trovaPosizione = false;

        while(!trovaPosizione)
        {
            int x = rand.nextInt(dimensione);
            int y = rand.nextInt(dimensione);

            boolean orizzontale = rand.nextBoolean();

            if(orizzontale && ( y - lunghezza < 0 || y + lunghezza >= dimensione))
                continue;
            
            if(!orizzontale && ( x - lunghezza < 0 || x + lunghezza >= dimensione))
                continue;

            if(!controlloSpaziVicini(x, y, orizzontale, lunghezza))
                continue;

            if(orizzontale)
                posizionaNaveOrizzontale(x, y, lunghezza);
            else
                posizionaNaveVerticale(x, y, lunghezza);
                
            trovaPosizione = !trovaPosizione;
        }
    }

    private boolean controlloSpaziVicini(int x, int y, boolean orizzontale, int lunghezza)
    {
        // Controllo di sovrapposizione e spazi vicini
        // Controlliamo l'area circostante cioè +-1 della nave
        int rigaInizio = Math.max(0, x - 1);
        int rigaFine = Math.max(0, (orizzontale ? x + 1 : x + lunghezza));
        
        int colInizio = Math.max(0, y - 1);
        int colFine = Math.max(0, (orizzontale ? y + lunghezza : y + 1));

        // controllo outofbounds
        rigaFine = Math.min(dimensione - 1, rigaFine);
        colFine = Math.min(dimensione - 1, colFine);

        for (int i = rigaInizio; i <= rigaFine; i++)
            for (int j = colInizio; j <= colFine; j++) 
                if (campo[i][j].contains("N")) 
                    return false; 
                
        return true;
    }

    private void posizionaNaveVerticale(int x , int y, int lunghezza)
    {
        for(int limite = x + lunghezza; x < limite; x++)
            campo[x][y] = "N";
    }

    private void posizionaNaveOrizzontale(int x , int y, int lunghezza)
    {
        for(int limite = y + lunghezza; y < limite; y++)
            campo[x][y] = "N";
    }

    //TODO
    //1)vedere se la nave è affondata o meno
    //2)cambio di lettera quando viene colpito la cella
    
}