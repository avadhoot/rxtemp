package com.avadhoot.others.rx;

import io.reactivex.Observable;

public class DataSourceRx1 implements DataSourceRx {
    @Override
    public Observable<DataObject> fetchData() {
        return Observable.just(new DataObject("RxDS1-123"));
    }
}
