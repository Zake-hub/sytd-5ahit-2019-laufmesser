package at.htl.environment;

import at.htl.PumpkinDecorator;
import at.htl.interfaces.IPumpkin;

public class Effect03 extends PumpkinDecorator {
    private IPumpkin pumpkin;

    public Effect03(IPumpkin pumpkin) {
        this.pumpkin = pumpkin;
    }

    @Override
    public int grow(double percentage) {
        return pumpkin.grow(0.01);
    }
}
