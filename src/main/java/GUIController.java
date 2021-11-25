import gui_fields.*;
import gui_main.GUI;

import java.util.Objects;

public class GUIController {
    GUI_Field[] squares = new GUI_Field[13];
    GUI board;
    GameBoard gameBoard = new GameBoard();

    public GUIController() {
        squares[0] = new GUI_Start();
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
        squares[12] = new GUI_Street();
    }



}
