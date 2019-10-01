package at.htl.drinks;

import at.htl.interfaces.IDrink;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeMix implements Serializable, IDrink {
    @Override
    public String description() {
        return "I am a HomeMix";
    }

    @Override
    public double price() {
        return 2;
    }

    @Override
    public ArrayList<String> ingredients() {
        ArrayList<String> _ingredients = new ArrayList<>();
        _ingredients.add("coffee");
        _ingredients.add("hot water");
        return _ingredients;
    }
}
