package at.htl.restaurant.model.order;

import at.htl.restaurant.model.branch.Table;
import at.htl.restaurant.model.dish.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Embeddable
public class OrderTableDishID implements Serializable{

    public OrderTableDishID(Order order, Table table, Dish dish) {
        this.order = order;
        this.table = table;
        this.dish = dish;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "BESTELLUNGS_ID", nullable = false, updatable = false)
    private Order order;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TISCH_ID", nullable = false, updatable = false)
    private Table table;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "GERICHT_ID", nullable = false, updatable = false)
    private Dish dish;

}
