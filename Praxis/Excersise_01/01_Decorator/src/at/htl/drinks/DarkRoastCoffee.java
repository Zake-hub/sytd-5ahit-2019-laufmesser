package at.htl.drinks;

import at.htl.interfaces.IDrink;

import java.io.Serializable;
import java.util.ArrayList;

public class DarkRoastCoffee implements Serializable, IDrink {
    @Override
    public String description() {
        return "I am a Dark roasted Coffee!";
    }

    @Override
    public double price() {
        return 2.50;
    }

    @Override
    public ArrayList<String> ingredients() {
        ArrayList<String> _ingredients = new ArrayList<>();
        _ingredients.add("dark roasted coffeebeans");
        _ingredients.add("milk");
        return _ingredients;
    }
}
