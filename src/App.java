import CampoBattaglia.Campo;
import ScritturaCSV.Scrittura;

public class App {
    public static void main(String[] args) throws Exception {
        
        Campo c = new Campo();

        c.inserisciNavi();

        Scrittura write = new Scrittura();

        write.createFileCSV(c.campo);
    }
}
