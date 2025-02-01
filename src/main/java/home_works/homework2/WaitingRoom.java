package home_works.homework2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

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

    public HashMap<String, Passanger> getPassangers() {
        return passangers;
    }
}
