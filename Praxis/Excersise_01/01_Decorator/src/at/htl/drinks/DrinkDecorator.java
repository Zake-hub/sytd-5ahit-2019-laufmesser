package at.htl.drinks;

import at.htl.interfaces.IDrink;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class DrinkDecorator implements Serializable, IDrink {
    IDrink drink;
}
