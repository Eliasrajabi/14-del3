import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class AccountTest extends TestCase {
    private Player spiller;
    @BeforeEach
    protected void setUp() {
        spiller = new Player();
        spiller.account.adjustMoney(50);
    }
    @AfterEach
    protected void tearDown(){
        spiller.account.moneyTotal = 0;
    }

    @Test
    void addPoint(){
        assertEquals(spiller.getAccount().adjustMoney(50),spiller.account.moneyTotal == 100);
    }

    @Test
    void subtractionPoint() {
        boolean isMoneyAdjusted = spiller.getAccount().isBoothBought(-100);
        assertFalse(isMoneyAdjusted);
        int totalMoney = spiller.getAccount().moneyTotal;
        assertEquals(totalMoney,50);
    }
}