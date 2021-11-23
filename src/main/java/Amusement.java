import java.io.IOException;
public class Amusement extends Square{
    //fields
    private final String colour;
    private final int price;
    private final Player boothOwner = null; //nobody owns a booth, from the beginning of game.

    //constructor - initializer
    public Amusement(String name, String colour, int position, int price)
    {
        super(name,position);//inharented variables.
        this.colour = colour;
        this.price = price;
    }

    public int getPrice()
    {
        return price;
    }
    public String getColour()
    {
        return colour;
    }

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