package at.htl.sytd.project_approvement.producer;

import at.htl.sytd.project_approvement.model.AProject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectProducer {
    private static final Logger logger
            = LoggerFactory.getLogger(DirectProducer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private void pushToExchange(
            String exchange,
            String key,
            AProject project
    ) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(project);

        rabbitTemplate.convertAndSend(exchange, key, message);
        logger.info("sent message to " + exchange + ':' + key);
    }

    public void pushToApproved(AProject project)
            throws JsonProcessingException {
        this.pushToExchange(
                "uni.projects.validation",
                "approved",
                project);
    }

    public void pushToCanceled(AProject project)
            throws JsonProcessingException {
        this.pushToExchange(
                "uni.projects.validation",
                "canceled",
                project);
    }
}
