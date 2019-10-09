package at.htl.restaurant.domain.branch;

import at.htl.restaurant.model.branch.LocalBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocalBranchRepository extends JpaRepository<LocalBranch, Long> {
}
