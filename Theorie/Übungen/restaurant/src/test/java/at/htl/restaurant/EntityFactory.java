package at.htl.restaurant;

import at.htl.restaurant.model.branch.Branch;
import at.htl.restaurant.model.branch.LocalBranch;
import at.htl.restaurant.model.branch.Table;
import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.dish.EDishType;
import at.htl.restaurant.model.dish.Ingredient;
import at.htl.restaurant.model.employee.Cook;
import at.htl.restaurant.model.employee.Waiter;
import at.htl.restaurant.model.order.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntityFactory {

    public static Branch createBranchData(){
        Branch branch = new Branch();

        branch.setName("Pizza AlCapone");
        branch.setDistrict("Tulln");
        branch.setLocation("A-3470 Kirchberg am Wagram, Marktplatz 3");

        return branch;
    }

    public static LocalBranch createLocalBranchData(){
        LocalBranch branch = new LocalBranch();

        branch.setName("Pizza AlCapone");
        branch.setDistrict("Tulln");
        branch.setLocation("A-3470 Kirchberg am Wagram, Marktplatz 3");
        branch.setOpenHours(new Date());
        branch.setClosingHours(new Date());

        return branch;
    }

    public static Table createTableData(){
        Table table = new Table();
        table.setSmokingAllowed(true);
        table.setTableNr(3);
        return table;
    }

    public static Cook createCookData(){
        List<Dish> dishList = new ArrayList<>();
        dishList.add(createDishData());

        Cook cook = new Cook();
        cook.setGivenName("fhjk");
        cook.setLastName("fghj");
        cook.setSocialSecurityCode("1234567890");
        cook.setDishList(dishList);
        return cook;
    }

    public static Waiter createWaiterData(){
        Waiter waiter = new Waiter();
        List<Table> tableList = new ArrayList<>();
        waiter.setGivenName("fhjk");
        waiter.setLastName("fghj");
        waiter.setSocialSecurityCode("1234567890");
        tableList.add(createTableData());
        waiter.setTableList(tableList);
        return waiter;
    }

    public static Dish createDishData(){
        Dish dish = new Dish();
        dish.setDishType(EDishType.HAUPTSPEISE);
        dish.setName("schnitzel");
        dish.setPrice(324);
        return dish;
    }

    public static Ingredient createIngredientData(){
        Ingredient ingredient = new Ingredient();
        ingredient.setStoredUnits(23);
        ingredient.setName("schnitzel");
        return ingredient;
    }

    public static Order createOrderData()
    {
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setOrderID(556);
        return order;
    }




}
