package home_works.homework2.spring;

import home_works.homework2.Destination;
import home_works.homework2.Flight;
import home_works.homework2.Office;
import home_works.homework2.Plane;
import home_works.homework2.TicketOffice;
import home_works.homework2.WaitingRoom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AirportAppConfig {

    @Bean
    public Office office() {
        return new Office();
    }

    @Bean
    public WaitingRoom waitingRoom() {
        return new WaitingRoom();
    }

    //Так как самолет в демонстрации только один пропишем его непосредственно здесь
    @Bean(name = "Boeing777")
    public Plane plane() {
        return new Plane("Boeing 777-200ER Dreamliner", 2, 6, 314);
    }

    //Для демонстрации используем только один рейс
    @Bean(name = "Boeing_to_New_York")
    public Flight flightToNewYork(Plane plane, Office office, WaitingRoom waitingRoom) {
        office.parseEmployees(); //временно здесь, пока не знаем как правильно конфигурировать
        waitingRoom.createPassengers();// также^
        return new Flight(plane, Destination.NEW_YORK, office, waitingRoom, "Pan American", "914");
    }

    @Bean
    public TicketOffice ticketOffice(Office office, WaitingRoom waitingRoom) {
        return new TicketOffice(office, waitingRoom);
    }
}