package home_works.homework2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AirportAppConfig {

    @Bean
    public Office office () {return new Office();}

    @Bean
    public WaitingRoom waitingRoom () {return new WaitingRoom();}

    @Bean
    public Plane plane () {return new Plane();}

}
