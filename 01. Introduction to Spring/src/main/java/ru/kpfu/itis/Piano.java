package ru.kpfu.itis;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Piano implements Instrument{


    public void play() {
        System.out.println("PIANO!!!");
    }
}
