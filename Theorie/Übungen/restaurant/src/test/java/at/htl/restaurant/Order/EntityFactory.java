package at.htl.restaurant.Order;

import at.htl.restaurant.model.branch.Table;
import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.order.Order;
import at.htl.restaurant.model.order.OrderTableDish;

import java.util.Date;

public class EntityFactory {

    public static Order createOrderData() {
        Order order = new Order();

        order.setOrderDate(new Date());
        order.setOrderID(12);

        return order;
    }
    public static OrderTableDish createOrderTableDishData(Order order, Table table, Dish dish) {

        OrderTableDish orderTableDish = new OrderTableDish(order, table, dish);

        return orderTableDish;
    }
}
