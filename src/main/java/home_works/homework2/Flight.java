package home_works.homework2;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Flight {

    ApplicationContext context = new AnnotationConfigApplicationContext(AirportAppConfig.class);
    Office office = context.getBean(Office.class);
    WaitingRoom waitingRoom = context.getBean(WaitingRoom.class);
    private static final Logger LOGGER = LoggerFactory.getLogger(Flight.class);
    Faker faker = new Faker();

    private Plane plane;
    private String flightNumber;
    private String company;
    private Destinations destinationPoint;
    private LocalDateTime departureTime;
    private LocalDateTime arriveTime;
    private ArrayList<Employee> crew;
    private ArrayList<Passanger> passangers;

    public Flight(Plane plane, Destinations destinationPoint) {
        this.plane = plane;
        this.company = "Pan American";
        this.flightNumber = "914";
        this.destinationPoint = destinationPoint;
        this.departureTime = LocalDateTime.now().plusHours(1);
        this.arriveTime = LocalDateTime.now().plusHours(10);
        this.crew = new ArrayList<>();
        this.passangers = new ArrayList<>();
    }

    public void boarding (){
        for (int i = 0; i < plane.getPilotsQuantity(); i++){
            crew.add(findPilots());
        }
        LOGGER.info("Pilots on board");
        for (int i = 0; i < plane.getStewartsQuantity(); i++){
            crew.add(findStewart());
        }
        LOGGER.info("Stewarts on board");
        for (int i =0; i <plane.getPassangersQuantity(); i++){
            passangers.add(findPassengers());
        }
        LOGGER.info("All passangers on board");
    }

    private Employee findStewart () {
        ArrayList <Employee> stewarts = new ArrayList<>();
        for (Employee employee : office.getEmployees().values()){
            if (employee.getRole() == Role.STEWART && employee.getStatus() != EmployeeStatus.BUSY){
                stewarts.add(employee);
            }
        }
        int rndNum = faker.random().nextInt(0, stewarts.size()-1);
        Employee stewart = stewarts.get(rndNum);
        office.getEmployees().get(stewart.getId()).setStatus(EmployeeStatus.BUSY);
        return stewart;
    }

    private Employee findPilots () {
        ArrayList <Employee> pilots = new ArrayList<>();
        for (Employee employee : office.getEmployees().values()){
            if (employee.getRole() == Role.PILOT && employee.getStatus() != EmployeeStatus.BUSY){
                pilots.add(employee);
            }
        }
        int rndNum = faker.random().nextInt(0, pilots.size());
        Employee pilot = pilots.get(rndNum);
        office.getEmployees().get(pilot.getId()).setStatus(EmployeeStatus.BUSY);
        return pilot;
    }

    private Passanger findPassengers() {
        Iterator<Passanger> iterator = waitingRoom.getPassangers().values().iterator();

        while (iterator.hasNext()) {
            Passanger passanger = iterator.next();
            for (Ticket ticket : passanger.getTickets().values()) {
                if (ticket.getDestination() == destinationPoint) {
                    iterator.remove();
                    return passanger;
                }
            }
        }
        return null;
    }



    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getCompany() {
        return company;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public Destinations getDestination() {
        return destinationPoint;
    }

    public LocalDateTime getArriveTime() {
        return arriveTime;
    }

    public ArrayList<Employee> getCrew() {
        return crew;
    }

    public ArrayList<Passanger> getPassangers() {
        return passangers;
    }
}
