package ru.kpfu.itis;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class Piano implements Instrument{


    public void play() {
        System.out.println("PIANO!!!");
    }

    @PostConstruct
    public void init() {
        System.out.println("Init Piano!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy Piano!");
    }
}
