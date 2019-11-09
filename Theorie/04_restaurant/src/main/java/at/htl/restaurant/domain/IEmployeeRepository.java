package at.htl.restaurant.domain;

import at.htl.restaurant.model.branch.ABranch;
import at.htl.restaurant.model.employee.AEmployee;
import at.htl.restaurant.model.employee.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<AEmployee, Long> {

    AEmployee getAEmployeeBySocialSecurityCode(String socialSecurityCode);
    List<AEmployee> getAEmployeesByLastNameContainingOrderByLastNameAsc(String lastNameContains);

    @Query("select c from AEmployee c where type (c)=Cook order by c.lastName asc")
    List<AEmployee> getCooks();

    @Query("select w from Waiter w where w.id = :id")
    AEmployee getOneWaiter(@Param("id")Long id);

    @Query("select w.tableList from Waiter w where w = :waiter")
    List<at.htl.restaurant.model.branch.Table> getTablesByWaiter(@Param("waiter")Waiter waiter);

    @Query("select w from AEmployee w join w.branchList b where type(w) = Waiter and b = :branch")
    List<AEmployee> getWaitersByBranch(@Param("branch")ABranch branch);
}
