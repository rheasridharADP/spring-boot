package com.webage;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerAPISecurityTests {
    
    @Autowired TestRestTemplate template;
    @Value("${spring.security.user.name}") String user;
    @Value("${spring.security.user.password}") String password;


    @Test
   // @Disabled
    public void testGetList_badCredentials_401() {
        // Create an HttpEntity with the headers featuring an INVALID username and password:
        HttpEntity<String> requestEntity = 
            new HttpEntity<>(createHttpHeaders("invalid", "invalid"));

        // Make the request with exchange method
        ResponseEntity<String> responseEntity =
            template.exchange(
                    "/customers", HttpMethod.GET, requestEntity, String.class);

        //  We expect that we WILL get a 401 error when we provide invalid credentials.
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
  //  @Disabled
    public void testGetList_goodCredentials_200() {
        // Create an HttpEntity with the headers featuring an valid username and password:
        HttpEntity<String> requestEntity = 
            new HttpEntity<>(createHttpHeaders(user, password));

        // Make the request with exchange method
        ResponseEntity<String> responseEntity =
            template.exchange(
                    "/customers", HttpMethod.GET, requestEntity, String.class);

        //  We expect 200 OK when we provide valid credentials:
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    private HttpHeaders createHttpHeaders(String user, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(user,password);
        headers.set("Accept", "application/json");  // Prove we are not a browser.
        return headers;
    }
}
