 public class Player {
        public static Object move;
        public Account account = new Account();
        private int position = 0;

     public void setPosition(int position) {
         this.position = position;
     }
     public int getPosition() {
         return position;
     }

     int startBalance;

        public void setStartBalance(int startBalance) {
            this.startBalance = startBalance;
            account.adjustBalance(startBalance);
        }

        public Player() {

        }

        public Account getAccount() {
            return account;
        }
    }
