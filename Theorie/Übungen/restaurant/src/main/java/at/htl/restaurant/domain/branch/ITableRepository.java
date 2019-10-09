package at.htl.restaurant.domain.branch;

import at.htl.restaurant.model.branch.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITableRepository extends JpaRepository<Table, Long> {

    /*@Query("select sum(ot.dish.price) from OrderTableDish ot join ot.OrderTableDishID d where d.table = :table")
    int SalaryFromTable(@Param("table") Table table);*/
}
/*JPA QUERIES

Für den übergebenen Branch alle Köche die dort arbeiten
Für ein Gericht alle Ingredients die drin sind
Für einen bestimmten Waiter die Tische die er managed
Für einen Tisch den Umsatz berechnen
Für einen Branch welcher Tisch den maximalen Umsatz hat
Welcher Branch den meisten Umsatz hat*/