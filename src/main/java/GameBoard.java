public class GameBoard {
    //singleton
    //Gør så man har et enkelt instans af Gameboard klasse
    private static GameBoard instance;

    public static GameBoard getInstance(){
        if(instance == null){
            instance = new GameBoard();
        }
        return instance;
    }
    private final Square[] gameBoardList = new Square[11];

    public int length (){
        return gameBoardList.length;
    }

    public Square getSquare(int position){
        return gameBoardList[position];
    }
    public Square setSquare(int number){return gameBoardList[number];}
    //et array som indeholder alle felter
    public Square[] makeSquares() {

        //Indtil videre er der ikke noget indhold i de specifikke felter, men når det bliver lavet,
        //skriver vi dem ind i parameterne her for at instantiere dem.
        gameBoardList[0] = new GO();
        gameBoardList[1] = new Chance();
        gameBoardList[2] = new Amusement();
        gameBoardList[3] = new Amusement();
        gameBoardList[4] = new Chance();
        gameBoardList[5] = new Amusement();
        gameBoardList[6] = new Amusement();
        gameBoardList[7] = new Chance();
        gameBoardList[8] = new Amusement();
        gameBoardList[9] = new Amusement();
        gameBoardList[10] = new Chance();
        return gameBoardList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length(); i++){
            builder.append(getSquare(i) + "\n");
        }
        return builder.toString();
    }
}