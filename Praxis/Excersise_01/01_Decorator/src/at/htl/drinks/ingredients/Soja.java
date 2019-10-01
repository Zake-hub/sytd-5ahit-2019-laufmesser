package at.htl.drinks.ingredients;

import at.htl.drinks.DrinkDecorator;
import at.htl.interfaces.IDrink;

import java.util.ArrayList;

public class Soja extends DrinkDecorator {
    private IDrink _drink;
    public Soja(IDrink drink) {
        _drink = drink;
    }
    @Override
    public String description() {
        return _drink.description() + "with Soja";
    }

    @Override
    public double price() {
        return _drink.price() + 1;
    }

    @Override
    public ArrayList<String> ingredients() {
        _drink.ingredients().add("soja");
        return _drink.ingredients();
    }
}
