package at.htl.builderPattern;

import at.htl.drinks.ingredients.Chocolate;
import at.htl.drinks.ingredients.Milk;
import at.htl.drinks.ingredients.Milkbubbles;
import at.htl.drinks.ingredients.Soja;
import at.htl.interfaces.IDrink;

public class DrinkableBuilder {

    private IDrink drink;

    public DrinkableBuilder init(IDrink drink) {
        this.drink = drink;
        return this;
    }

    public DrinkableBuilder addChocolate() {
        drink = new Chocolate(drink);
        return this;
    }
    public DrinkableBuilder addMilk() {
        drink = new Milk(drink);
        return this;
    }
    public DrinkableBuilder addMilkbubbles() {
        drink = new Milkbubbles(drink);
        return this;
    }
    public DrinkableBuilder addSoja() {
        drink = new Soja(drink);
        return this;
    }
    public IDrink create() {
        return this.drink;
    }

}
