package com.avadhoot.others.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class DataSource1Actor extends AbstractActor {

    private ActorRef reportBuilder;

    public DataSource1Actor(ActorRef reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(FetchData.class, data -> fetchData())
                .build();
    }

    private void fetchData() {
        DataObject1 do1 = new DataObject1("AkkaDS1-123");
        reportBuilder.tell(do1, self());
    }

    public static Props props(ActorRef reportBuilder) {
        return Props.create(DataSource1Actor.class, () -> new DataSource1Actor(reportBuilder));
    }
}
