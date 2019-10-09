package at.htl.restaurant.dish;

import at.htl.restaurant.domain.dish.IDishRepository;
import at.htl.restaurant.domain.dish.IIngredientRepository;
import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.dish.DishIngredient;
import at.htl.restaurant.model.dish.EDishType;
import at.htl.restaurant.model.dish.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityFactory {
    @Autowired
    private static IDishRepository dishRepository;

    @Autowired
    private static IIngredientRepository ingredientRepository;

    public static Dish createDishData() {

        Dish dish = new Dish();

        dish.setDishType(EDishType.HAUPTSPEISE);
        dish.setName("Pizza");
        dish.setPrice(11);

        return dish;
    }

    public static Ingredient createIngredientData() {

        Ingredient ingredient = new Ingredient();

        ingredient.setName("Basilikum");
        ingredient.setStoredUnits(100);

        return ingredient;
    }

    public static DishIngredient createDishIngredientData(Dish dish, Ingredient ingredient) {


        DishIngredient dishIngredient = new DishIngredient(dish, ingredient);
        dishIngredient.setAmount(1);

        return dishIngredient;
    }
}
