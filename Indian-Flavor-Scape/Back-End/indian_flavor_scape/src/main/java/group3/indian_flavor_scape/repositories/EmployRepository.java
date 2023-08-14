package group3.indian_flavor_scape.repositories;

import org.springframework.data.repository.CrudRepository;

import group3.indian_flavor_scape.model.Entities.Employ;

public interface EmployRepository extends CrudRepository<Employ, Long> {
    Employ findByEmail(String email);
}

