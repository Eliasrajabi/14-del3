import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Text {

     private static String Descriptions(String squareName) throws IOException {

        File fil = new File("Descriptions");

        Scanner scan = new Scanner(new FileReader(fil.toString()));

       String squareDesc = "";

        while(scan.hasNextLine()){


            if(scan.hasNext(squareName)){
                scan.nextLine();

                while(!scan.hasNext("---")){
                    squareDesc = String.format("%s%s\n", squareDesc, scan.nextLine());
                }

                break;
            }
            scan.nextLine();
        }

        return squareDesc;
    }

    public static String getGoDesc() throws IOException {
        return Descriptions("GO:");
    }
    public static String getAmusementDesc(int amusementNr) throws IOException {

        String amusement = "";

        switch (amusementNr) {
            case 1 -> amusement = Descriptions("Amusement1:");
            case 2 -> amusement = Descriptions("Amusement2:");
            case 3 -> amusement = Descriptions("Amusement3:");
            case 4 -> amusement = Descriptions("Amusement4:");
            case 5 -> amusement = Descriptions("Amusement5:");
            case 6 -> amusement = Descriptions("Amusement6:");
        }

        return amusement;

    }
    public static String getChanceDesc(int chanceNr) throws IOException {

         String chance = "";

        switch (chanceNr) {
            case 1 -> chance = Descriptions("Chance1:");
            case 2 -> chance = Descriptions("Chance2:");
            case 3 -> chance = Descriptions("Chance3:");
            case 4 -> chance = Descriptions("Chance4:");
        }

        return chance;
    }


}
