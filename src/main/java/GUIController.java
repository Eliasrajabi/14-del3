import gui_codebehind.GUI_BoardController;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class GUIController {
    GUI guiController;

    {
        guiController = new GUI();
    }

    GUI_Field[] squares = new GUI_Field[13];

    GameBoard gameBoard = new GameBoard();

    public GUI_Field[] getSquares() {

        return squares;
    }

    static GUI gui;

    public GUIController() {
        GUI_BoardController(squares[i]);
        makeGUIFields();
    }

    public void makeGUIFields(){
        squares[0] = new GUI_Start("GO", "", "Land or Pass by GO and gain 2$!", Color.BLACK, Color.red);
        squares[1] = new GUI_Chance("Chance", "", "If you land on Chance you get to draw a card", Color.BLACK, Color.green);
        squares[2] = new GUI_Street("Candy Floss", "", "Stop by and get some candyfloss :)", "Price: 1$", Color.BLACK, Color.blue);
        squares[3] = new GUI_Street("Ballon Stand", "", "Balloons for sale! Grab a balloon", "Price: 1$", Color.BLACK, Color.blue);
        squares[4] = new GUI_Chance("Chance", "", "If you land on Chance you get to draw a card", Color.BLACK, Color.green);
        squares[5] = new GUI_Street("Magic Show", "", "", "Price: 2$", Color.black, Color.CYAN);
        squares[6] = new GUI_Street("Puppet Show", "", "", "Price: 2$", Color.black, Color.CYAN);
        squares[7] = new GUI_Chance("Chance", "", "If you land on Chance you get to draw a card", Color.BLACK, Color.green);
        squares[8] = new GUI_Street("Video Arcade", "", "", "Price: 3$", Color.black, Color.PINK);
        squares[9] = new GUI_Street("Hounted House", "", "", "Price: 3$", Color.black, Color.PINK);
        squares[10] = new GUI_Chance("Chance", "", "If you land on Chance you get to draw a card", Color.BLACK, Color.green);
        squares[11] = new GUI_Street("Pony Ride", "", "", "Price: 4$", Color.black, Color.ORANGE);
        squares[12] = new GUI_Street("Helicopter Ride", "", "", "Price: 4$", Color.black, Color.ORANGE);
    }

    public static void addGUIPlayer (Player player){
        player.GUIplayer = new GUI_Player(player.getPlayerName(),player.account.getMoneyTotal(),new GUI_Car());
        gui.addPlayer(player.GUIplayer);
    }

    public static void GUIBalance(Player player){
        player.GUIplayer.setBalance(player.account.getMoneyTotal());
    }

    public int GUIDie(DieCup diecup){
        gui.getUserButtonPressed("Press button to roll die","Roll");
        gui.setDie(diecup.getSum());
        diecup.rollDice();
        return diecup.getSum();
    }

    public void moveCar() {
    }


}
