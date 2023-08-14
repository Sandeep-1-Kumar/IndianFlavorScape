package group3.indian_flavor_scape.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import group3.indian_flavor_scape.model.Entities.Main;

public  interface MainDishesRepository extends CrudRepository<Main, Long>{
    List<Main> findAll();    
    Main findByid(Long id);    
}


