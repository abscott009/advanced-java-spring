package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.codewarriorexample.EmailAddress;

@Repository
public interface SuperPowerRepo extends JpaRepository<SuperPower, Long> {

    SuperPower findBySuperPower(String superPower);
}
