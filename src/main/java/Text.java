import java.io.*;
import java.util.Scanner;

public class Text {

   private static String Descriptions(String squareName) throws IOException {

        File fil = new File("Descriptions");

        Scanner scan = new Scanner(new FileReader(fil.toString()));

       String squareDesc = "";

        while(scan.hasNextLine()){


            if(scan.hasNext(squareName)){

                while(!scan.hasNext("---")){
                    squareDesc = String.format("%s%s\n", squareDesc, scan.nextLine());
                }

                break;
            }
            scan.nextLine();
        }

        return squareDesc;
    }

    public static String getGoText() throws IOException {
        return Descriptions("GO:");
    }
    public static String getAmusementText() throws IOException {
        return Descriptions("Amusement:");
    }
    public static String getChanceText() throws IOException {
       return Descriptions("Chance:");
    }


}
