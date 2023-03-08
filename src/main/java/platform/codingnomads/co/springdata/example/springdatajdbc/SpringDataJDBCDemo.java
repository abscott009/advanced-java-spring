package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {
//        jdbcTemplate.execute("TRUNCATE TABLE sport_risk;");
//        //delete the table
//        jdbcTemplate.execute("DROP TABLE sport_risk");

        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE sport_risk (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "sport VARCHAR(255) NOT NULL,risk  VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            throw e;
        }

        //create a list of first and last names
        List<Object[]> splitUpPair = Stream.of("Golf-Low", "Soccer-Medium", "Bear Wrestling-High", "Lawn Darts-High")
                .map(pair -> pair.split("-"))
                .collect(Collectors.toList());

        //for each first & last name pair insert an Employee into the database
        for (Object[] pair : splitUpPair) {
            jdbcTemplate.execute(String.format("INSERT INTO sport_risk (sport, risk) VALUES ('%s','%s')", pair[0], pair[1]));
        }

        //query the database for Employees with first name Java
        jdbcTemplate.query(
                        "SELECT id, sport, risk FROM sport_risk WHERE risk = 'High'",
                        (rs, rowNum) -> new SportRisk(rs.getLong("id"), rs.getString("sport"), rs.getString("risk"))
                )
                //print each found employee to the console
                .forEach(SportRisk -> System.out.println(SportRisk.toString()));

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE sport_risk;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE sport_risk");
    }
}
