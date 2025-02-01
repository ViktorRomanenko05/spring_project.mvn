package home_works.homework2;

public class Plane {

    private String modelOfPlane;
    private int pilotsQuantity;
    private int stewartsQuantity;
    private int passangersQuantity;

    public Plane() {
        this.modelOfPlane = "Boeing 777-200ER Dreamliner";
        this.pilotsQuantity = 2;
        this.stewartsQuantity = 6;
        this.passangersQuantity = 314;
    }

    public String getModelOfPlane() {
        return modelOfPlane;
    }

    public int getPilotsQuantity() {
        return pilotsQuantity;
    }

    public int getStewartsQuantity() {
        return stewartsQuantity;
    }

    public int getPassangersQuantity() {
        return passangersQuantity;
    }
}
