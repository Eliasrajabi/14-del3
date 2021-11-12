import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class AccountTest extends TestCase {
    private Player spiller;
    @BeforeEach
    void setUp() {
        spiller = new Player();
        spiller.account.adjustMoney(50);
    }

    @AfterEach
    void tearDown(){
        spiller.account.moneyTotal = 0;
    }

    @Test
    void addPoint(){
        assertEquals(spiller.getAccount().adjustMoney(50),spiller.account.moneyTotal == 100);
    }


    @Test
    void subtractionPoint() {
        boolean isMoneyAdjusted = spiller.getAccount().adjustMoney(-100);
        assertFalse(isMoneyAdjusted);
        int totalMoney = spiller.getAccount().moneyTotal;
        assertEquals(totalMoney,50);
    }
}