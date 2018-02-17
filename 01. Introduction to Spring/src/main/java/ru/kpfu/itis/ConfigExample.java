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
    @Primary
    //@Qualifier("guitar")
    //@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    //@Scope("prototype")
    public Instrument guitar() {
        return new Guitar();
    }

    @Bean
    @Qualifier("piano")
    //@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    //@Scope("prototype")
    public Piano piano() {
        return new Piano();
    }

    @Bean
    public Mucician oleg()
    {
        return  new Mucician();
    }

    @Bean(name = {"petr","ivan"})
    @Scope("prototype")
    public Mucician petro(Piano instrument)
    {
        Mucician m=  new Mucician();
        m.setAge(33);
        m.setInstrument(instrument);
        return m;
    }

    @Bean(name = {"aidar"})
    public Mucician aydar(Instrument instrument)
    {
        Mucician m=  new Mucician();
        m.setAge(33);
        m.setName("Aydar");
        m.setInstrument(instrument);
        return m;
    }


}
