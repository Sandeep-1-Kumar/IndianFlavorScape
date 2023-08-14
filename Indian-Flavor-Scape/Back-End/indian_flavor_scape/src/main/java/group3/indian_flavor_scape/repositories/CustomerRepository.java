package group3.indian_flavor_scape.repositories;

import org.springframework.data.repository.CrudRepository;

import group3.indian_flavor_scape.model.Entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByCustomerid(Long customerid);
}