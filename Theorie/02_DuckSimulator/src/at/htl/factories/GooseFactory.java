package at.htl.factories;

import at.htl.HonkAdapter;
import at.htl.ducks.Goose;
import at.htl.ducks.QuackCountDecorator;
import at.htl.interfaces.IDuckFactory;
import at.htl.interfaces.IQuackable;

import java.io.Serializable;

public class GooseFactory implements Serializable, IDuckFactory {
    @Override
    public IQuackable createIQuackable() {
        return new QuackCountDecorator(new HonkAdapter(new Goose()));
    }
}
