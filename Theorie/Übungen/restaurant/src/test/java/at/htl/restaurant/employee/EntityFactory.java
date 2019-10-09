package at.htl.restaurant.employee;

import at.htl.restaurant.model.branch.Table;
import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.dish.EDishType;
import at.htl.restaurant.model.employee.Cook;
import at.htl.restaurant.model.employee.Waiter;

import java.util.ArrayList;
import java.util.List;

public class EntityFactory {
    public static Cook createCookData() {
        Cook cook = new Cook();

        List<Dish> dishes = new ArrayList<>();

        Dish dish = new Dish();
        dish.setPrice(6);
        dish.setName("Ragoue");
        dish.setDishType(EDishType.HAUPTSPEISE);
        dishes.add(dish);

        cook.setDishList(dishes);
        cook.setGivenName("Hubert");
        cook.setLastName("Tall");
        cook.setSocialSecurityCode("1234123412");

        return cook;
    }
    public static Waiter createWaiterData() {
        Waiter waiter = new Waiter();

        List<Table> tables = new ArrayList<>();

        Table table = new Table();
        table.setTableNr(101);
        table.setSmokingAllowed(true);
        tables.add(table);

        waiter.setTableList(tables);
        waiter.setGivenName("Herbert");
        waiter.setLastName("grom");
        waiter.setSocialSecurityCode("1234123412");

        return waiter;
    }
}
