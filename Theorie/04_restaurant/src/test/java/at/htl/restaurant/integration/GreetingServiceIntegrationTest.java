package at.htl.restaurant.integration;

import at.htl.restaurant.service.GreetingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class GreetingServiceIntegrationTest {

    private static Logger logger = LoggerFactory.getLogger(GreetingServiceIntegrationTest.class);

    @Test
    public void greetingResourceTest(){
        String requestURL = String.format("%s/%s/%s", "http://127.0.0.1:8181", "restaurant", "greetings/hallo");
        logger.info(requestURL);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> httpResponse = restTemplate.getForEntity(requestURL, String.class);
        assertEquals(HttpStatus.OK, httpResponse.getStatusCode());

        String msg = httpResponse.getBody();
        assertEquals("Moinsn!", msg);
    }
}
