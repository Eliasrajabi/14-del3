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
        System.out.println("\nPlayer " + currentPlayer.getPlayerName() + "'s turn");
        gui.showMessage("Roll Dice");
        dieCup.rollDice();
        System.out.println("You rolled a " + dieCup.getSum());
        updatePosition(dieCup.getSum());
        handleField(currentPlayer);

    }

    private void updatePosition(int sum) throws IOException {

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
            case "Amusement":
                handleAmusement();
                break;

            case "Chance":
                handleChance();
                break;

            default:
                break;
        }

    }

    private void payPlayer(Player owner, int price){
        currentPlayer.account.adjustBalance(-price);
        owner.account.adjustBalance(price);
        System.out.println("You landed on an amusement, where you have to pay entrance.");
        System.out.println("You paid " + price + "$ to " + owner.getPlayerName());
        System.out.println("You now have " + currentPlayer.account.getMoneyTotal() + "$");
        if (isGameOver()){
            endGame();
        }
    }

    private void buyField(Amusement field){
        if(currentPlayer.account.getMoneyTotal() > field.getPrice()) {
            currentPlayer.account.adjustBalance(-field.getPrice());
            field.setBoothOwner(currentPlayer);
            System.out.println("You landed on " + field.getName());
            System.out.println("You bought a booth here");
        }
        else{
            System.out.println("You can't afford a booth here :'(");
        }
    }
    private void handleAmusement(){
        Square field = gameBoard.getSquare(currentPlayer.getPosition());
        Amusement amusement = (Amusement) field;
        if (amusement.getBoothOwner() == null) {
            buyField(amusement);
            System.out.println("You now have " + currentPlayer.account.getMoneyTotal() + "$");
        } else {
            payPlayer(amusement.getBoothOwner(), amusement.getPrice());
        }

    }

    private void handleChance() throws IOException{
        System.out.println("You landed on chance");
        int cardNumber = (int) (Math.random() * 5 + 1);

        switch (cardNumber) {
            case 1 -> {
                System.out.println("Move to Magic Show");
                currentPlayer.setPosition(5);
                handleField(currentPlayer);
            }
            case 2 -> {
                System.out.println(Text.getChanceDesc(cardNumber));
                currentPlayer.account.adjustBalance(-2);
                System.out.println("You now have " + currentPlayer.account.getMoneyTotal() + "$");
                if (isGameOver()){
                    endGame();
                }
            }
            case 3 -> {
                System.out.println();
                System.out.println("Move to GO");
                currentPlayer.setPosition(0);
                handleGO();
            }
            case 4 -> {
                System.out.println(Text.getChanceDesc(cardNumber));
                currentPlayer.account.adjustBalance(2);
                System.out.println("You now have " + currentPlayer.account.getMoneyTotal() + "$");
            }
            case 5 -> {
                System.out.println("Move to Video Arcade");
                currentPlayer.setPosition(8);
                handleField(currentPlayer);
            }

        }

    }
    private void handleGO() throws IOException {
        if (currentPlayer.getPosition() == 0) {
            currentPlayer.account.adjustBalance(2);
            System.out.println("You landed on GO! You get 2$");
        }
        else {
            currentPlayer.account.adjustBalance(2);
            System.out.println("You passed GO! You get 2$");
        }
    }
    private boolean isGameOver (){
        return currentPlayer.account.getMoneyTotal() <= 0;
    }

    private void endGame(){
        hasWinner = true;
        System.out.println("A player has lost all their money :( \nThe game is over!");
        printWinner();
    }

    private void printWinner(){
        Player winner = players[0];
        for (Player player: players) {
            if(player.account.getMoneyTotal() > winner.account.getMoneyTotal()){
                winner = player;
            }
        }
        System.out.println(winner.getPlayerName() + "HAS WON!!");

    }
}