package at.htl.mom;

import at.htl.mom.Model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectRabbitMQProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public void sendDirectMessage(Employee employee) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(employee);
        rabbitTemplate.convertAndSend(
                "htl.direct.employee",
                "doof",
                message
        );
    }
}
