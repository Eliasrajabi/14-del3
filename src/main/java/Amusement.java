import java.io.IOException;
public class Amusement extends Square{
    //fields
    private final String colour;
    private final String name;
    private final int price;
    private final Player boothOwner = null; //nobody owns a booth, from the beginning of game.


    //constructor - initializer
    public Amusement(String name, String colour, int price)
    {
        this.name = name;
        this.colour = colour;
        this.price = price;
    }

    public int getPrice() {return price;}
    public String getColour() {return colour;}
    public String getName(){return name;}


    public void setBoothOwner(Player boothowner) {
    }
    public Player getBoothOwner()
    {
        return boothOwner;
    }

    @Override
    void landOn(Player player) throws IOException {

    }
}