package at.htl.mom.integration;

import at.htl.mom.Model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostEmployeeTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void getEmployee() throws Exception {
        Employee employee = new Employee("Henry", "Ford");
        String message = objectMapper.writeValueAsString(employee);
        mvc.perform(MockMvcRequestBuilders.post("/messaging/postEmployee").accept(MediaType.APPLICATION_JSON_VALUE).content(message))
                .andExpect(status().isOk());
    }
}
