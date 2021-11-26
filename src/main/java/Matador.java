import gui_codebehind.GUI_FieldFactory;
import gui_main.GUI;
import java.io.IOException;

public class Matador {

    GUI gui = new GUI();

    private final DieCup dieCup = new DieCup(1);
    private final GameBoard gameBoard = GameBoard.getInstance();
    private Player currentPlayer;
    private int playerNum = 0;

    private final int BOARD_SIZE = gameBoard.length();
    private boolean hasWinner = false;


    Player[] players;
    String[] playerNames;

    public Matador() throws IOException {
    }


    public void MatadorGame() throws IOException {
        initializePlayers();
        play();
    }

    private void initializePlayers() {
        final String choice = gui.getUserButtonPressed(
                "Number of players",  "2", "3", "4");
        if (choice.equals("2")) {
            playerNum = 2;
        }
        if (choice.equals("3")) {
            playerNum = 3;
        }
        if (choice.equals("4")) {
            playerNum = 4;
        }
        players = new Player[playerNum];
        playerNames = new String[playerNum];

        for (int i = 0; i < playerNum; i++) {

            players[i] = new Player();
            String name = gui.getUserString(
                    "Name for player " + (i + 1) + ": ");

            players[i].setPlayerName(name);
            playerNames[i] = players[i].getPlayerName();
        }
    }

    public void play() throws IOException {
        int i = 0;

        do {
            currentPlayer = players[(i++) % playerNum];
            turn();

        } while (!hasWinner);
    }

    public void turn() throws IOException {
        gui.showMessage("Player " + currentPlayer.getPlayerName() + "'s turn");
        gui.showMessage("Roll Dice");
        dieCup.rollDice();

        gui.showMessage("You rolled a " + dieCup.getSum());
        updatePosition(dieCup.getSum());
        handleField(currentPlayer);

    }

    private void updatePosition(int sum) {

        if (currentPlayer.getPosition() + sum >= BOARD_SIZE) {
            currentPlayer.setPosition(currentPlayer.getPosition() + sum - BOARD_SIZE);
            handleGO();
        } else {
            currentPlayer.setPosition(currentPlayer.getPosition() + sum);
        }
    }

    private void handleField(Player player) throws IOException {
        String fieldType = gameBoard.getSquare(player.getPosition()).getFieldType();
        switch (fieldType) {
            case "Amusement" -> handleAmusement();
            case "Chance" -> handleChance();
            default -> {
            }
        }

    }

    private void payPlayer(Player owner, int price){
        currentPlayer.account.adjustBalance(-price);
        owner.account.adjustBalance(price);
        gui.showMessage("You landed on an amusement, where you have to pay entrance.");
        gui.showMessage("You paid " + price + "$ to " + owner.getPlayerName());
        gui.showMessage("You now have " + currentPlayer.account.getMoneyTotal() + "$");
        if (isGameOver()){
            endGame();
        }
    }

    private void buyField(Amusement field){
        if(currentPlayer.account.getMoneyTotal() > field.getPrice()) {
            currentPlayer.account.adjustBalance(-field.getPrice());
            field.setBoothOwner(currentPlayer);
            gui.showMessage("You landed on " + field.getName());
            gui.showMessage("You bought a booth here");
        }
        else{
            gui.showMessage("You can't afford a booth here :'(");
        }
    }
    private void handleAmusement(){
        Square field = gameBoard.getSquare(currentPlayer.getPosition());
        Amusement amusement = (Amusement) field;
        if (amusement.getBoothOwner() == null) {
            buyField(amusement);
            gui.showMessage("You now have " + currentPlayer.account.getMoneyTotal() + "$");
        } else {
            payPlayer(amusement.getBoothOwner(), amusement.getPrice());
        }

    }

    private void handleChance() throws IOException{
        gui.showMessage("You landed on chance");
        int cardNumber = (int) (Math.random() * 5 + 1);

        switch (cardNumber) {
            case 1 -> {
                gui.showMessage("Move to Magic Show");
                currentPlayer.setPosition(5);
                handleField(currentPlayer);
            }
            case 2 -> {
                gui.showMessage(Text.getChanceDesc(cardNumber));
                currentPlayer.account.adjustBalance(-2);
                gui.showMessage("You now have " + currentPlayer.account.getMoneyTotal() + "$");
                if (isGameOver()){
                    endGame();
                }
            }
            case 3 -> {
                gui.showMessage("Move to GO");
                currentPlayer.setPosition(0);
                handleGO();
            }
            case 4 -> {
                gui.showMessage(Text.getChanceDesc(cardNumber));
                currentPlayer.account.adjustBalance(2);
                gui.showMessage("You now have " + currentPlayer.account.getMoneyTotal() + "$");
            }
            case 5 -> {
                gui.showMessage("Move to Video Arcade");
                currentPlayer.setPosition(8);
                handleField(currentPlayer);
            }

        }

    }
    private void handleGO(){
        if (currentPlayer.getPosition() == 0) {
            currentPlayer.account.adjustBalance(2);
            gui.showMessage("You landed on GO! You get 2$");
        }
        else {
            currentPlayer.account.adjustBalance(2);
            gui.showMessage("You passed GO! You get 2$");
        }
    }
    private boolean isGameOver (){
        return currentPlayer.account.getMoneyTotal() <= 0;
    }

    private void endGame(){
        hasWinner = true;
        gui.showMessage("A player has lost all their money :( \nThe game is over!");
        printWinner();
    }

    private void printWinner(){
        Player winner = players[0];
        for (Player player: players) {
            if(player.account.getMoneyTotal() > winner.account.getMoneyTotal()){
                winner = player;
            }
        }
        gui.showMessage(winner.getPlayerName() + "HAS WON!!");

    }
}