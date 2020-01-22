package at.htl.sytd.project_approvement.controller;

import at.htl.sytd.project_approvement.model.AProject;
import at.htl.sytd.project_approvement.model.EProjectState;
import at.htl.sytd.project_approvement.producer.TopicProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/approvement")
@RestController
public class ProjectApprovementController {

    private static Logger logger
            = LoggerFactory.getLogger(ProjectApprovementController.class);

    @Autowired
    TopicProducer producer;

    @PostMapping(path = "/init")
    @ResponseStatus(HttpStatus.OK)
    public void publishProject(@RequestBody AProject project)
            throws JsonProcessingException {
        if (project.getProjectState() != EProjectState.CREATED) {
            logger.info("incoming project rejected (invalid state)");
            return;
        }

        project.setProjectState(EProjectState.IN_APPROVEMENT);
        switch (project.getFacility().getFacilityName()) {
            case "Architecture":
                producer.pushProjectToArchitecture(project);
                break;
            case "Chemistry":
                producer.pushProjectToChemistry(project);
                break;
            case "Electrotechnics":
                producer.pushProjectToElectrotechnics(project);
                break;
        }
    }
}
