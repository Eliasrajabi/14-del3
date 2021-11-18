import java.io.IOException;

public abstract class Square {
    //Alle felterne arver fra denne klasse
    abstract void landOn(Player player) throws IOException; //Da vi skal bruge metoderne fra konto og spiller
    //laver vi et spiller objekt i metoden
    void passBy(Player player) {

    }
}