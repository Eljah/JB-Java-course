package ru.kpfu.itis;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by root on 05.10.15.
 */
public interface Instrument {

    void play();

    //@PostConstruct не работают отсюда
    public void init();

    //@PreDestroy не работают отсюда
    public void destroy();

}
