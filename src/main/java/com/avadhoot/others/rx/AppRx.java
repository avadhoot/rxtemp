package com.avadhoot.others.rx;


import io.reactivex.Observable;

public class AppRx {

    public static void main(String[] args) {
        AppRx app = new AppRx();
        app.buildReport();
    }

    public void buildReport() {
        DataSourceRx ds1 = new DataSourceRx1();
        DataSourceRx ds2 = new DataSourceRx2();
        ReportBuilderRx reportBuilder = new ReportBuilderRx();

        Observable.zip(ds1.fetchData(), ds2.fetchData(), (do1, do2) -> {
            reportBuilder.printReport(do1, do2);
            return reportBuilder;
        }).blockingSubscribe();
    }
}
