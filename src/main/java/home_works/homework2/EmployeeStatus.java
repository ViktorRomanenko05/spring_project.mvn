package home_works.homework2;

import lombok.Getter;

@Getter
public enum EmployeeStatus {
    FREE("free"),
    BUSY("busy");

    private final String description;

    EmployeeStatus(String description) {
        this.description = description;
    }

}
