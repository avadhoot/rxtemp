package com.avadhoot.others.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class AppAkka {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create();
        ActorRef reportBuilder = actorSystem.actorOf(ReportBuilderActor.props(actorSystem));
        ActorRef fetchDataActor = actorSystem.actorOf(FetchDataActor.props(actorSystem, reportBuilder));
        FetchData fetchData = new FetchData();
        fetchDataActor.tell(fetchData, ActorRef.noSender());
    }
}
