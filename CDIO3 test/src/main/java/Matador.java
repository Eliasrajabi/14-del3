import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class Matador {
    public static void main(String[] args) {
                Player player = new Player();
                System.out.println(player.getAccount().moneyTotal);
                player.setStartBalance(10);
                player.addToTotal(1000);
                Square f = new Amusement();
                f.landOn(player);
            }
        }
