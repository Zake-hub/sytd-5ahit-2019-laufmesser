package at.htl;

import at.htl.interfaces.IQuackable;

import java.io.Serializable;

public class DuckCall implements Serializable, IQuackable {
    @Override
    public void quack() {
        System.out.println("quack!, Quaccccccck!");
    }
}
