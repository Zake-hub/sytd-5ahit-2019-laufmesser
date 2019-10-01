package at.htl.pumpkin;

import at.htl.environment.*;
import at.htl.interfaces.IPumpkin;

public class PumpkinBuilder {
    private IPumpkin pumpkin;

    public PumpkinBuilder init(IPumpkin pumpkin) {
        this.pumpkin = pumpkin;
        return this;
    }

    public PumpkinBuilder addEffect01() {
        pumpkin = new Effect01(pumpkin);
        return this;
    }

    public PumpkinBuilder addEffect02() {
        pumpkin = new Effect02(pumpkin);
        return this;
    }

    public PumpkinBuilder addEffect03() {
        pumpkin = new Effect03(pumpkin);
        return this;
    }

    public PumpkinBuilder addEffect04() {
        pumpkin = new Effect04(pumpkin);
        return this;
    }

    public  PumpkinBuilder addEffect05() {
        pumpkin = new Effect05(pumpkin);
        return this;
    }

    public IPumpkin create() {
        return this.pumpkin;
    }
}
