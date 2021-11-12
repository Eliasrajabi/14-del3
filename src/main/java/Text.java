import java.io.*;
import java.util.Scanner;

public class Text {

    public static String Descriptions(int squareNr) throws IOException {

        File fil = new File("C:\\Users\\Malte\\IdeaProjects\\CDIO-3\\TestAfTekst");

        Scanner scan = new Scanner(new FileReader(fil.toString()));

        String squareDesc = "";

        while(scan.hasNextLine()){
            scan.nextLine();

            if(scan.hasNext(Integer.toString(squareNr))){
                scan.nextLine();

                while(scan.hasNextLine()){

                    squareDesc = String.format("%s%s\n", squareDesc, scan.nextLine());

                    if(scan.hasNext(Integer.toString(squareNr+1))){
                        break;
                    }
                }

                break;
            }

        }

        return squareDesc;
    }


}
