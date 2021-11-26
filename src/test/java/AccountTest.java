import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountTest {
    private final Player player = new Player();
    @BeforeEach
    protected void setUp() {
        player.account.setMoneyTotal(50);
    }

    @AfterEach
    protected void tearDown(){
        player.account.setMoneyTotal(0);
    }

    @Test
    void addPoint(){
        assertEquals(100, player.getAccount().adjustBalance(50));
    }

    @Test
    void subtractionPoint() {
        boolean isMoneyAdjusted = player.getAccount().adjustBalance(-100) < 0;
        assertFalse(isMoneyAdjusted);
        int totalMoney = player.getAccount().getMoneyTotal();
        assertEquals(totalMoney,0);
    }
}