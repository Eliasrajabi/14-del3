public class Account {
    int moneyTotal;

    //Denne metode bruges til at købe en bod.
    public boolean isBoothBought(int money){
        int CheckBalance = moneyTotal + money;

        if(CheckBalance<0){
            return false;
        }
        else {
            moneyTotal += money;
            return true;
        }
    }
    //Denne metode bruges til alle andre transaktioner.
    public int adjustMoney(int money){
        int CheckBalance = moneyTotal + money;

        if(CheckBalance<0){
            moneyTotal = 0;
        }
        else {
            moneyTotal += money;
        }
        return moneyTotal;
    }

}
