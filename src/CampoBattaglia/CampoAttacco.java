package CampoBattaglia;

public class CampoAttacco extends CampoGenerale
{

    public CampoAttacco()
    {
        for(int i = 0; i < dimensione; i++)
            for(int j = 0; j < dimensione; j++)
                campo[i][j] = "A";
    }

    public void cellaAttaccata(int x, int y)
    {

        //TODO
        //questa cosa sarebbe da fare con i socket dove mando le coordinate e quando ricevo la risposta
        //vedere con il if, quindi non ci dovrebbero essere variabili formali nella funzione, (placeholder)

        //ci sarà l'opposto nell altro campo con le mie navi dove io aspetterò la risposta e poi sarò io a rispondere

        if(campo[x][y].equals("N"))
            campo[x][y] = "C";
        else
            campo[x][y] = "M"; 
    }
}
