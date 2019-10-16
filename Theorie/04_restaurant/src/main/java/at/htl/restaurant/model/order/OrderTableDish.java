package at.htl.restaurant.model.order;

import at.htl.restaurant.model.dish.Dish;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "BESTELLUNGEN_TISCHE_GERICHTE")
public class OrderTableDish implements Serializable{

    @Getter
    @NotNull
    @EmbeddedId
    private OrderTableDishID id;

    public OrderTableDish(final Order order, final at.htl.restaurant.model.branch.Table table, final Dish dish) {
        id = new OrderTableDishID(order, table, dish);
    }

    @Column
    private Long version;
}
