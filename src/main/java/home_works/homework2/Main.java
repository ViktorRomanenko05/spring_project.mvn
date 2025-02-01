package home_works.homework2;

public class Main {
    public static void main(String[] args) {
        Office office = new Office();
        WaitingRoom waitingRoom = new WaitingRoom();
        TicketOffice ticketOffice = new TicketOffice();
        Plane plane = new Plane();
        Flight flight = new Flight(plane, Destinations.NEW_YORK);
        office.parseEmployees();
        waitingRoom.createPassangers();

        for (Passanger passanger : waitingRoom.getPassangers().values()){
            ticketOffice.sellTicket(passanger);
        }

        System.out.println(plane.getModelOfPlane()+plane.getPassangersQuantity());

        flight.boarding();
    }
}
