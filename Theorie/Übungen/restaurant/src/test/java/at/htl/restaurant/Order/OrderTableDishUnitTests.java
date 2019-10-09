package at.htl.restaurant.Order;

import at.htl.restaurant.domain.branch.ITableRepository;
import at.htl.restaurant.domain.dish.IDishRepository;
import at.htl.restaurant.domain.order.IOrderRepository;
import at.htl.restaurant.domain.order.IOrderTableDishRepository;
import at.htl.restaurant.employee.WaiterUnitTests;
import at.htl.restaurant.model.branch.Table;
import at.htl.restaurant.model.dish.Dish;
import at.htl.restaurant.model.dish.EDishType;
import at.htl.restaurant.model.order.Order;
import at.htl.restaurant.model.order.OrderTableDish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OrderTableDishUnitTests {
    private static Logger log = LoggerFactory.getLogger(WaiterUnitTests.class);

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IOrderTableDishRepository orderTableDishRepository;

    @Autowired
    private  ITableRepository tableRepository;

    @Autowired
    private IDishRepository dishRepository;


    @Test
    public void createOrderTableDish() {

        Order order = EntityFactory.createOrderData();

        Table table = new Table();
        table.setTableNr(123);
        table.setSmokingAllowed(true);

        Dish dish = new Dish();
        dish.setDishType(EDishType.ZUSPEISE);
        dish.setName("Salateee");
        dish.setPrice(2);

        OrderTableDish orderTableDish = EntityFactory.createOrderTableDishData(orderRepository.save(order), tableRepository.save(table), dishRepository.save(dish));

        OrderTableDish savedEntity = orderTableDishRepository.save(orderTableDish);

        assertNotNull(savedEntity.getId());
    }
}
