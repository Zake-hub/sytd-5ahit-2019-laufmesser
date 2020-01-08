package at.htl.sytd.project_approvement.integration;

import at.htl.sytd.project_approvement.model.ELawType;
import at.htl.sytd.project_approvement.model.EProjectState;
import at.htl.sytd.project_approvement.model.Facility;
import at.htl.sytd.project_approvement.model.ManagementProject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static at.htl.sytd.project_approvement.integration.IntegrationUtils.buildURL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class ProjectApprovementTest {

    private final static String CONTROLLER = "approvement";

    @Test
    public void testSendProjectToElectrotechnics(){
        ManagementProject project = new ManagementProject();

        project.setProjectState(EProjectState.CREATED);
        project.setTitle("FI Patent");
        project.setDescription("bla");
        project.setFacility(
                new Facility("Electrotechnics")
        );
        project.setLawType(ELawType.P_28);

        String requestURL
                = buildURL(CONTROLLER, "init");

        RestTemplate restTemplate
                = new RestTemplate();

        HttpEntity<ManagementProject> httpEntity
                = new HttpEntity<>(project);

        ResponseEntity<ManagementProject> responseEntity
                = restTemplate.postForEntity(
                        requestURL,
                httpEntity,
                ManagementProject.class);

        Assert.assertEquals(
                HttpStatus.OK,
                responseEntity.getStatusCode()
        );
    }
}
