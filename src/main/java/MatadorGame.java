public class MatadorGame {
    DieCup dieCup = new DieCup(1);
    Player[] players = new Player[]{new Player(), new Player(), new Player()};
    GameBoard gameBoard = new GameBoard();

    public void start(){
        for (Player player : players) {
            turn(player);
        }
    }

    public void turn(Player player) {
        int[] rollDice = dieCup.rollDice();
        int roll = dieCup.getSum();

        for (int i = player.getPosition(); i < player.getPosition() + roll; i++) {
            gameBoard.getSquare(i % gameBoard.length()).passBy(player);
        }
        player.setPosition((player.getPosition() + roll) % gameBoard.length());
        gameBoard.getSquare(player.getPosition()).landOn(player);
    }


}
