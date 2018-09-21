package com.avadhoot.rxtemp;

public class DataSource2 implements DataSource {
    @Override
    public DataObject fetchData() {
        return new DataObject("RegularDS2-456");
    }
}
