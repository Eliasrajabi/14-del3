
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
 private Player spiller;
    @BeforeEach
    void setUp() {
        spiller = new Player();
        spiller.account.isBoothBought(50);
    }

    @AfterEach
    void tearDown(){
        spiller.account.moneyTotal = 0;
    }

    @Test
    void addPoint(){
        assertEquals(spiller.getAccount().isBoothBought(50),spiller.account.moneyTotal == 100);
    }


    @Test
    void noNegativeBalance() {
        boolean isBoothBought = spiller.getAccount().isBoothBought(-100);
        assertFalse(isBoothBought);
        int totalMoney = spiller.getAccount().moneyTotal;
        assertEquals(totalMoney,50);
    }

}