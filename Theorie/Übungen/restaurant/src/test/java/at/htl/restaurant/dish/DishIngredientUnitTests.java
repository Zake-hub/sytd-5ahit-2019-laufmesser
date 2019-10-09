package at.htl.restaurant.dish;

import at.htl.restaurant.domain.dish.IDishIngredientRepository;
import at.htl.restaurant.domain.dish.IDishRepository;
import at.htl.restaurant.domain.dish.IIngredientRepository;
import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.dish.DishIngredient;
import at.htl.restaurant.model.dish.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DishIngredientUnitTests {

    private static Logger log = LoggerFactory.getLogger(DishIngredientUnitTests.class);

    @Autowired
    private IDishIngredientRepository dishIngredientRepository;

    @Autowired
    private IDishRepository dishRepository;

    @Autowired
    private IIngredientRepository ingredientRepository;

    @Test
    public void createDishIngredient() {
        Dish dish = EntityFactory.createDishData();
        Dish sdish = dishRepository.save(dish);
        Ingredient ingredient = EntityFactory.createIngredientData();
        Ingredient singredient = ingredientRepository.save(ingredient);
        DishIngredient dishIngredient = EntityFactory.createDishIngredientData(sdish, singredient);
        DishIngredient savedEntity = dishIngredientRepository.save(dishIngredient);

        assertEquals(dishIngredient.getAmount(), savedEntity.getAmount());
        assertEquals(dishIngredient.getDishIngredientID(), savedEntity.getDishIngredientID());
    }
}