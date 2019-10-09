package at.htl.restaurant;

import at.htl.restaurant.domain.branch.IABranchRepository;
import at.htl.restaurant.domain.dish.IDishRepository;
import at.htl.restaurant.domain.dish.IIngredientRepository;
import at.htl.restaurant.domain.employee.IAEmployeeRepository;
import at.htl.restaurant.model.branch.Branch;
import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.dish.EDishType;
import at.htl.restaurant.model.dish.Ingredient;
import at.htl.restaurant.model.employee.AEmployee;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DomainUnitTest {

    private static Logger log = LoggerFactory.getLogger(DomainUnitTest.class);

    @Autowired
    private IABranchRepository branchRepository;

    @Test
    public void branchTests() {
        Branch branch = at.htl.restaurant.EntityFactory.createBranchData();
        branchRepository.save(branch);

        List<Branch> fetchedBranches = branchRepository.findBranchesByName(branch.getName());
        assertEquals(1, fetchedBranches.size());

        fetchedBranches = branchRepository.findBranchesByNameIsContaining(branch.getName().substring(0, 2));
        assertEquals(2, fetchedBranches.size());

        Page<Branch> branchPage = branchRepository.findBranchesByName(new PageRequest(0, 10), branch.getName());
        assertEquals(1, branchPage.getNumberOfElements());

    }

    @Autowired
    private IDishRepository dishRepository;

    @Test
    public void dishTests() {
        // Alle Dishes, wo der Typ des Dishes dem Typ des Dishes entspricht lol

        Dish dish = at.htl.restaurant.EntityFactory.createDishData();
        dishRepository.save(dish);

        List<Dish> fetchedDishes = dishRepository.readDishesByDishType(EDishType.HAUPTSPEISE);
        assertEquals(8, fetchedDishes.size());

        Page<Dish> dishPage = dishRepository.readDishesByDishType(new PageRequest(0, 10), EDishType.HAUPTSPEISE);
        assertEquals(8, dishPage.getNumberOfElements());


        List<EDishType> type = new ArrayList<>();
        type.add(EDishType.HAUPTSPEISE);
        type.add(EDishType.ZUSPEISE);
        Page<Dish> hauptspeisePage = dishRepository.readAllByDishTypeIn(new PageRequest(0, 20), type);
        assertEquals(11, hauptspeisePage);
    }

    @Autowired
    private IIngredientRepository ingredientRepository;

    @Test
    public void ingredientTests() {
        // Alle Zutaten, die im Namen nicht "Zucker" enthalten

        Ingredient ingredient = at.htl.restaurant.EntityFactory.createIngredientData();
        ingredient.setName("Schnitzi");
        ingredientRepository.save(ingredient);

        List<Ingredient> fetchedIngredients = ingredientRepository.readIngredientsByNameNotContaining("Zucker");
        assertEquals(28, fetchedIngredients.size());

        Page<Ingredient> ingredientPage = ingredientRepository.readIngredientsByNameNotContaining(
                new PageRequest(0, 10), "Zucker");
        assertEquals(10, ingredientPage.getNumberOfElements());

        Page<Ingredient> pepperingredientPage = ingredientRepository.readIngredientsByNameContainingIgnoreCaseOrderByNameDesc(
                new PageRequest(0,1), "Zuccini");
        assertEquals(1, pepperingredientPage.getNumberOfElements());

    }

    @Autowired
    private IAEmployeeRepository employeeRepository;

    @Test
    public void employeeTests() {
        // Alle Angestellten die im Vornamen (GivenName) ein "j" als ersten Buchstaben haben und Nachname darf nicht
        // "Bauer" sein

        AEmployee aEmployee = at.htl.restaurant.EntityFactory.createWaiterData();
        aEmployee.setGivenName("Jonas");
        aEmployee.setLastName("Huber");
        employeeRepository.save(aEmployee);

        List<AEmployee> fetchedEmployees = employeeRepository.findAEmployeesByGivenNameStartingWithAndLastNameNotContaining
                ('J', "Bauer");
        assertEquals(4, fetchedEmployees.size());

        Page<AEmployee> employeePage = employeeRepository.findAEmployeesByGivenNameStartingWithAndLastNameNotContaining(
                new PageRequest(0, 10), 'J', "Bauer");
        assertEquals(4, employeePage.getNumberOfElements());

        Page<AEmployee> employeeGruberPage = employeeRepository.findAEmployeeByGivenNameStartingWithAndLastNameContainingOrderByLastNameAsc(
                new PageRequest(0, 10), 'A', "Gruber");
        assertEquals(4, employeePage.getNumberOfElements());

    }
}