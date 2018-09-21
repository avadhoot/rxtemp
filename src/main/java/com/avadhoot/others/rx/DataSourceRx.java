package com.avadhoot.others.rx;

import io.reactivex.Observable;

public interface DataSourceRx {
    Observable<DataObject> fetchData();
}
