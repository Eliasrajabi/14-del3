public class GO extends Square {

    @Override
    void landOn(Player player) {
        player.adjustBalance(2);
        System.out.println("Du landte på GO!");
    }

    @Override
    void passBy(Player player) {
        super.passBy(player);
        player.adjustBalance(2);
        System.out.println("You passed GO! You get 2$");
    }

    @Override
    public String toString() {
        return "GO!";
    }
}