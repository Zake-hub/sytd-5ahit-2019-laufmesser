package at.htl.restaurant.branch;

import at.htl.restaurant.domain.branch.ITableRepository;
import at.htl.restaurant.model.branch.Table;
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
public class TableUnitTests {

    private static Logger log = LoggerFactory.getLogger(TableUnitTests.class);

    @Autowired
    private ITableRepository tableRepository;

    @Test
    public void createTable() {
        Table table = EntityFactory.createTableData();
        Table savedEntity = tableRepository.save(table);

        assertNotNull(savedEntity.getId());
        assertEquals(table.getSmokingAllowed(), savedEntity.getSmokingAllowed());

    }

    @Test
    public void testTable() {
        Table table = tableRepository.getOne(1l);
        //int i = tableRepository.SalaryFromTable(table);
        //assertEquals(15, i);
    }

}
