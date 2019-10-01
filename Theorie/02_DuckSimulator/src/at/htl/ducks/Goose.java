package at.htl.ducks;

import at.htl.interfaces.IHonkable;

import java.io.Serializable;

public class Goose implements Serializable, IHonkable {
    @Override
    public void honk() {
        System.out.println("Honk!");
    }
}
