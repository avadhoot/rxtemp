package com.avadhoot.rxtemp;

public class DataSource1 implements DataSource {
    @Override
    public DataObject fetchData() {
        return new DataObject("RegularDS1-123");
    }
}
