import gui_fields.GUI_Player;

public class Player {
        public Account account = new Account();
        private String name;
        public GUI_Player GUIplayer;
        private int position = 0;

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

