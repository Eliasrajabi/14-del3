public class Amusement extends Square {
    @Override
    void landOn(Player player) {
        System.out.println("Du landte på amusement");
    }

    @Override
    public String toString() {
        return "Amusement";
    }
}
