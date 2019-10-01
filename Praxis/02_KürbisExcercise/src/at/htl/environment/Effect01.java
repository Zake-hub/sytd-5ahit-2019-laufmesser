package at.htl.environment;

import at.htl.PumpkinDecorator;
import at.htl.interfaces.IPumpkin;

public class Effect01 extends PumpkinDecorator {
    private IPumpkin pumpkin;

    public Effect01(IPumpkin pumpkin) {
        this.pumpkin = pumpkin;
    }

    @Override
    public int grow(double percentage) {
        if (percentage <= 19)
            return pumpkin.grow(0);
        else if (percentage <= 39)
            return pumpkin.grow(1);
        else if (percentage <= 59)
            return pumpkin.grow(2);
        else if (percentage <= 79)
            return pumpkin.grow(3);
        else if (percentage <= 99)
            return pumpkin.grow(4);
        else if (percentage == 100)
            return pumpkin.grow(5);
        else
            return 0;
    }
}
