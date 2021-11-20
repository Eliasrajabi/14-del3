public class amusement extends square{
    //fields
    private final String colour;
    private final int price;
    private Player boothOwner = null; //nobody owns a booth, from the beginning of game.

    //constructor - initializer
    public amusement (String name, String colour, int position, int price)
    {
        super(name,position)//inharented variables.
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

    public void setBoothOwner(Player boothowner)
    {
        this.boothOwner=boothOwner;
    }
    public Player getBoothOwner()
    {
        return boothOwner;
    }
}