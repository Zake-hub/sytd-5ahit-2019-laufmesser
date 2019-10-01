package at.htl.drinks;

import at.htl.interfaces.IDrink;

import java.io.Serializable;
import java.util.ArrayList;

public class DecafCoffee implements Serializable, IDrink {
    @Override
    public String description() {
        return "I am a Decaf Coffee!";
    }

    @Override
    public double price() {
        return 3;
    }

    @Override
    public ArrayList<String> ingredients() {
        ArrayList<String> _ingredients = new ArrayList<>();
        _ingredients.add("Coffee without coffee!");
        return _ingredients;
    }
}
