package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class SportRisk {
    private long id;
    private String sport, risk;

    public SportRisk(long id, String sport, String risk) {
        this.id = id;
        this.sport = sport;
        this.risk = risk;
    }
}