public class Account {
    int moneyTotal;

    public boolean adjustMoney(int money){
        int CheckBalance = moneyTotal + money;

        if(CheckBalance<0){
            return false;
        }
        else {
            moneyTotal += money;
            return true;
        }
    }
}
