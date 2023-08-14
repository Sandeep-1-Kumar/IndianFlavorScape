package group3.indian_flavor_scape.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import group3.indian_flavor_scape.model.Entities.Main;
import group3.indian_flavor_scape.model.Entities.Sides;


public interface SidesRepository extends CrudRepository<Sides, Long>{
    List<Sides> findByMain(Main main);
    Sides findByid(Long id);
}



