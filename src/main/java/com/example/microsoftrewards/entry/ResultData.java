package com.example.microsoftrewards.entry;

import java.io.Serializable;
import java.util.List;

public class ResultData<T> implements Serializable {
    List<T> RECORDS;

    public List<T> getRECORDS() {
        return RECORDS;
    }

    public void setRECORDS(List<T> RECORDS) {
        this.RECORDS = RECORDS;
    }
}
