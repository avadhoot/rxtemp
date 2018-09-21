package com.avadhoot.rxtemp;


public class App {

    public static void main(String[] args) {
        App app = new App();
        app.buildReport();
    }

    public void buildReport() {
        DataSource ds1 = new DataSource1();
        DataSource ds2 = new DataSource2();
        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.printReport(ds1.fetchData(), ds2.fetchData());
    }
}
