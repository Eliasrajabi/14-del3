import java.util.ArrayList;
import java.util.Scanner;

public class Player {
        public static Object move;
        public Account account = new Account();
        public String name;
        int position = 0;

        public void setPosition(int position) {
            this.position = position;
        }

        public int getPosition(){
            return this.position;
        }

        public Account getAccount() {
            return account;
        }

        public void setPlayerName (String name){this.name = name;}

        public String getPlayerName(){return this.name;}


    }

