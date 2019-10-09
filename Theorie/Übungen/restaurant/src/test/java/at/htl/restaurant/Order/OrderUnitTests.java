package at.htl.restaurant.Order;

import at.htl.restaurant.domain.order.IOrderRepository;
import at.htl.restaurant.employee.WaiterUnitTests;
import at.htl.restaurant.model.order.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OrderUnitTests {
    private static Logger log = LoggerFactory.getLogger(WaiterUnitTests.class);

    @Autowired
    private IOrderRepository orderRepository;

    @Test
    public void createOrder() {
    Order order = EntityFactory.createOrderData();
    Order savedEntity = orderRepository.save(order);

    assertNotNull(savedEntity.getId());
    assertEquals(order.getOrderDate(), savedEntity.getOrderDate());
    assertEquals(order.getOrderID(), savedEntity.getOrderID());
    }
}
