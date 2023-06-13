import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static service.Constants.DELTA_FOR_FLOAT_ASSERT;

@RunWith(Parameterized.class)
public class BunTest {

public final String name;
public final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] BunPrice() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", -200},
                {"", 300},
                {null, 123.05f},
                {"bigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbun" +
                        "bigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbun" +
                        "bigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbunbigbun", 9876543210f},
                {"yellow bun", 0.00000000000001f},
        };
    }
    @Test
    public void bunModuleTest() {
       Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(price, bun.getPrice(), DELTA_FOR_FLOAT_ASSERT);
    }
}
