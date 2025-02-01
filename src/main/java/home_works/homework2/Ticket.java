package home_works.homework2;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;

public class Ticket {

    Faker faker = new Faker();

    private final String ticketId;
    private final LocalDateTime purchaseTime;
    private LocalDateTime expirationTime;
    private final Destinations destination;
    private TicketStatus status;
    private final Employee salesAgent;
    private final Passanger passanger;

    public Ticket(Destinations destination, Employee salesAgent, Passanger passanger) {
        this.ticketId = faker.idNumber().valid();
        this.purchaseTime = LocalDateTime.now();
        this.expirationTime = purchaseTime.plusDays(3);
        this.destination = destination;
        this.status = TicketStatus.BOOKED;
        this.salesAgent = salesAgent;
        this.passanger = passanger;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public Destinations getDestination() {
        return destination;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public Employee getSalesAgent() {
        return salesAgent;
    }

    public Passanger getPassanger() {
        return passanger;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
