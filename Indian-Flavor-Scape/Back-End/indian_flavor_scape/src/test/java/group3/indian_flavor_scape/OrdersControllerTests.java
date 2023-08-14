package group3.indian_flavor_scape;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;


import group3.indian_flavor_scape.controller.OrdersController;
import group3.indian_flavor_scape.model.Entities.*;
import group3.indian_flavor_scape.model.Requests.OrdersRequestJson;
import group3.indian_flavor_scape.model.Responses.OrdersResponseJson;
import group3.indian_flavor_scape.repositories.*;

public class OrdersControllerTests {

    @InjectMocks
    private OrdersController ordersController;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private MainDishesRepository mainDishesRepository;

    @Mock
    private AdditivesRepository additivesRepository;

    @Mock
    private SidesRepository sidesRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrder_Success() {
        long customerId = 1001;
        long mainDishId = 1;
        long additiveId = 2;
        long sideId = 3;
        String orderStatus = "ORDERED";
        OrdersRequestJson ordersRequestJson = 
        new OrdersRequestJson(customerId, orderStatus, mainDishId, additiveId, sideId);
        Customer customer = 
        new Customer("bhanu@gmail.com", "Bhanu", "password");
        Main main = new Main(1, "Rice");
        Additives additives = new Additives("Chicken Curry", main);
        Sides sides = new Sides("salad", main);
        when(customerRepository.findByCustomerid(customerId)).thenReturn(customer);
        when(mainDishesRepository.findByid(mainDishId)).thenReturn(main);
        when(additivesRepository.findByid(additiveId)).thenReturn(additives);
        when(sidesRepository.findByid(sideId)).thenReturn(sides);
        Orders savedOrder = new Orders(customer, main, additives, sides, orderStatus);
        savedOrder.setOrderId(1L);
        when(orderRepository.save(any(Orders.class))).thenReturn(savedOrder);
        OrdersResponseJson response = ordersController.createOrder(ordersRequestJson);
        assertNotNull(response);
        assertEquals(1L, response.getOrderId());
        assertEquals(orderStatus, response.getOrderStatus());
        assertEquals("Rice", response.getMainDish());
        assertEquals("Chicken Curry", response.getAdditive());
        assertEquals("salad", response.getSideDish());
    }

    @Test
    void testUpdateOrderStatus_ValidStatus() {
        long customerId = 1001;
        long mainDishId = 1;
        long additiveId = 2;
        long sideId = 3;
        String orderStatus = "ORDERED";
        OrdersRequestJson ordersRequestJson = 
        new OrdersRequestJson(customerId, orderStatus, mainDishId, additiveId, sideId);
        long orderId = 1;
        String newStatus = "INPROGRESS";
        Orders order = new Orders();
        order.setOrderId(orderId);
        order.setOrderStatus(newStatus);
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
        ordersController.updateOrderStatus(ordersRequestJson);
        assertEquals(newStatus, order.getOrderStatus());
    }

    @Test
    void testGetAllOrders() {
        Orders order1 = new Orders(new Customer(), new Main(), new Additives(), new Sides(), "ORDERED");
        Orders order2 = new Orders(new Customer(), new Main(), new Additives(), new Sides(), "ORDERED");
        List<Orders> ordersList = Arrays.asList(order1, order2);

        when(orderRepository.findAll()).thenReturn(ordersList);

        Map<String, List<Map<String, Object>>> response = ordersController.getAllOrders();

        assertNotNull(response);
        assertTrue(response.containsKey("orders"));
        List<Map<String, Object>> orders = response.get("orders");
        assertEquals(2, orders.size());
    }
}
