package group3.indian_flavor_scape.repositories;
import org.springframework.data.repository.CrudRepository;

import group3.indian_flavor_scape.model.Entities.Orders;
import java.util.*;

public interface OrderRepository extends CrudRepository<Orders, Long> {
    List<Orders> findAll();
    Optional<Orders> findById(Long Orderid);
}
