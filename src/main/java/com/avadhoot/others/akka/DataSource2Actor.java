package com.avadhoot.others.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class DataSource2Actor extends AbstractActor {

    private ActorRef reportBuilder;

    public DataSource2Actor(ActorRef reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(FetchData.class, data -> fetchData())
                .build();
    }

    private void fetchData() {
        DataObject2 do2 = new DataObject2("AkkaDS2-345");
        reportBuilder.tell(do2, self());
    }

    public static Props props(ActorRef reportBuilder) {
        return Props.create(DataSource2Actor.class, () -> new DataSource2Actor(reportBuilder));
    }
}
