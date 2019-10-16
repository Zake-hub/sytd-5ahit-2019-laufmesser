package at.htl.domain.core;

import lombok.Getter;

import java.io.Serializable;

public class EnvironmentRecord implements Serializable {
    @Getter
    private Integer dayLightRatio;

    public EnvironmentRecord(Integer dayLightRatio) {
        if (dayLightRatio < 0 || dayLightRatio > 100)
            throw new InvalidRecordException();
        this.dayLightRatio = dayLightRatio;
    }

    public Integer getRainRatio() {return 100 - this.dayLightRatio;}
}
