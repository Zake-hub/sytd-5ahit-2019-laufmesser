package at.htl.drinks;

import at.htl.interfaces.IDrink;

import java.io.Serializable;
import java.util.ArrayList;

public class Espresso implements Serializable, IDrink {
    @Override
    public String description() {
        return "I am a Espresso";
    }

    @Override
    public double price() {
        return 1.5;
    }

    @Override
    public ArrayList<String> ingredients() {
        ArrayList<String> _ingredients = new ArrayList<>();
        _ingredients.add("dark Coffee");
        return _ingredients;
    }
}
