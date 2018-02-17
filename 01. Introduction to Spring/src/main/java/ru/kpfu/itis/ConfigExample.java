package ru.kpfu.itis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import javax.annotation.PreDestroy;

@Configuration
public class ConfigExample {


    @Bean
    //@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    //@Scope("prototype")
    @Qualifier("guitar")
    @Primary
    public Instrument guitar() {
        return new Guitar();
    }

    @Bean
    //@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    //@Scope("prototype")
    @Qualifier("piano")
    public Instrument piano() {
        return new Piano();
    }

    @Bean
    public Mucician oleg()
    {
        System.out.println("Init Oleg");
        return  new Mucician();
    }

    @Bean(name = {"petr","ivan"})
    @Scope("prototype")
    public Mucician petro(@Qualifier("piano") Instrument piano)
    {
        System.out.println("Init Petr of Ivan");
        Mucician m=  new Mucician();
        m.setAge(33);
        m.setInstrument(piano);
        return m;
    }

    @Bean(name = {"aidar"})
    @Lazy
    public Mucician aydar()
    {
        System.out.println("Init Aydar");
        Mucician m=  new Mucician();
        m.setAge(33);
        m.setName("Aydar");
        return m;
    }


}
