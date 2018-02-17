package ru.kpfu.itis;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigExample {


    @Bean
    //@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    //@Scope("prototype")
    public Guitar guitar() {
        return new Guitar();
    }

}
