package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class ToonAnimals {
    private long id;
    private String firstName, lastName;

    public ToonAnimals(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}