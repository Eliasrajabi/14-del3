import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DieCupTest {


    @Test
     public void tiTusindKast(){

        final int DIE_FACES = 6;
        final int TOLERANCE = 100;
        final float MAX_ROLLS = 10000;

        float[] expected = new float[DIE_FACES];
        Arrays.fill(expected, MAX_ROLLS/DIE_FACES);

        float[] actual = new float[DIE_FACES];

        int rolls = 0;

        while( rolls <= MAX_ROLLS ) {

            int roll = DieCup.Roll();

            for (int i = 0; i < DIE_FACES; i++){

                if(roll == i + 1){
                    actual[i]++;
                }

            }

            rolls++;
        }

        assertArrayEquals(expected, actual, TOLERANCE);
     }


}