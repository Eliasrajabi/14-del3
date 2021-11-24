import gui_main.GUI;
import java.io.IOException;

public class Matador {

    GUI gui = new GUI();

    private final DieCup dieCup = new DieCup(1);
    private final GameBoard gameBoard = new GameBoard();
    private Player currentPlayer;
    private int playerNum = 0;

    private final int START_MONEY = 40;
    private final int BOARD_SIZE = gameBoard.length();
    private final boolean hasWinner = false;


    Player[] players = new Player[playerNum];
    String[] playerNames = new String[playerNum];




    public void MatadorGame(){

        final String choice = gui.getUserButtonPressed(
                "Number of players", "1","2","3","4");
        if(choice.equals("1")){playerNum = 1;}
        if(choice.equals("2")){playerNum = 2;}
        if(choice.equals("3")){playerNum = 3;}
        if(choice.equals("4")){playerNum = 4;}

        for(int i = 0; i < playerNum; i++){

            players[i] =  new Player();
            String name = gui.getUserString(
                    "Name for player " + (i+1) + ": ");

            players[i].setPlayerName(name);
            players[i].setStartBalance(START_MONEY);
            playerNames[i] = players[i].getPlayerName();

        }


    }

    public void play() throws IOException {
        int i = 0;

        do {
            currentPlayer = players[i];
            turn(currentPlayer);
            changePlayer(i);
            i++;
        }while (!hasWinner);
    }

    private void turn(Player player) throws IOException {
        dieCup.rollDice();
        updatePosition(dieCup.getSum());


        for (int i = player.getPosition(); i < player.getPosition() + dieCup.getSum(); i++)
        {
            gameBoard.getSquare(i % gameBoard.length()).passBy(player);
        }
        player.setPosition((player.getPosition() + dieCup.getSum()) % gameBoard.length());
        gameBoard.getSquare(player.getPosition()).landOn(currentPlayer);
        if(gameBoard.getSquare().getType() == "Amusement")
            pay(gameBoard.getSquare().getPrice);
    }
    public void takeTurn(){
        gui.showMessage("Roll Dice");
        dieCup.rollDice();
        updatePosition(dieCup.getSum());
        handleField(currentPlayer.getPosition());
    }

    private void updatePosition(int sum)
    {
        if (currentPlayer.getPosition() + sum >= BOARD_SIZE) {
            currentPlayer.setPosition(currentPlayer.getPosition() + sum - BOARD_SIZE);
            currentPlayer.getAccount().adjustBalance(gameBoard.getSquare(0).landOn(currentPlayer));//give them pass start money
        }
        else
            currentPlayer.setPosition(currentPlayer.getPosition() + sum);
    }

    private void pay (int amount)
    {
        // I imagine that this method transfers money to the bank.
    }
    private void pay (Player to, int amount)
    {
        if (currentPlayer.getAccount().getMoneyTotal() <= 0) {System.out.println("FEJL"); return;}
        if (currentPlayer.getAccount().getMoneyTotal() + amount >= 0) {
            to.getAccount().adjustBalance(-amount);
            currentPlayer.getAccount().adjustBalance(amount);
        }else{
            to.getAccount().adjustBalance(currentPlayer.getAccount().getMoneyTotal());
            currentPlayer.getAccount().setMoneyTotal(0);
        }
    }
    private void changePlayer(int i){currentPlayer =  players[i+1];}

    private void handleField(int position){
        String fieldType = new String (board.getSquare(position));
        switch case "Amusement":
        Amusement amusement = (Amusement)(board.getSquare(position);
        if ((amusement.getBoothOwner()== null )){
            pay(amusement.getPrice());
            board.getSquare(currentPlayer, position); // booth added to player inventory
        }
    }else(!currentPlayer.boothOwner){
        pay(Amusement.getBoothOwner, Amusement.);
    }
            break;
}
            case Chance
                    //dette må jeg lige vente med. Men den varetager chancerne.
                    //jeg vurdere, at der ikke er behov for lave en case for GO! men idk.
                    }
//this method is needed to terminate the game.
public boolean paymentPossible(Player player, int amount){
        if(player.getBalance() > amount){
            return true;
        }
        else{
        this.hasWinner = true;
        return false;
        }

        }
public void announceWinner(){

}
}