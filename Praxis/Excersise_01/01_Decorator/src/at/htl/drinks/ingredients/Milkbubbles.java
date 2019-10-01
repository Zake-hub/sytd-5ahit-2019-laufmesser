package at.htl.drinks.ingredients;

import at.htl.drinks.DrinkDecorator;
import at.htl.interfaces.IDrink;

import java.util.ArrayList;

public class Milkbubbles extends DrinkDecorator {
    private IDrink _drink;
    public Milkbubbles(IDrink drink) {
        _drink = drink;
    }
    @Override
    public String description() {
        return _drink.description() + "with milkbubbles";
    }

    @Override
    public double price() {
        return _drink.price() + 0.5;
    }

    @Override
    public ArrayList<String> ingredients() {
        _drink.ingredients().add("milkbubbles");
        return _drink.ingredients();
    }
}
