package at.htl.restaurant.dish;

import at.htl.restaurant.domain.dish.IIngredientRepository;
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
import static org.junit.Assert.assertNotNull;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class IngredientUnitTest {
    private static Logger log = LoggerFactory.getLogger(DishUnitTests.class);

    @Autowired
    private IIngredientRepository ingredientRepository;

    @Test
    public void createIngredient() {
        Ingredient ingredient = EntityFactory.createIngredientData();
        Ingredient savedEntity = ingredientRepository.save(ingredient);


        assertNotNull(savedEntity.getId());
        assertEquals(ingredient.getName(), savedEntity.getName());
        assertEquals(ingredient.getStoredUnits(), savedEntity.getStoredUnits());
    }
}
