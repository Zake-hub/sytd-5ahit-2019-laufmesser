package at.htl.sytd.project_approvement.consumer;

import at.htl.sytd.project_approvement.model.AProject;
import at.htl.sytd.project_approvement.model.EProjectState;
import at.htl.sytd.project_approvement.producer.DirectProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FacilityConsumer {
    private static final Logger logger
            = LoggerFactory.getLogger(FacilityConsumer.class);
    private static final Random RANDOM = new Random();

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    DirectProducer producer;

    private void processProject(AProject project)
            throws JsonProcessingException {
        if (project.getProjectState() != EProjectState.IN_APPROVEMENT) {
            logger.info("incoming project rejected (invalid state)");
            return;
        }

        if (RANDOM.nextInt(100) > 20) {
            project.setProjectState(EProjectState.APPROVED);
            producer.pushToApproved(project);
            logger.info("Project:" + project.getTitle() + " approved");
        } else {
            project.setProjectState(EProjectState.CANCLED);
            producer.pushToCanceled(project);
            logger.info("Project:" + project.getTitle() + " canceled");
        }
    }

    @RabbitListener(queues = "uni.projects.architecture")
    public void processArchitecture(String message)
            throws JsonProcessingException {
        this.processProject(objectMapper.readValue(message, AProject.class));
    }

    @RabbitListener(queues = "uni.projects.chemistry")
    public void processChemistry(String message)
            throws JsonProcessingException {
        this.processProject(objectMapper.readValue(message, AProject.class));
    }

    @RabbitListener(queues = "uni.projects.electrotechnics")
    public void processElectrotechnics(String message)
            throws JsonProcessingException {
        this.processProject(objectMapper.readValue(message, AProject.class));
    }
}
