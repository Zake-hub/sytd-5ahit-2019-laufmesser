package at.htl.domain.core;

import java.io.Serializable;

public class EnvironmentRecord implements Serializable {
    private int humidity;

    public EnvironmentRecord(int humidity) {
        this.humidity = humidity;
    }
}
