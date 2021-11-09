public class Player {
    public Account account = new Account();

    int startBalance;

    public void setStartBalance(int startBalance) {
        this.startBalance = startBalance;
        account.isBoothBought(startBalance);
    }

    public Player(){

    }

    public void addToTotal(int money) {
        account.isBoothBought(money);
    }

    public Account getAccount() {
        return account;
    }

    public static int roll(){
        return DieCup.roll();
    }
}
