package com.jangni.javaakka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.jangni.javaakka.helloword.HelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @program: javaakka
 * @description: 启动类
 * @author: Mr.Jangni
 * @create: 2018-06-28 23:37
 **/
@SpringBootApplication(scanBasePackages = "com.jangni")
public class Application {

    @Bean
    ActorSystem actorSystem() {
        return ActorSystem.create("hello");
    }

    @Bean
    ActorRef hellowWorld(ActorSystem actorSystem) {
        ActorRef helloword = actorSystem.actorOf(Props.create(HelloWorld.class), "helloWorld");
        System.out.println(helloword.path());
        return helloword;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
