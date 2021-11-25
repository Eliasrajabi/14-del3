import java.io.IOException;

public class GameBoard {
    //singleton
    //Gør så man har et enkelt instans af Gameboard klasse
    private static GameBoard instance;

    public static GameBoard getInstance() throws IOException {
        if(instance == null){
            makeSquares();
            instance = new GameBoard();
        }
        return instance;
    }
    private static Square[] gameBoardList = new Square[13];

    public int length (){
        return gameBoardList.length;
    }

    public Square getSquare(int position){
        return gameBoardList[position];
    }

    //et array som indeholder alle felter
    public static void makeSquares() throws IOException {

        gameBoardList[0] = new GO();
        gameBoardList[1] = new Chance();
        gameBoardList[2] = new Amusement("Candy Floss","",1);
        gameBoardList[3] = new Amusement("Balloon Stand","",1);
        gameBoardList[4] = new Chance();
        gameBoardList[5] = new Amusement("Magic Show","",2);
        gameBoardList[6] = new Amusement("Puppet Show","",2);
        gameBoardList[7] = new Chance();
        gameBoardList[8] = new Amusement("Video Arcade","",3);
        gameBoardList[9] = new Amusement("Hounted House","",3);
        gameBoardList[10] = new Chance();
        gameBoardList[11] = new Amusement("Pony Ride", "", 4);
        gameBoardList[12] = new Amusement("Helicopter Ride","",4);

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length(); i++){
            builder.append(getSquare(i)).append("\n");
        }
        return builder.toString();
    }
}