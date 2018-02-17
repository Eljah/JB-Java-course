package ru.kpfu.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by root on 05.10.15.
 */
public class Main {

    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigExample.class);
        Mucician m = (Mucician) context.getBean("oleg");
        System.out.println(m.name);
        System.out.println(m.age);

        Mucician m2 = (Mucician) context.getBean("petr");
        System.out.println(m2.getName());
        System.out.println(m2.getAge());
        m2.setAge(23);
        System.out.println(m2.getAge());
        m2 = (Mucician) context.getBean("petr");
        System.out.println(m2.getAge());

        Mucician m3 = (Mucician) context.getBean("ivan");
        m3.getInstrument().play();

        Mucician m4 = (Mucician) context.getBean("aidar");
        m4.getInstrument().play();

    }

}
