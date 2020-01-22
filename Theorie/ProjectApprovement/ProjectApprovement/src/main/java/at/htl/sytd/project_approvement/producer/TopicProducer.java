package at.htl.sytd.project_approvement.producer;

import at.htl.sytd.project_approvement.model.AProject;
import at.htl.sytd.project_approvement.model.ManagementProject;
import at.htl.sytd.project_approvement.model.RequestFundingProject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicProducer {
    private static final Logger logger
            = LoggerFactory.getLogger(TopicProducer.class);

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

        String projectType = "unknown";
        if(project instanceof ManagementProject)
            projectType = "management_project";
        if(project instanceof RequestFundingProject)
            projectType = "request_funding_project";

        String routingKey = projectType+'.'+key;
        rabbitTemplate.convertAndSend(
                exchange,
                routingKey,
                message
        );
        logger.info("sent message to "+exchange+':'+routingKey);
    }

    public void pushProjectToArchitecture(AProject project)
            throws JsonProcessingException {
        this.pushToExchange(
                "uni.projects",
                "architecture",
                project
        );
    }

    public void pushProjectToChemistry(AProject project)
            throws JsonProcessingException {
        this.pushToExchange(
                "uni.projects",
                "chemistry",
                project
        );
    }

    public void pushProjectToElectrotechnics(AProject project)
            throws JsonProcessingException {
        this.pushToExchange(
                "uni.projects",
                "electrotechnics",
                project
        );
    }
}
