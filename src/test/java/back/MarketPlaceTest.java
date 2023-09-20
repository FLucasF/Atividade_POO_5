package back;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarketPlaceTest {
    @Test
    public void marketPlaceTest() {
        MarketPlace sistema = new MarketPlace();

        Product p = new Product(1, "uva", 10, 2.0);

        //Register test
        assertTrue(sistema.registerProduct(p));
        assertFalse(sistema.registerProduct(p));

        //Modify amount test
        int newAmout = 15;
        sistema.modifyAmountProduct(p, 15);
        assertEquals(newAmout , p.getAmount());

        //Search test
        try {
            sistema.searchProduct(1);
        } catch (ProductNotFoundException e) {
            fail("Não deveria falhar");
        }

        //Remove test
        assertTrue(sistema.removeProduct(p));
        assertFalse(sistema.removeProduct(p));

        //Search test
        try {
            sistema.searchProduct(1);
            fail("Deveria falhar");
        } catch (ProductNotFoundException e) {

        }



    }
}
