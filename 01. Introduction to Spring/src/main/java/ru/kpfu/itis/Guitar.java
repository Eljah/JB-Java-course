package ru.kpfu.itis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by root on 05.10.15.
 */
//@Primary
@Qualifier("strunnaya")
@Lazy
public class Guitar implements Instrument {
    public void play() {
        System.out.println("GUI!!TAR!");
    }

    @PostConstruct
    public void init() {
        System.out.println("Init Guitar!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy Guitar!");
    }
}
