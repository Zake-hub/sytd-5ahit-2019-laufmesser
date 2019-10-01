package at.htl.ducks;

import at.htl.interfaces.IQuackable;

import java.io.Serializable;

public class MullardDuck implements Serializable, IQuackable {
    @Override
    public void quack() {
        System.out.println("Quack! I am a MullardDuck!");
    }
}
