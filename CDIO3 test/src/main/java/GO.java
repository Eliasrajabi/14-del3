public class GO extends Square {

    @Override
    void landOn(Player player) {
        player.addToTotal(2);
    }
}
