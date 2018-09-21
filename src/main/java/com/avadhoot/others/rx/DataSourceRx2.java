package com.avadhoot.others.rx;

import io.reactivex.Observable;

public class DataSourceRx2 implements DataSourceRx {
    @Override
    public Observable<DataObject> fetchData() {
        return Observable.just(new DataObject("RxDS2-453"));
    }
}
