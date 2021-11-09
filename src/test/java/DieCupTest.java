import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DieCupTest {


    @Test
     public void tiTusindKast(){

        int dieFaces = 6;
        int tolerance = 100;
        double maxRolls = 10000;

        double[] expected = new double[dieFaces];
        Arrays.fill(expected, maxRolls/dieFaces);

        double[] actual = new double[dieFaces];

        int rolls = 0;

        while( rolls <= maxRolls ) {

            int roll = DieCup.Roll();

            for (int i = 0; i < dieFaces; i++){

                if(roll == i + 1){
                    actual[i]++;
                }

            }

            rolls++;
        }

        assertArrayEquals(expected, actual, tolerance);
     }


}