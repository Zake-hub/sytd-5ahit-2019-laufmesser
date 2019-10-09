package at.htl.restaurant.dish;

import at.htl.restaurant.domain.branch.ITableRepository;
import at.htl.restaurant.domain.dish.IDishIngredientRepository;
import at.htl.restaurant.domain.dish.IDishRepository;
import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.dish.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DishUnitTests {

    private static Logger log = LoggerFactory.getLogger(DishUnitTests.class);

    @Autowired
    private IDishRepository dishRepository;

    @Test
    public void createDish() {
        Dish dish = EntityFactory.createDishData();
        Dish savedEntity = dishRepository.save(dish);

        assertNotNull(savedEntity.getId());
        assertEquals(dish.getDishType(), savedEntity.getDishType());
        assertEquals(dish.getName(), savedEntity.getName());
        assertEquals(dish.getPrice(), savedEntity.getPrice());
    }

    @Autowired
    private IDishIngredientRepository dishIngredientRepository;

    @Test
    public void testDish(){
        Dish dish = dishRepository.getOne(1l);
        //Page<Ingredient> oa = dishIngredientRepository.getDishIngredientBy(dish, new PageRequest(0, 10));
        //assertEquals(1, oa);
    }
}