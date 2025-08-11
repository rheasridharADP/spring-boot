package com.webage.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.webage.domain.Purchase;

@SpringBootTest
public class PurchaseDaoImplTests {

    @Autowired
    PurchaseDaoImpl dao;

    //  PART 3b:
    //  Removed the @Disabled annotation.  Run this test, it should pass.

    @Test
  //  @Disabled
    public void	getAllPurchases() {
        List<Purchase> purchases = dao.getAllPurchases();

        //  Make sure there are multiple purchases, and 
        //  that purchases have their properties mapped:
        assertNotNull(purchases);
        assertTrue(purchases.size()>0);
        Purchase p = purchases.get(0);
        assertNotNull(p);
        assertNotNull(p.getId());
        assertNotNull(p.getCustomerName());
    }

    //  PART 5b (Optional):
    //  Removed the @Disabled annotation.  Run this test, it should pass.
    @Test
    @Disabled
    public void	getPurchase() {
        Purchase p = dao.getPurchase(1);

        //  Make sure the purchase has its properties mapped:
        assertNotNull(p);
        assertNotNull(p.getId());
        assertNotNull(p.getCustomerName());
    }

    //  PART 6b (Optional):
    //  Removed the @Disabled annotation.  Run this test, it should pass.
    @Test
    @Disabled
    public void	savePurchase() {

        Purchase p = new Purchase();
        p.setCustomerName("Sample");
        p.setProduct("Sample Product");
        p.setPurchaseDate( new Date());

        dao.savePurchase(p);
        Purchase newPurchase = dao.getPurchase(p.getCustomerName(),p.getPurchaseDate());

        //  Make sure the purchase was saved properly:
        assertNotNull(newPurchase);
        assertNotNull(newPurchase.getId());
        assertNotNull(newPurchase.getCustomerName());

        assertEquals(newPurchase.getCustomerName(), p.getCustomerName());
        assertEquals(newPurchase.getProduct(), p.getProduct());
    }

}
