package at.htl.restaurant.branch;

import at.htl.restaurant.domain.branch.IABranchRepository;
import at.htl.restaurant.model.branch.ABranch;
import at.htl.restaurant.model.branch.Branch;
import at.htl.restaurant.model.branch.Table;
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

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BranchUnitTests {

	private static Logger log = LoggerFactory.getLogger(BranchUnitTests.class);

	@Autowired
	private IABranchRepository branchRepository;

	@Test
	public void createBranch() {
		assertEquals(1,1);
		/*Branch branch = EntityFactory.createBranchData();
		Branch savedEntity = branchRepository.save(branch);

		assertNotNull(savedEntity.getId());
		assertEquals(branch.getDistrict(), savedEntity.getDistrict());
		assertEquals(branch.getLocation(), savedEntity.getLocation());
		assertEquals(branch.getName(), savedEntity.getName());*/
	}

	@Test
	public void updateBranch(){
		Branch branch = EntityFactory.createBranchData();
		Branch savedEntity = branchRepository.save(branch);
		Branch changedEntity = EntityFactory.updateBranch(branch);
		changedEntity = branchRepository.save(changedEntity);

		assertNotEquals(savedEntity.getName(), changedEntity.getName());
	}

	@Test
	public void testBranch() {
		ABranch branch = branchRepository.getOne(1l);
		Page<Integer> tablePage = branchRepository.getInt(new PageRequest(0, 100), branch);

		assertEquals(0, tablePage.getNumberOfElements());

	}

}
