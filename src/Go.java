public class Go {

    // If a player land on Go!, will get 2 $
    @Override
    void landOn(Player player) {
        player.addToTotal(2);
        System.out.println("you landed on Go!" + " you get 2 $");
    }
    // If a player passed by Go!, will get 2 $
    @Override
    void passby (Player player){
        player.addToTotal(2);
        System.out.println("you passed by Go!" + " you get 2 $");
}
