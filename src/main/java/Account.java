public class Account {
    private int moneyTotal = 35;

    //Denne metode bruges til alle transaktioner.
    public int adjustBalance(int money){
        int CheckBalance = moneyTotal + money;

        if(CheckBalance<0){
            moneyTotal = 0;
        }
        else {
            moneyTotal += money;
        }
        return moneyTotal;
    }
    public void setMoneyTotal(int money){
        this.moneyTotal = money;
    }

    public int getMoneyTotal(){
        return this.moneyTotal;
    }


}
