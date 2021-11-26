import java.io.IOException;
public class Amusement extends Square{
    //fields
    private String colour;
    private String name;
    private int price;

    private Player boothOwner = null; //nobody owns a booth, from the beginning of game.


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


    public void setBoothOwner(Player player) {
        boothOwner = player;
    }
    public Player getBoothOwner()
    {
        return boothOwner;
    }


    @Override
    public String toString() {
        return "Amusement";
    }

    @Override
    String getFieldType() {
        return "Amusement";
    }
}
