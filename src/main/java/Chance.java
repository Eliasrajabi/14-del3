public class Chance extends Square{

    @Override
    void landOn(Player player) {
        System.out.println("Du landte på chance");
        int cardNumber = (int) (Math.random() * 4 + 1);

        switch (cardNumber) {
            case 1 -> System.out.println("Move to an orange or green square." +
                    "If the square is already owned, then you have to pay entrance to the owner." +
                    "If not, you get the booth for free!");
            //Her skal være noget kode som rykker spilleren
            case 2 -> {
                System.out.println("You ate too much candy :( \nPay 2$ to the bank.");
                player.adjustBalance(-2);
            }
            case 3 -> System.out.println("Move to a pink or gray square." +
                    "If the square is already owned, then you have to pay entrance to the owner." +
                    "If not, you get the booth for free!");
            //Choose an amusement square.
            case 4 -> {
                System.out.println("It's your birthday! \nYou get 2$ from the bank :) ");
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

    @Override
    public String toString() {
        return "Chance";
    }
}
