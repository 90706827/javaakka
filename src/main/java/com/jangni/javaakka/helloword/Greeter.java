package com.jangni.javaakka.helloword;

import akka.actor.UntypedActor;

/**
 * @program: javaakka
 * @description: getter
 * @author: Mr.Jangni
 * @create: 2018-06-29 00:02
 **/

public class Greeter extends UntypedActor {
    public static enum Msg {
        GREET, DONE;
    }

    @Override
    public void onReceive(Object msg) throws InterruptedException {
        if (msg == Msg.GREET) {
            System.out.println("Hello World!");
            Thread.sleep(1000);
            getSender().tell(Msg.DONE, getSelf());
        } else
            unhandled(msg);
    }

}
