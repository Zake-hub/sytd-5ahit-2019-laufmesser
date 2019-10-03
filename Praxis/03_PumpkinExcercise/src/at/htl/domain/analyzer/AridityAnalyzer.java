package at.htl.domain.analyzer;

import at.htl.domain.core.EnvironmentRecord;
import at.htl.domain.core.GrowthRateRecord;
import at.htl.domain.core.RecordList;

public class AridityAnalyzer implements IAnalyzer{

    private IAnalyzer analyzer;

    public AridityAnalyzer(IAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public GrowthRateRecord calculateGrowthRate(RecordList<EnvironmentRecord> dayLightRatioList, EnvironmentRecord record) {
        GrowthRateRecord growthRateRecord = analyzer.calculateGrowthRate(dayLightRatioList, record);
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
