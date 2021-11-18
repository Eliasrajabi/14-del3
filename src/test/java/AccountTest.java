import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

 public class AccountTest {
    private final Player spiller = new Player();
    @BeforeEach
    protected void setUp() {
        spiller.account.adjustMoney(50);
    }

    @AfterEach
    protected void tearDown(){
        spiller.account.moneyTotal = 0;
    }

    @Test
    void addPoint(){
        assertEquals(100,spiller.getAccount().adjustMoney(50));
    }


    @Test
    void subtractionPoint() {
        boolean isMoneyAdjusted = spiller.getAccount().isBoothBought(-100);
        assertFalse(isMoneyAdjusted);
        int totalMoney = spiller.getAccount().moneyTotal;
        assertEquals(totalMoney,50);
    }
}