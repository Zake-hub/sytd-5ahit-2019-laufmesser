package at.htl.restaurant.branch;

import at.htl.restaurant.domain.branch.IABranchRepository;
import at.htl.restaurant.model.branch.Branch;
import at.htl.restaurant.model.branch.LocalBranch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LocalBranchUnitTests {

    private static Logger log = LoggerFactory.getLogger(LocalBranchUnitTests.class);

    @Autowired
    private IABranchRepository branchRepository;

    @Test
    public void createLocalBranch() {
        LocalBranch localBranch = EntityFactory.createLocalBranchData();
        LocalBranch savedEntity = branchRepository.save(localBranch);

        assertNotNull(savedEntity.getId());
        assertEquals(localBranch.getDistrict(), savedEntity.getDistrict());
        assertEquals(localBranch.getLocation(), savedEntity.getLocation());
        assertEquals(localBranch.getName(), savedEntity.getName());
        assertEquals(localBranch.getOpenHours(), savedEntity.getOpenHours());
        assertEquals(localBranch.getClosingHours(), savedEntity.getClosingHours());
    }

}
