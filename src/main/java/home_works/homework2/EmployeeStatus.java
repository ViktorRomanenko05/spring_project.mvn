package home_works.homework2;

public enum EmployeeStatus {
    FREE ("free"),
    BUSY ("busy");

    private String description;

    EmployeeStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
