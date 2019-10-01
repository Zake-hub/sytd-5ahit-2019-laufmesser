package at.htl;

import at.htl.interfaces.IPumpkin;

import java.io.Serializable;

public abstract class PumpkinDecorator implements Serializable, IPumpkin {
    IPumpkin pumpkin;
}
