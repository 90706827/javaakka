package com.jangni.javaakka.helloword;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * @program: javaakka
 * @description: helloword
 * @author: Mr.Jangni
 * @create: 2018-06-29 00:02
 **/

public class HelloWorld extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("abc",a ->{
                    log.info("Received String message abc:{}", a);
                })
                .match(String.class, s -> {
                    log.info("Received String message:{}", s);
                    getSender().tell(s, getSelf());
                })
                .match(Integer.class, i -> {
                    log.info("Received String message:{}", i);
                    getSender().tell(i + 2, getSelf());
                })
                .matchAny(o -> log.info("received unknown message"))
                .build();
    }

    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("SwapperSystem");
        ActorRef helloActor = system.actorOf(Props.create(HelloWorld.class));
        helloActor.tell("abcd",ActorRef.noSender());

    }

}
