package home_works.homework2;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashMap;

public class TicketOffice {

    private final Office office;
    Faker faker = new Faker();
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketOffice.class);

    public TicketOffice(Office office) {
        this.office = office;
    }

    private static HashMap<String, Ticket> tickets = new HashMap<>();
    ArrayList<Employee> salesAgents = new ArrayList<>();

    public void sellTicket (Passanger passanger) {
       Ticket ticket = new Ticket(randomDestination(), findSalesAgent(), passanger);
       ticket.setStatus(TicketStatus.CONFIRMED);
       passanger.getTickets().put(ticket.getTicketId(), ticket);
       tickets.put(ticket.getTicketId(), ticket);
       LOGGER.info(passanger.getName() + " " + passanger.getSurname() + " purchased the ticket to " + ticket.getDestination().getDescription() + " (Sales agent: " + ticket.getSalesAgent().getName() + " " + ticket.getSalesAgent().getSurname() + ")");
       LOGGER.info("Ticket #" + ticket.getTicketId() + ", status: " + ticket.getStatus().getDescription());
    }


    private Destination randomDestination () {
        Destination[] destinations = {Destination.BERLIN, Destination.LONDON,
                Destination.MIAMI, Destination.PARIS, Destination.NEW_YORK};
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
