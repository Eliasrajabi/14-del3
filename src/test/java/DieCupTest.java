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
        double avgCount = Math.round(maxRolls/dieFaces);

        double[] expected = new double[dieFaces];
        Arrays.fill(expected, avgCount);

        double[] actual = new double[dieFaces];

        int testRolls = 0;

        while( testRolls <= maxRolls ) {

            int roll = DieCup.Roll();

            for (int i = 0; i < dieFaces; i++){

                if(roll == i + 1){
                    actual[i]++;
                }

            }

            testRolls++;
        }

        assertArrayEquals(expected, actual, tolerance);
     }


}