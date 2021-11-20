public class Matador {
    private final DieCup dieCup = new DieCup(1);
    private final GameBoard gameBoard = new GameBoard();
    private Player[] players;
    private Player currentPlayer;

    private final int START_MONEY = 40;
    private final int BOARD_SIZE = gameBoard.length();
    private boolean hasWinner = false;

    public MatadorGame(int amount_of_player){
        for (int i= 0; i < amount_of_player; i++) {
            players[i] = new Player();
            players[i].setStartBalance(START_MONEY);
        }
        currentPlayer = players[0];
    }

    public void play(){
        do {
            turn(currentPlayer);
            changePlayer();
        }while (!hasWinner);
    }

    private void turn(Player player) {
        dieCup.rollDice();
        updatePosition(dieCup.getSum());


        for (int i = player.getPosition(); i < player.getPosition() + roll; i++)
        {
            gameBoard.getSquare(i % gameBoard.length()).passBy(player);
        }
        player.setPosition((player.getPosition() + roll) % gameBoard.length());
        gameBoard.getSquare(player.getPosition()).landOn(player);
        if(gameBoard.getSquare().getType() == "Amusement")
            pay(gameBoard.getSquare().getPrice);
    }
    public void takeTurn(){
        input.nextLine();
        die.roll();
        updatePosition(die.eyes);
        handleField(currentPlayer.getPosition());
    }

    private void updatePosition(int sum)
    {
        if (currentPlayer.getPosition() + sum >= BOARD_SIZE) {
            currentPlayer.setPosition(currentPlayer.getPosition() + sum - BOARD_SIZE);
            currentPlayer.getAccount().adjustBalance(gameBoard.getSquare(0).landOn());//give them pass start money
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
    private void changePlayer(){
        int playerIndex = java.util.arrays = arList(players).indexOf(currentPlayer);
        //we need to define, how to pass the turn to the other players
    }

    private void handleField(int position){
        String fieldType = new String (board.getSquare(position));
        switch case "Amusement":
        Amusement amusement = (amusement)(board.getSquare(position);
        if ((amusement.getBoothOwner()== null )){
            pay(amusement.getPrice());
            board.getSquare(currentPlayer, position); // booth added to player inventory
        }
    }else(!currentPlayer.boothOwner){
        pay(amusement.getBoothOwner, amusement.getPrice());
    }
            break;
}
            case Chance
                    //dette må jeg lige vente med. Men den varetager chancerne.
                    //jeg vurdere, at der ikke er behov for lave en case for GO! men idk.
                    }
//this method is needed to terminate the game.
public boolean paymentPossible(Player player, int amount){
        if(player.getBalance() > amount)
        return true;
        else{
        this.hasWinner = true;
        return false;
        }
        }
public void announceWinner(){

}
}