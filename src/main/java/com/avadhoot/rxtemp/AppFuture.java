package com.avadhoot.rxtemp;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AppFuture {
    public static void main(String[] args) {
        DataSource1 ds1 = new DataSource1();
        DataSource2 ds2 = new DataSource2();
        ReportBuilder reportBuilder = new ReportBuilder();

        CompletableFuture<DataObject> ds1Future = CompletableFuture.supplyAsync(() -> ds1.fetchData());
/*
        ds1Future

                .thenCombine(CompletableFuture.supplyAsync(() -> ds2.fetchData()),
                        (do1, do2) -> {
                            reportBuilder.printReport(do1, do2);
                            return reportBuilder;
                        });
*/

        try {
            CompletableFuture<ReportBuilder> reportBuilderFuture = ds1Future
                    .thenCombine(CompletableFuture.supplyAsync(() -> ds2.fetchData()),
                            (do1, do2) -> {
                                reportBuilder.printReport(do1, do2);
                                return reportBuilder;
                            });
            reportBuilderFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
