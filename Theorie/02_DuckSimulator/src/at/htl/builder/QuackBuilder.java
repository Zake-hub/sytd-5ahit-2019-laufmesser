package at.htl.builder;

import at.htl.HonkAdapter;
import at.htl.ducks.*;
import at.htl.interfaces.IHonkable;
import at.htl.interfaces.IQuackable;

public class QuackBuilder {

    public IQuackable createQuackCountDecorator(IQuackable iQuackable) {
        return new QuackCountDecorator(iQuackable);
    }
    public IQuackable createGoose() {
        return new HonkAdapter(new Goose());
    }
    public IQuackable createMullardDuck() {
        return new MullardDuck();
    }
    public IQuackable createRubberDuck() {
        return new RubberDuck();
    }
    public IQuackable createRedheadDuck() {
        return new RedheadDuck();
    }
}
