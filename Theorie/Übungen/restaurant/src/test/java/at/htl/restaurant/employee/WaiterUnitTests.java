package at.htl.restaurant.employee;

import at.htl.restaurant.domain.employee.IAEmployeeRepository;
import at.htl.restaurant.model.employee.Waiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WaiterUnitTests {
    private static Logger log = LoggerFactory.getLogger(WaiterUnitTests.class);

    @Autowired
    private IAEmployeeRepository employeeRepository;

    @Test
    public void createWaiter() {
        Waiter waiter = EntityFactory.createWaiterData();

        Waiter savedEntity = employeeRepository.save(waiter);

        assertNotNull(savedEntity.getId());
        assertEquals(waiter.getTableList(), savedEntity.getTableList());
        assertEquals(waiter.getLastName(), savedEntity.getLastName());
        assertEquals(waiter.getGivenName(), savedEntity.getGivenName());
        assertEquals(waiter.getSocialSecurityCode(), savedEntity.getSocialSecurityCode());
    }
}
