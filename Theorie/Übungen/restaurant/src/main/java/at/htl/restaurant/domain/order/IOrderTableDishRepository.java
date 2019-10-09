package at.htl.restaurant.domain.order;

import at.htl.restaurant.model.order.OrderTableDish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderTableDishRepository extends JpaRepository<OrderTableDish, Long> {
}
