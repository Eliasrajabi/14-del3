public class Die {
    private int eyes;

    public Die(){
        this.eyes = (int)(Math.random()*6+1);
    }

    public int roll(){
        this.eyes = (int)(Math.random()*6+1);
        return eyes;
    }

    public int getEyes(){
        return eyes;
    }
}