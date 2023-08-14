package group3.indian_flavor_scape.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import group3.indian_flavor_scape.model.Entities.Additives;
import group3.indian_flavor_scape.model.Entities.Main;

public interface AdditivesRepository extends CrudRepository<Additives, Long>{
        List<Additives> findByMain(Main main);
        Additives findByid(Long id);
}
