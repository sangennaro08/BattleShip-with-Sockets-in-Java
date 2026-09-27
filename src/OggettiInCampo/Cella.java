package OggettiInCampo;

public class Cella
{

    private int x;
    private int y;

    public enum status 
    {
        A('A'),
        N,
        C,
        M;
    }
    
    public int getX(){return x;}
    public int getY(){return y;}


}
