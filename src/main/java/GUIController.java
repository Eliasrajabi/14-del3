import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;
import gui_fields.GUI_Board;

import java.util.Objects;

public class GUIController {
    GUIController gui = new GUIController();
    GUI_Field[] squares = new GUI_Field[11];
    GUI board;
    GameBoard gameBoard = new GameBoard();

    public GUIController() {
        squares[0] = new GUI_Street();
        squares[1] = new GUI_Street();
        squares[2] = new GUI_Street();
        squares[3] = new GUI_Street();
        squares[4] = new GUI_Street();
        squares[5] = new GUI_Street();
        squares[6] = new GUI_Street();
        squares[7] = new GUI_Street();
        squares[8] = new GUI_Street();
        squares[9] = new GUI_Street();
        squares[10] = new GUI_Street();
        squares[11] = new GUI_Street();
    }

      /*  String choseAmusement = gui.getUserButtonPressed(
                "Chose an Amusement",
                "Button 1", "Button 2","Button 3","Button 4"
        );
        if(Objects.equals(choseAmusement, "Button 1")){
            gameBoard.getSquare(3).landOn(player);}
        if(Objects.equals(choseAmusement, "Button 2")){
            gameBoard.getSquare(4).landOn(player);}
        if(Objects.equals(choseAmusement, "Button 3")){
            gameBoard.getSquare(5).landOn(player);}
        if(Objects.equals(choseAmusement, "Button 4")){
            gameBoard.getSquare(6).landOn(player);}

    public String getUserButtonPressed(String click_a_button, String s, String s1, String s3, String s4) {
        return null;
    } */
}
