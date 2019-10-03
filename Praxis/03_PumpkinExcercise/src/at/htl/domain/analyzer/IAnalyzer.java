package at.htl.domain.analyzer;

import at.htl.domain.core.EnvironmentRecord;
import at.htl.domain.core.GrowthRateRecord;
import at.htl.domain.core.RecordList;

public interface IAnalyzer {
    GrowthRateRecord calculateGrowthRate(RecordList<EnvironmentRecord> dayLightRatioList, EnvironmentRecord record);

    String getDescription();
}
