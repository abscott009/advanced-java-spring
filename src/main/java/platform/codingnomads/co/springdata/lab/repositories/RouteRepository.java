package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

List<Route> findByOriginCode(String code);
List<Route> findByDestinationCode(String code);
List<Route> findAllByCodeContaining(String code);
Route findByCode(String code);

}
