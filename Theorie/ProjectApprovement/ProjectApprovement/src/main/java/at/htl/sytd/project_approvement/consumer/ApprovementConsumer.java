package at.htl.sytd.project_approvement.consumer;

import at.htl.sytd.project_approvement.model.AProject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovementConsumer {

    private static final Logger log
            = LoggerFactory.getLogger(ApprovementConsumer.class);

    @Autowired
    ObjectMapper objectMapper;

    @RabbitListener(queues = "uni.project.approved")
    public void processAccept(String message) throws JsonProcessingException {
        AProject project = objectMapper.readValue(message, AProject.class);
        log.info("Project: " + project.getTitle()
                + " has been approved " + project.toString());
    }

    @RabbitListener(queues = "uni.project.canceled")
    public void processCancel(String message) throws JsonProcessingException {
        AProject project = objectMapper.readValue(message, AProject.class);
        log.info("Project: " + project.getTitle()
                + " has been cancelled " + project.toString());
    }
}
