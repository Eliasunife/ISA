

import static org.junit.Assert.*;

import org.junit.Test;

public class my_shopinglistTest {
    @Test
    public void testAddItem() {
        my_shopinglist shoppingList = new my_shopinglist();
        shoppingList.addItem("Milk");
        assertTrue(shoppingList.viewItems().contains("Milk"));
    }

    @Test
    public void testRemoveItem() {
        my_shopinglist shoppingList = new my_shopinglist();
        shoppingList.addItem("Eggs");
        shoppingList.removeItem("Eggs");
        assertFalse(shoppingList.viewItems().contains("Eggs"));
    }
}

