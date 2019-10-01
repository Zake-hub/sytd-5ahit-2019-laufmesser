package at.htl.factoryPattern;

import at.htl.drinks.DarkRoastCoffee;
import at.htl.drinks.ingredients.Chocolate;
import at.htl.drinks.ingredients.Milk;
import at.htl.interfaces.IDrink;
import at.htl.interfaces.IFactory;

import java.io.Serializable;

public class HomeMixWithMilkAndChocolateFactory implements Serializable, IFactory {
    @Override
    public IDrink createIDrink() {
        return new Milk(new Chocolate(new DarkRoastCoffee()));
    }
}
