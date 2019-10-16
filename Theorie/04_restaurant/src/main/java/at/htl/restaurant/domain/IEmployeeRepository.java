package at.htl.restaurant.domain;

import at.htl.restaurant.model.employee.AEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<AEmployee, Long> {

}
