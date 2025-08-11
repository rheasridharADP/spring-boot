package com.webage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.webage.domain.Customer;
import com.webage.domain.Purchase;
import com.webage.repository.PurchaseRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//  PART 6:
//  Remove the @Disabled annotation from the testSaveAndFind method.
//  Run this integration test, it should pass.

@DataJpaTest
public class PurchaseRepositoryTests {
    
    @PersistenceContext
    EntityManager em;
    
    @Test
   // @Disabled
    @Transactional
    public void testSaveAndFind(@Autowired PurchaseRepository repo) {

        //  Get an existing customer:
        Customer c = em.find(Customer.class, 1);

        //  Create a new purchase:
        Purchase p = new Purchase();
        p.setCustomer(c);
        p.setProduct("Mayan ceremonial headmask");
        p.setPurchaseDate(new Date());

        repo.save(p);

        //  Clear the persistence context so we can be assured that 
        //  our retrieval is not merely finding the value cached in memory:
        em.clear();

        //  Retrieve the purchase from the DB:
        Optional<Purchase> result = repo.findById(Long.valueOf(p.getId()));

        //  Test:
        Purchase purchase = result.get();
        assertEquals(p.getProduct(), purchase.getProduct());
        assertEquals(p.getPurchaseDate(), purchase.getPurchaseDate());

    }

}
