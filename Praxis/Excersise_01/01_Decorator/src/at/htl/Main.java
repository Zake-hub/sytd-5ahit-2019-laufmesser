package at.htl;

import at.htl.builderPattern.DrinkableBuilder;
import at.htl.drinks.DecafCoffee;
import at.htl.drinks.Espresso;
import at.htl.drinks.ingredients.Chocolate;
import at.htl.drinks.ingredients.Milk;
import at.htl.drinks.ingredients.Milkbubbles;
import at.htl.drinks.ingredients.Soja;
import at.htl.interfaces.IDrink;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*IDrink drink = new Milk(new Chocolate(new Espresso()));

        System.out.println(drink.description());
        System.out.println(drink.price());
        for (var ingredient:drink.ingredients()
             ) {
            System.out.println(ingredient);
        }

        IDrink drink1 = new Milkbubbles(new Soja(new DecafCoffee()));

        System.out.println(drink1.description());
        System.out.println(drink1.price());
        for (var ingredient2:drink1.ingredients()
             ) {
            System.out.println(ingredient2);
        }*/

        DrinkableBuilder b = new DrinkableBuilder();
        b.init(new Espresso());
        System.out.println(b.addChocolate().addMilk().create().description());

    }
}
