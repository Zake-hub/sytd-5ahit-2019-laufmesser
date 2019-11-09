package at.htl.restaurant.domain;

import at.htl.restaurant.model.branch.ABranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IABranchRepository extends JpaRepository<ABranch, Long> {
}
