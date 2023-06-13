import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    public final int index;
    public final String type;

    public IngredientTypeTest(int index, String type) {
        this.index = index;
        this.type = type;
    }

    @Parameterized.Parameters()
    public static Object[][] IngredientPrice() {
        return new Object[][]{
                {0, "SAUCE"},
                {1, "FILLING"},
        };
    }

        @Test
        public void enumIngredientTypeTest() {
            Assert.assertEquals(type, IngredientType.valueOf(type).toString());
            Assert.assertEquals(index, IngredientType.valueOf(type).ordinal());
        }
}
