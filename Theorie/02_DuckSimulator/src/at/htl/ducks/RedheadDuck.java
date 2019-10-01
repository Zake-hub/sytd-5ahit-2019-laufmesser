package at.htl.ducks;

import at.htl.interfaces.IQuackable;

import java.io.Serializable;

public class RedheadDuck implements Serializable, IQuackable {
    @Override
    public void quack() {
        System.out.println("quack! I am a RedheadDuck!");
    }
}
