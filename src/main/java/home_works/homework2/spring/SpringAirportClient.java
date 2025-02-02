package home_works.homework2.spring;

import home_works.homework2.Flight;
import home_works.homework2.Passanger;
import home_works.homework2.Plane;
import home_works.homework2.TicketOffice;
import home_works.homework2.WaitingRoom;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAirportClient {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AirportAppConfig.class);
        WaitingRoom waitingRoom = context.getBean(WaitingRoom.class);
        TicketOffice ticketOffice = context.getBean(TicketOffice.class);
        Plane boeing777 = context.getBean("Boeing777", Plane.class);
        Flight flightToNewYork = context.getBean(Flight.class);

        //продаем билеты всем пассажирам на произвольные рейсы
        for (Passanger passanger : waitingRoom.getPassangers().values()){
            ticketOffice.sellTicket(passanger);
        }

        //Отображаем данные о самолете
        line();
        System.out.println("Plane: " + boeing777.getModelOfPlane()+ " - " + boeing777.getPassangersQuantity()+ " passenger places");

        line();
        flightToNewYork.startFlight();
        line();
        flightToNewYork.finishFlight();
        line();

    }
    private static void line () {
        System.out.println("---------------------------------------------------------------------------------------");
    }
}
