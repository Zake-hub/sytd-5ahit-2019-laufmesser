package at.htl.drinks.ingredients;

import at.htl.drinks.DrinkDecorator;
import at.htl.interfaces.IDrink;

import java.util.ArrayList;

public class Chocolate extends DrinkDecorator {
    private IDrink _drink;
    public Chocolate(IDrink drink) {
        _drink = drink;
    }
    @Override
    public String description() {
        return _drink.description() + "with Chocolate";
    }

    @Override
    public double price() {
        return _drink.price() + 0.5;
    }

    @Override
    public ArrayList<String> ingredients() {
        _drink.ingredients().add("Chocolate");
        return _drink.ingredients();
    }
}
