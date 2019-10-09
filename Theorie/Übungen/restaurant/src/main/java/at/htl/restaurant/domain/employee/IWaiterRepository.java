package at.htl.restaurant.domain.employee;

import at.htl.restaurant.model.employee.Waiter;
import at.htl.restaurant.model.branch.Table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IWaiterRepository extends JpaRepository<Waiter, Long> {

    @Query("SELECT t FROM Waiter w JOIN w.tableList t WHERE w = :waiter")
    Page<Table> tablesOfOneWaiter(Pageable pageable, @Param("waiter") Waiter waiter);
}
