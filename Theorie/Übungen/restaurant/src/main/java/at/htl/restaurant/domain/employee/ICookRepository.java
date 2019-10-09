package at.htl.restaurant.domain.employee;

import at.htl.restaurant.model.branch.ABranch;
import at.htl.restaurant.model.employee.Cook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICookRepository extends JpaRepository<Cook, Long> {

    @Query("select c from Cook c join c.branchList bl where bl = :branch")
    Page<Cook> getAEmployeeByBranch(@Param("branch") ABranch branch, Pageable pageable);
}
