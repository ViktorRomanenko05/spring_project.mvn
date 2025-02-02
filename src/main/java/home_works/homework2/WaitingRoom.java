package home_works.homework2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;

public class WaitingRoom {
    private static HashMap <String, Passanger> passangers = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(WaitingRoom.class);

    public void createPassangers () {
        for (int i = 0 ; i < 500 ; i++){
            Passanger passanger = new Passanger();
            passangers.put(passanger.getId(), passanger);
            if (passangers.isEmpty()){
                LOGGER.error("Passangers was not added");
            }
        }
        LOGGER.info("Waiting room is full");
    }

    public Passanger findPassengers(Destination destinationPoint) {
        Iterator<Passanger> iterator = passangers.values().iterator();

        while (iterator.hasNext()) {
            Passanger passanger = iterator.next();
            for (Ticket ticket : passanger.getTickets().values()) {
                if (ticket.getDestination() == destinationPoint && ticket.getStatus() == TicketStatus.CONFIRMED) {
                    ticket.setStatus(TicketStatus.USED);
                    iterator.remove();
                    passanger.registrationOnFlight();
                    return passanger;
                }
            }
        }
        return null;
    }

    public HashMap<String, Passanger> getPassangers() {
        return passangers;
    }
}
