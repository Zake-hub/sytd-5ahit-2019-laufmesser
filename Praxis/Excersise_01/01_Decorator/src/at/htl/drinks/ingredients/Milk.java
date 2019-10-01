package at.htl.drinks.ingredients;

import at.htl.drinks.DrinkDecorator;
import at.htl.interfaces.IDrink;

import java.util.ArrayList;

public class Milk extends DrinkDecorator {
    private IDrink _drink;
    public Milk(IDrink drink) {
        _drink = drink;
    }
    @Override
    public String description() {
        return _drink.description() + "with Milk";
    }

    @Override
    public double price() {
        return _drink.price() + 0.5;
    }

    @Override
    public ArrayList<String> ingredients() {
        _drink.ingredients().add("milk");
        return _drink.ingredients();
    }
}
