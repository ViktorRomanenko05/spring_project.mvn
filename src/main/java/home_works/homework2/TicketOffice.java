package home_works.homework2;

import com.github.javafaker.Faker;
import lessons.lesson2.spring.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class TicketOffice {
    ApplicationContext context = new AnnotationConfigApplicationContext(AirportAppConfig.class);
    Office office = context.getBean(Office.class);
    Faker faker = new Faker();
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketOffice.class);

    private static HashMap<String, Ticket> tickets = new HashMap<>();
    ArrayList<Employee> salesAgents = new ArrayList<>();

    public void sellTicket (Passanger passanger) {
       Ticket ticket = new Ticket(randomDestination(), findSalesAgent(), passanger);
       ticket.setStatus(TicketStatus.CONFIRMED);
       passanger.getTickets().put(ticket.getTicketId(), ticket);
       tickets.put(ticket.getTicketId(), ticket);
       LOGGER.info(passanger.getName() + " " + passanger.getSurname() + " purchased the ticket to " + ticket.getDestination().getDescription() + " (Sales agent: " + ticket.getSalesAgent().getName() + " " + ticket.getSalesAgent().getSurname() + ")");
    }


    private Destinations randomDestination () {
        Destinations [] destinations = {Destinations.BERLIN, Destinations.LONDON,
                Destinations.MIAMI, Destinations.PARIS, Destinations.NEW_YORK};
        int rndNum = faker.random().nextInt(0, destinations.length-1);
        return destinations[rndNum];
    }

    private Employee findSalesAgent () {
        getSalesAgents();
        int rndNum = faker.random().nextInt(0, salesAgents.size()-1);
        Employee salesAgent = salesAgents.get(rndNum);
        return salesAgent;
    }

    private void getSalesAgents() {
        for (Employee employee : office.getEmployees().values()) {
            if (employee.getRole() == Role.SALES_AGENT && employee.getStatus() != EmployeeStatus.BUSY) {
                office.getEmployees().get(employee.getId()).setStatus(EmployeeStatus.BUSY);
                salesAgents.add(employee);
            }
        }
    }
}
