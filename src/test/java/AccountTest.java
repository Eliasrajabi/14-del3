import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountTest {
    private Player spiller;
    @BeforeEach
    public void setUp() {
        spiller = new Player();
        spiller.account.adjustBalance(50);
    }

    @AfterEach
    public void tearDown(){
        spiller.account.setMoneyTotal(0);
    }

    @Test
    public void addPoint(){
        Assert.assertEquals(spiller.getAccount().adjustBalance(50), spiller.account.getMoneyTotal());
    }

    @Test
    public void subtractionPoint() {
        boolean isMoneyAdjusted = spiller.getAccount().isBoothBought(-100);
        assertFalse(isMoneyAdjusted);
        int totalMoney = spiller.getAccount().getMoneyTotal();
        assertEquals(totalMoney,50);
    }


}