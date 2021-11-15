import java.io.*;
import java.util.Scanner;

public class Text {

   private static String Descriptions(int squareNum) throws IOException {

        File fil = new File("Descriptions");

        Scanner scan = new Scanner(new FileReader(fil.toString()));

        String squareDesc = "";

        String squareNumString = Integer.toString(squareNum);

        while(scan.hasNextLine()){
            scan.nextLine();

            if(scan.hasNext(squareNumString)){
                scan.nextLine();

                while(scan.hasNextLine()){
                    squareDesc = String.format("%s%s\n", squareDesc, scan.nextLine());

                    if(scan.hasNext(Integer.toString(squareNum+1))){
                        break;
                    }
                }

                break;
            }

        }

        return squareDesc;
    }

    public static String landOnGo() throws IOException {
        return Descriptions(1);
    }
    public static String landOnAmusement() throws IOException {
        return Descriptions(2);
    }
    public static String landOnChance() throws IOException {
        return Descriptions(3);
    }

}
