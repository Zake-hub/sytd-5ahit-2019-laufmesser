package at.htl.pumpkin;


import at.htl.interfaces.IPumpkin;

import java.io.Serializable;

public class Pumpkin implements IPumpkin, Serializable {

    private int growth;

    public Pumpkin(int growth) {
        this.growth = growth;
    }

    @Override
    public int grow(double percentage) {
        if (percentage == 0.01)
            return growth = 0;
        else if (percentage == 0.5)
            return growth /= 2;
        else
            return growth += percentage;
    }
}
