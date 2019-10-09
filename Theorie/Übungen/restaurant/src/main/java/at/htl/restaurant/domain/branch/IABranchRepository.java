package at.htl.restaurant.domain.branch;

import at.htl.restaurant.model.branch.ABranch;
import at.htl.restaurant.model.branch.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IABranchRepository extends JpaRepository<ABranch, Long> {
    List<Branch> findBranchesByName(String name); // oder auch readBranchesByName

    List<Branch> findBranchesByNameIsContaining(String name);

    Page<Branch> findBranchesByName(Pageable pageable, String name);


    /*@Query("SELECT t FROM Table t join t.orderTableDish o join o.dish d where ( max(sum(d.price)) = (select max(sum(d.price)) from Table t join t.orderTableDish o join o.dish d where (t.branch = :branch) group by t ))")
    Page<Table> getTableWithHighestValue(Pageable pageable, @Param("branch") ABranch branch);*/

    @Query("select max(sum(d.price)) from OrderTableDish o join o.Table t join o.dish d where (t.branch = :branch) group by t ")
    Page<Integer> getInt(Pageable pageable, @Param("branch") ABranch branch);
}
/*JPA QUERIES

Für den übergebenen Branch alle Köche die dort arbeiten
Für ein Gericht alle Ingredients die drin sind
Für einen bestimmten Waiter die Tische die er managed
Für einen Tisch den Umsatz berechnen
Für einen Branch welcher Tisch den maximalen Umsatz hat
Welcher Branch den meisten Umsatz hat*/