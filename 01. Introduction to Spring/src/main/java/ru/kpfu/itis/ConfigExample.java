package ru.kpfu.itis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigExample {


    @Bean
    //@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    //@Scope("prototype")
    public Instrument guitar() {
        return new Guitar();
    }

    @Bean
    //@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    //@Scope("prototype")
    public Instrument piano() {
        return new Piano();
    }

    @Bean
    public Mucician oleg()
    {
        return  new Mucician();
    }

    @Bean(name = {"petr","ivan"})
    @Scope("prototype")
    public Mucician petro(@Qualifier("piano") Instrument piano)
    {
        Mucician m=  new Mucician();
        m.setAge(33);
        m.setInstrument(piano);
        return m;
    }

    @Bean(name = {"aidar"})
    public Mucician aydar()
    {
        Mucician m=  new Mucician();
        m.setAge(33);
        m.setName("Aydar");
        return m;
    }


}
