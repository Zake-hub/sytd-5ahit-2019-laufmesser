package at.htl.restaurant.domain.employee;

import at.htl.restaurant.model.branch.ABranch;
import at.htl.restaurant.model.employee.AEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAEmployeeRepository extends JpaRepository<AEmployee, Long> {
    List<AEmployee> findAEmployeesByGivenNameStartingWithAndLastNameNotContaining(Character vn, String nn);

    Page<AEmployee> findAEmployeesByGivenNameStartingWithAndLastNameNotContaining(Pageable pageable, Character vn, String nn);

    Page<AEmployee> findAEmployeeByGivenNameStartingWithAndLastNameContainingOrderByLastNameAsc(Pageable pageable, Character vn, String nn);



}
// 2) Alle Employees deren Name mit A Beginnt und deren Nachname Gruber enthält. Sortieren Sie das Ergebnis
//// Nach Nachnamen absteigend sortiert.



/*JPA QUERIES

Für den übergebenen Branch alle Köche die dort arbeiten
Für ein Gericht alle Ingredients die drin sind
Für einen bestimmten Waiter die Tische die er managed
Für einen Tisch den Umsatz berechnen
Für einen Branch welcher Tisch den maximalen Umsatz hat
Welcher Branch den meisten Umsatz hat*/