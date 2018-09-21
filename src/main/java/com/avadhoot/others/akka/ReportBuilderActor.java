package com.avadhoot.others.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ReportBuilderActor extends AbstractActor {

    ActorSystem actorSystem;

    DataObject1 do1;
    DataObject2 do2;

    public ReportBuilderActor(ActorSystem actorSystem) {
        this.actorSystem = actorSystem;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(DataObject1.class, data -> processData(data))
                .match(DataObject2.class, data -> processData(data))
                .build();
    }

    private void processData(DataObject1 data) {
        do1 = data;
        if(do1 != null && do2 != null) {
            System.out.println("Report: " + do1.getValue() + " - " + do2.getValue());
            actorSystem.terminate();
        }
    }

    private void processData(DataObject2 data) {
        do2 = data;
        if(do1 != null && do2 != null) {
            System.out.println("Report: " + do1.getValue() + " - " + do2.getValue());
            actorSystem.terminate();
        }
    }

    public static Props props(ActorSystem actorSystem) {
        return Props.create(ReportBuilderActor.class, () -> new ReportBuilderActor(actorSystem));
    }
}
