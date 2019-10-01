package at.htl;

import at.htl.interfaces.IHonkable;
import at.htl.interfaces.IQuackable;

public class HonkAdapter implements IQuackable {

    private IHonkable honkable;

    public HonkAdapter(IHonkable honkable) {
        this.honkable = honkable;
    }

    @Override
    public void quack() {
        honkable.honk();
    }
}
