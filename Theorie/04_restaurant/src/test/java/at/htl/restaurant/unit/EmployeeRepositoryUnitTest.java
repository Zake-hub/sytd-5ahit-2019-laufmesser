package at.htl.restaurant.unit;


import at.htl.restaurant.domain.IEmployeeRepository;
import at.htl.restaurant.model.employee.AEmployee;
import at.htl.restaurant.model.employee.Waiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmployeeRepositoryUnitTest {

    private static Logger log = LoggerFactory.getLogger(EmployeeRepositoryUnitTest.class);

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Test
    public void testLogTest(){
        log.info("Hallo Welt!");
    }

    @Transactional
    @Test
    public void readEmployeeById() {
        AEmployee employee = employeeRepository.getOne(10l);
        assertEquals(new Long(11), employee.getId());
    }

    @Transactional
    @Test
    public void readEmployeeBySocialSecurityCode() {
        AEmployee employee = employeeRepository.getAEmployeeBySocialSecurityCode("17091999");
        assertEquals("Draeger", employee.getLastName());
    }

    @Transactional
    @Test
    public void readAllEmployeesByLastNameOrderedByLastName() {
        List<AEmployee> employees = employeeRepository.getAEmployeesByLastNameContainingOrderByLastNameAsc("Leister");
        assertEquals(1, employees.size());
    }

    @Transactional
    @Test
    public void getCooks() {
        List<AEmployee> cooks = employeeRepository.getCooks();
        assertEquals(7, cooks.size());
    }

    @Transactional
    @Test
    public void getOneWaiter() {
        Waiter waiter = (Waiter) employeeRepository.getOneWaiter(1l);
        List<at.htl.restaurant.model.branch.Table> tables = employeeRepository.getTablesByWaiter(waiter);
        assertEquals(4, tables.size());
    }

    @Transactional
    @Test
    public void getWaiterByBranch(){
        List<Waiter> = employeeRepository.getWaitersByBranch();
    }
}
