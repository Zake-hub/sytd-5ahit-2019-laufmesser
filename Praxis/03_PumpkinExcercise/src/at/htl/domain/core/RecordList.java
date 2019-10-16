package at.htl.domain.core;

import java.util.ArrayList;
import java.util.List;

public class RecordList<T> extends ArrayList<T> {
    public List<T> precedingRecordSublist(T record, int precedingRecordAmount){
        int currentIndex = this.indexOf(record);

        if(currentIndex == -1){
            throw new InvalidRecordException();
        }

        List<T> recordHistoryList = new ArrayList<>();

        if(precedingRecordAmount > currentIndex){
            for (int i = 0; i <= currentIndex; i++) {
                recordHistoryList.add(this.get(i));
            }
        }else{
            for (int i = currentIndex - precedingRecordAmount + 1; i <= currentIndex; i++) {
                recordHistoryList.add(this.get(i));
            }
        }

        return recordHistoryList;
    }

}
