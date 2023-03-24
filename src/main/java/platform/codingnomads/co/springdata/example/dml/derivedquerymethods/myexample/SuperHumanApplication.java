package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperHuman;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperHumanRepo;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPower;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPowerRepo;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SuperHumanApplication implements CommandLineRunner {

    @Autowired
    SuperPowerRepo superPowerRepo;

    @Autowired
    SuperHumanRepo superHumanRepo;

    public static void main(String[] args) {
        SpringApplication.run(SuperHumanApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        final platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPower marvel1 = platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPower.builder().superPower("Healing Factor").build();
        final platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPower dc1 = platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPower.builder().superPower("Speed").build();
        final platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPower marvel2 = platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPower.builder().superPower("Money").build();
        final platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPower dc2 = platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPower.builder().superPower("Money").build();

        final List<platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.SuperPower> superPowers = Arrays.asList(marvel1, dc1, marvel2, dc2);

        if (superPowerRepo.findAll().isEmpty()) {
            superPowerRepo.saveAll(superPowers);
        }

        final List<SuperHuman> superHumans = Arrays.asList(
                SuperHuman.builder().firstName("Logan").lastName("Unknown").codeName("Wolverine").superPower(marvel1).active(true).age(372).build(),
                SuperHuman.builder().firstName("Barry").lastName("Allen").codeName("Flash").superPower(dc1).active(true).age(34).build(),
                SuperHuman.builder().firstName("Tony").lastName("Stark").codeName("Iron Man").superPower(marvel2).active(true).age(38).build(),
                SuperHuman.builder().firstName("Bruce").lastName("Wayne").codeName("Batman").superPower(dc2).active(true).age(42).build()

        );
        if (superHumanRepo.findAll().isEmpty()) {
            superHumanRepo.saveAll(superHumans);
        }

        final SuperPower superPower = superPowerRepo.findBySuperPower("Healing Factor");

        System.out.println("***************************************************Power & Code Name***************************************************");
        final SuperHuman bySuperPowerAndCodeName = superHumanRepo.findBySuperPowerAndCodeName(marvel1,"Flash");
        System.out.println(bySuperPowerAndCodeName);


        System.out.println("***************************************************findTop2ByLastName***************************************************");
        final List<SuperHuman> findSuperHumans = superHumanRepo.findBySuperPower_SuperPower("Money");
        findSuperHumans.forEach(System.out::println);


        System.out.println("***************************************************findByLastNameIgnoreCase***************************************************");
        final List<SuperHuman> byLastNameIgnoreCase = superHumanRepo.findByCodeNameIgnoreCase("Iron Man");
        byLastNameIgnoreCase.forEach(System.out::println);


        System.out.println("***************************************************findByLastNameAndFirstNameAllIgnoreCase***************************************************");
        final List<SuperHuman> byLastNameAndFirstNameAllIgnoreCase = superHumanRepo.findByLastNameAndFirstNameAllIgnoreCase("allen", "barry");
        byLastNameAndFirstNameAllIgnoreCase.forEach(System.out::println);


        System.out.println("***************************************************findByLastNameOrderByFirstNameAsc***************************************************");
        final List<SuperHuman> byLastNameOrderByFirstNameAsc = superHumanRepo.findByLastNameOrderByFirstNameAsc("Unknown");
        byLastNameOrderByFirstNameAsc.forEach(System.out::println);


        System.out.println("***************************************************findByLastNameOrderByFirstNameDesc***************************************************");
        final List<SuperHuman> byLastNameOrderByFirstNameDesc = superHumanRepo.findByLastNameOrderByFirstNameDesc("Stark");
        byLastNameOrderByFirstNameDesc.forEach(System.out::println);


        System.out.println("***************************************************findByEmailAddress_EmailAddress***************************************************");
        final List<SuperHuman> bySuperPower_superPower = superHumanRepo.findBySuperPower_SuperPower("Speed");
        System.out.println(bySuperPower_superPower);

    }
}
