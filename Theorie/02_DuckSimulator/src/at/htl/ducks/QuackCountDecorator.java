package at.htl.ducks;

import at.htl.interfaces.IQuackable;

import java.io.Serializable;

public class QuackCountDecorator implements Serializable, IQuackable {

    static public long count;
    private IQuackable iQuackable;

    public QuackCountDecorator(IQuackable iQuackable) {
        this.iQuackable = iQuackable;
    }

    @Override
    public void quack()
    {
        iQuackable.quack();
        count++;
    }
}
