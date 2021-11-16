
import gui_main.GUI;
import gui_fields.GUI_Field;

public class Matador {
    public static void main(String[] args) {
        GUI gui = new GUI();

        /*
        //Player player = new Player();
        Player player2 = new Player();

        Player players[] = new Player[3];
        for (Player player : players) {
            turn(player);
        }*/
    }

    public static void turn(Player player) {
        int roll = DieCup.roll();

        for (int i = player.getPosition(); i < player.getPosition() + roll; i++) {
            GameBoard.getSquare(i % GameBoard.length()).passBy(player);
        }
        player.setPosition((player.getPosition() + roll) % GameBoard.length());
        GameBoard.getSquare(player.getPosition()).landOn(player);
    }

    }

