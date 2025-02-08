import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static service.Constants.DELTA_FOR_FLOAT_ASSERT;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    public Bun bunMock;
    @Mock
    private Ingredient ingredientMock;

    @Before
    public void initBurger() {
        burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        Mockito.when(bunMock.getPrice()).thenReturn(99.5f);
        Mockito.when(bunMock.getName()).thenReturn("black bun");
        Mockito.when(ingredientMock.getPrice()).thenReturn(101f);
        Mockito.when(ingredientMock.getName()).thenReturn("cutlet");
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = 300f;
        float actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, DELTA_FOR_FLOAT_ASSERT);
    }

    @Test
    public  void getReceiptTest() {
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= filling cutlet =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 300,000000\r\n";
        String actualReceipt = burger.getReceipt();
        System.out.println(actualReceipt);
        System.out.println(expectedReceipt);

       Assert.assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void addIngredientsTest() {
        burger.addIngredient(ingredientMock);
        int expectedIngredientCount = 2;
        int actualIngredientCount = burger.ingredients.size();
        Assert.assertEquals(expectedIngredientCount, actualIngredientCount);
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        Ingredient nextIngredient = mock(Ingredient.class);
        burger.addIngredient(nextIngredient);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredientMock, burger.ingredients.get(1));
    }

    @Test
    public void moveNextIngredientTest(){
        Ingredient nextIngredient = mock(Ingredient.class);
        burger.addIngredient(nextIngredient);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(nextIngredient, burger.ingredients.get(0));
    }
}
