package at.htl.restaurant.domain.dish;

import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.dish.DishIngredient;
import at.htl.restaurant.model.dish.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDishIngredientRepository extends JpaRepository<DishIngredient, Long> {

}
