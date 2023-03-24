package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperHumanRepo extends JpaRepository<SuperHuman, Long> {
    SuperHuman findBySuperPowerAndCodeName(SuperPower superPower, String codeName);

    List<SuperHuman> findByCodeNameIs(String codeName);

    List<SuperHuman> findByCodeNameIsNot(String codeName);


    List<SuperHuman> findByCodeNameIsNull();

    List<SuperHuman> findByCodeNameIsNotNull();

    List<SuperHuman> findByActiveIsTrue();

    List<SuperHuman> getByCodeName(String codeName);

    List<SuperHuman> queryByCodeName(String codeName);

    List<SuperHuman> readByCodeName(String codeName);

    Integer countByCodeName(String codeName);

    List<SuperHuman> findByCodeNameStartingWith(String prefix);


    List<SuperHuman> findByCodeNameEndingWith(String prefix);

    List<SuperHuman> findByCodeNameContaining(String infix);

    List<SuperHuman> findByAgeLessThan(Integer age);

    List<SuperHuman> findByAgeLessThanEqual(Integer age);

    List<SuperHuman> findByAgeGreaterThan(Integer age);

    List<SuperHuman> findByAgeGreaterThanEqual(Integer age);

    List<SuperHuman> findByCodeNameContainingAndAgeGreaterThanEqual(String lastName, Integer age);

    List<SuperHuman> findTop2ByCodeName(String codeName);


    List<SuperHuman> findByCodeNameIgnoreCase(String codeName);

    // Enabling ignoring case for all suitable properties
    List<SuperHuman> findByLastNameAndFirstNameAllIgnoreCase(String lastName, String firstName);

    // Enabling static ORDER BY for a query
    List<SuperHuman> findByLastNameOrderByFirstNameAsc(String lastName);

    List<SuperHuman> findByLastNameOrderByFirstNameDesc(String lastName);

    List<SuperHuman> findBySuperPower_SuperPower(String superPower);
}
