package home_works.homework2;
import lombok.Getter;

@Getter
public enum Destinations {
    PARIS("Paris"),
    LONDON("London"),
    BERLIN("Berlin"),
    NEW_YORK("New York"),
    MIAMI("Miami");

    private final String description;

    Destinations(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
