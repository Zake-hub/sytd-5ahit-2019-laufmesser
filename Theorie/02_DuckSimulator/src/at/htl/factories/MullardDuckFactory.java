package at.htl.factories;

import at.htl.ducks.MullardDuck;
import at.htl.ducks.QuackCountDecorator;
import at.htl.interfaces.IDuckFactory;
import at.htl.interfaces.IQuackable;

import java.io.Serializable;

public class MullardDuckFactory implements Serializable, IDuckFactory {
    @Override
    public IQuackable createIQuackable() {
        return new QuackCountDecorator(new MullardDuck());
    }
}
