package at.htl.mom;

import at.htl.mom.Model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/messaging")
@RestController
public class MessageResource {

    private  static final Logger log = LoggerFactory.getLogger(MessageResource.class);

    private DirectRabbitMQProducer producer = new DirectRabbitMQProducer();

    @PostMapping(path = "/postEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public void postEmployee(@RequestBody Employee employee) throws JsonProcessingException {
        producer.sendDirectMessage(employee);
        log.info("Employee: {}", employee);
    }
}
