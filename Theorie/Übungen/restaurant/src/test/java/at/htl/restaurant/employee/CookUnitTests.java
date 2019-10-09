package at.htl.restaurant.employee;

import at.htl.restaurant.domain.branch.IABranchRepository;
import at.htl.restaurant.domain.employee.IAEmployeeRepository;
import at.htl.restaurant.domain.employee.ICookRepository;
import at.htl.restaurant.model.employee.Cook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CookUnitTests {
    private static Logger log = LoggerFactory.getLogger(CookUnitTests.class);

    @Autowired
    private IAEmployeeRepository employeeRepository;

    @Test
    public void createCook() {
        Cook cook = EntityFactory.createCookData();

        Cook savedEntity = employeeRepository.save(cook);

        assertNotNull(savedEntity.getId());
        assertEquals(cook.getDishList(), savedEntity.getDishList());
        assertEquals(cook.getLastName(), savedEntity.getLastName());
        assertEquals(cook.getGivenName(), savedEntity.getGivenName());
        assertEquals(cook.getSocialSecurityCode(), savedEntity.getSocialSecurityCode());
    }

    @Autowired
    private ICookRepository cookRepository;
    @Autowired
    private IABranchRepository iaBranchRepository;
    @Test
    public void testCook() {

        Page<Cook> cookPage = cookRepository.getAEmployeeByBranch(iaBranchRepository.getOne(1l), new PageRequest(0, 10));
        assertEquals(0, cookPage);
    }

}
