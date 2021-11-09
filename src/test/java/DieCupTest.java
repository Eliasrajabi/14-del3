import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DieCupTest {

    @Test
     public void tiTusindKast(){

        int[] expected = new int[6];
        Arrays.fill(expected, 10000/6);

        int[] actual = new int[6];

        int testRolls = 0;

        while( testRolls <= 10000 ) {

            int roll = DieCup.Roll();

            for (int i = 0; i < 6; i++){

                if(roll == i + 1){
                    actual[i] = actual[i] + 1;
                }

            }

            testRolls++;
        }

        Assertions.assertArrayEquals(expected, actual);

     }



}