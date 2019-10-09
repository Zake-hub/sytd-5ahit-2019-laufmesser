package at.htl.restaurant.domain.dish;

import at.htl.restaurant.model.branch.ABranch;
import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.dish.EDishType;
import at.htl.restaurant.model.dish.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDishRepository extends JpaRepository<Dish, Long>{
    List<Dish> readDishesByDishType(EDishType dishType);

    Page<Dish> readDishesByDishType(Pageable pageable, EDishType dishType);

    Page<Dish> readAllByDishTypeIn(Pageable pageable, List<EDishType> dishTypes);
   /* @Query("select count(o.GERICHT_ID) from OrderTableDishID o where o.GERICHT_ID =: dishID")
             Integer getOrdredAmountOfDishById(
             @Param("dishID") Long dishId);*/


}
/*JPA QUERIES

Für den übergebenen Branch alle Köche die dort arbeiten
Für ein Gericht alle Ingredients die drin sind
Für einen bestimmten Waiter die Tische die er managed
Für einen Tisch den Umsatz berechnen
Für einen Branch welcher Tisch den maximalen Umsatz hat
Welcher Branch den meisten Umsatz hat*/