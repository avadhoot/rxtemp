package com.avadhoot.others.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class FetchDataActor extends AbstractActor {

    private ActorSystem actorSystem;
    private ActorRef reportBuilderActor;
    ActorRef ds1;
    ActorRef ds2;

    public FetchDataActor(ActorSystem actorSystem, ActorRef reportBuilderActor) {
        this.actorSystem = actorSystem;
        this.reportBuilderActor = reportBuilderActor;
        init();
    }

    private void init() {
        ds1 = actorSystem.actorOf(DataSource1Actor.props(reportBuilderActor));
        ds2 = actorSystem.actorOf(DataSource2Actor.props(reportBuilderActor));

    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(FetchData.class, data -> processRequest(data))
                .build();
    }

    private void processRequest(FetchData data) {
        ds1.tell(data, ActorRef.noSender());
        ds2.tell(data, ActorRef.noSender());
    }

    public static Props props(ActorSystem actorSystem, ActorRef reportBuilderActor) {
        return Props.create(FetchDataActor.class, () -> new FetchDataActor(actorSystem, reportBuilderActor));
    }
}
