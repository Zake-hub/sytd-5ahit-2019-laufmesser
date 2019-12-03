package at.htl.restaurant.domain;

import at.htl.restaurant.model.branch.ABranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IABranchRepository extends JpaRepository<ABranch, Long> {

    List<ABranch> getABranchByNameContainingOrderByNameAsc(String nameContains);
}
