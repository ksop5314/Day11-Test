package est.day11.order.repository;

import est.day11.order.dto.OrderResponse;
import est.day11.order.entity.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o JOIN FETCH o.products p JOIN FETCH o.delivery d")
    List<Order> findAllOrders();

    @Query("SELECT o From Order o")
    List<Order> findAllOnlyOrders();

}
