import gui_fields.GUI_Player;
import gui_main.GUI;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        GUI gui = new GUI();

        int playerNum = 0;

        String choice = gui.getUserButtonPressed(
                "Number of players", "1","2","3","4");
        if(choice.equals("1")){playerNum = 1;}
        if(choice.equals("2")){playerNum = 2;}
        if(choice.equals("3")){playerNum = 3;}
        if(choice.equals("4")){playerNum = 4;}

        GUI_Player[] players = new GUI_Player[playerNum];
        String[] playerNames = new String[playerNum];

        for(int i = 0; i < playerNum; i++){
            String name = gui.getUserString(
                    "Name for player " + (i+1) + ": ");
            players[i] =  new GUI_Player(name);
            playerNames[i] = players[i].getName();

        }



        gui.showMessage(Arrays.toString(playerNames));



    }

}
