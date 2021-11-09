public class Account {
    int moneyTotal;

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
    public int payFine(int money){
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
