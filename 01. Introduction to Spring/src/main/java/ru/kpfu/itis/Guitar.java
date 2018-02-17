package ru.kpfu.itis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

/**
 * Created by root on 05.10.15.
 */
//@Primary
@Qualifier("strunnaya")
public class Guitar implements Instrument {
    public void play() {
        System.out.println("GUI!!TAR!");
    }
}
