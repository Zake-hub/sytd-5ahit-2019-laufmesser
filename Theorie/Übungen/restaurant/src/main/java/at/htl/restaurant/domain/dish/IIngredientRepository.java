package at.htl.restaurant.domain.dish;

import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.dish.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long>{

    List<Ingredient> readIngredientsByNameNotContaining(String name);

    Page<Ingredient> readIngredientsByNameNotContaining(Pageable pageable, String name);

    Page<Ingredient> readIngredientsByNameContainingIgnoreCaseOrderByNameDesc(Pageable pageable, String name);

   /* @Query("SELECT i FROM Dish d JOIN d.dishIngredientID.Ingredient i WHERE d.dishIngredientID.dish = :dish")
    Page<Ingredient> allIngredientsFromOneDish(Pageable pageable, @Param("dish") Dish dish);*/
}








// 1) Alle Ingredients die im Namen Pfeffer enthalten. Sortieren Sie das Ergebnis nach dem Namen absteigend.
// Der Name muß usecase insensitive übergeben werden.
//
// 2) Alle Employees deren Name mit A Beginnt und deren Nachname Gruber enthält. Sortieren Sie das Ergebnis
//// Nach Nachnamen absteigend sortiert.
////
// 3) Alle Gerichte in einer



/*JPA QUERIES

Für den übergebenen Branch alle Köche die dort arbeiten
Für ein Gericht alle Ingredients die drin sind
Für einen bestimmten Waiter die Tische die er managed
Für einen Tisch den Umsatz berechnen
Für einen Branch welcher Tisch den maximalen Umsatz hat
Welcher Branch den meisten Umsatz hat*/