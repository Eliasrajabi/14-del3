import java.io.IOException;

public class Chance extends Square{

    @Override
    void landOn(Player player) throws IOException {
        System.out.println("Du landte på chance");
        int cardNumber = (int) (Math.random() * 4 + 1);


        switch (cardNumber) {
            case 1 ->
                System.out.println(Text.getChanceDesc(cardNumber));
            //Her skal være noget kode som rykker spilleren
            case 2 -> {
                System.out.println(Text.getChanceDesc(cardNumber));
                player.adjustBalance(-2);
            }
            case 3 -> {
                System.out.println();
                System.out.println(Text.getChanceDesc(cardNumber));
            }
            //Choose an amusement square.
            case 4 -> {
                System.out.println(Text.getChanceDesc(cardNumber));
                player.adjustBalance(2);
            }
        }

        //Mine forsøg på at lave en array som ikke fungerede :(
        //for (int i = 0; i < card.length; i++) {
        //    i = (int) (Math.random()*4+1); // storing random integers in an array
        //    Chance chance = card[i];
        //    System.out.println("dit kort" + card[i]); // printing each array element}

        //Chance[] card = new Chance[5];
        //int cardNumber = (int) (Math.random() * 6 + 1);
        //Chance chance = card[cardNumber];
        //System.out.println("dit kort" + card[cardNumber]);

    }
}
