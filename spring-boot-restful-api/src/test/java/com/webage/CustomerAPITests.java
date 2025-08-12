package com.webage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.webage.domain.Customer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerAPITests {
    
    @Autowired TestRestTemplate template;

    //  PART 6:
    //  Comment out the @Disabled annotation below.
    //  Run this test.  It should pass.
    
    @Test
   // @Disabled
    public void testGetList() {

        Customer[] customers = 
            template.getForObject("/customers", Customer[].class);

        assertNotNull(customers);
        assertNotNull(customers[0]);
        assertNotNull(customers[0].getId());
        assertTrue(customers.length>0);
    }

    // PART 7:
    //  Open http://localhost:8080/customers to see a JSON list of customers. 

    // PART 8 (optional):
    //  Use PostMan to test http://localhost:8080/customers .

    //  PART 10:
    //  Comment out the @Disabled annotation below.
    //  Run this test.  It should pass.
 
    @Test
    @Disabled
    public void testGet() {

        Customer customer = 
            template.getForObject("/customer/{id}", Customer.class, 1);

        assertNotNull(customer);
        assertNotNull(customer.getId());
    }

    //  PART 12 (optional):
    //  Use PostMan to test http://localhost:8080/customers/1 .

    //  PART 14:
    //  Comment out the @Disabled annotation below.
    //  Run this test.  It should pass.

    @Test
    @Disabled
    public void testPost() {

        Customer customer = new Customer();
        customer.setName("Test");
        customer.setEmail("test@test.com");

        URI location = template.postForLocation("/customers", customer, Customer.class);
        assertNotNull(location);

        customer = template.getForObject(location, Customer.class);
        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertEquals("Test", customer.getName());
        assertEquals("test@test.com", customer.getEmail());
    }

    // PART 15 (optional):
    //  Use PostMan to test POST to http://localhost:8080/customers .


    //  PART 17:
    //  Comment out the @Disabled annotation below.
    //  Run this test.  It should pass.

    @Test
    @Disabled
    public void testPut() {

        String path = "/customers/2";
        String newValue = "NewValue" + Math.random();

        Customer customer = template.getForObject(path, Customer.class );

        customer.setName(newValue);
        template.put(path, customer);

        customer = template.getForObject(path, Customer.class );

        assertEquals(newValue, customer.getName());
    }

    // PART 18 (optional):
    //  Use PostMan to test PUT to http://localhost:8080/customers/4 .
}
