package at.htl.restaurant.domain.order;

import at.htl.restaurant.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
