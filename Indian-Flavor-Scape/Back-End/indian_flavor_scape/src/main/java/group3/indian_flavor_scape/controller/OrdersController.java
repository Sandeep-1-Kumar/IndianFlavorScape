package group3.indian_flavor_scape.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import group3.indian_flavor_scape.model.Entities.Additives;
import group3.indian_flavor_scape.model.Entities.Customer;
import group3.indian_flavor_scape.model.Entities.Main;
import group3.indian_flavor_scape.model.Entities.Orders;
import group3.indian_flavor_scape.model.Entities.Sides;
import group3.indian_flavor_scape.model.Requests.OrdersRequestJson;
import group3.indian_flavor_scape.model.Responses.OrdersResponseJson;
import group3.indian_flavor_scape.repositories.AdditivesRepository;
import group3.indian_flavor_scape.repositories.CustomerRepository;
import group3.indian_flavor_scape.repositories.MainDishesRepository;
import group3.indian_flavor_scape.repositories.OrderRepository;
import group3.indian_flavor_scape.repositories.SidesRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/IndianFlavorScape")


public class OrdersController {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MainDishesRepository mainDishesRepository;
    
    @Autowired
    private AdditivesRepository additivesRepository;
    
    @Autowired
    private SidesRepository sidesRepository;
    //This method takes care of the placing order process 
    @PostMapping("/customer/placeOrder")
    public @ResponseBody OrdersResponseJson 
    createOrder(@RequestBody OrdersRequestJson ordersRequestJson) {
        Customer customer = customerRepository.
        findByCustomerid(ordersRequestJson.getCustomerId());
        Main main = mainDishesRepository.
        findByid(ordersRequestJson.getMainDishId());
        Additives additives = additivesRepository.
        findByid(ordersRequestJson.getAdditiveId());
        Sides sides = sidesRepository.findByid(ordersRequestJson.getSideId());
        Orders orders = new Orders
        (customer,main,additives,sides,ordersRequestJson.getOrderStatus());
        orders.setOrderTime();
        Orders savedOrder = orderRepository.save(orders);
        OrdersResponseJson ordersResponseJson = 
        new OrdersResponseJson(
            savedOrder.getOrderId(),
            savedOrder.getOrderStatus(),
            savedOrder.getCustomer().getCustomerId(),
            savedOrder.getMain().getName(),
            savedOrder.getAdditives().getName(),
            savedOrder.getSide().getName(),
            savedOrder.getOrderTime()
       );

       return ordersResponseJson;
    }
     
    @GetMapping(path = "/getAllOrders")
    public Map<String, List<Map<String, Object>>> getAllOrders() {
    List<Orders> orders = orderRepository.findAll();
    //Queue implementation
    Queue<Map<String, Object>> orderQueue = new LinkedList<>();
    for (Orders order : orders) {
        Map<String, Object> orderItem = new HashMap<>();
        orderItem.put("orderId", order.getOrderId());
        orderItem.put("customerId", order.getCustomer().getCustomerId());
        orderItem.put("orderTime", order.getOrderTime());
        orderItem.put("orderStatus", order.getOrderStatus());
        orderItem.put("orderItem", 
        order.getMain().getName() +"--" + 
        order.getAdditives().getName() + "--" +
        order.getSide().getName());
        orderQueue.offer(orderItem);
    }
    Map<String, List<Map<String, Object>>> ordersResponseJson = new HashMap<>();
    ordersResponseJson.put("orders", new ArrayList<>(orderQueue));
    return ordersResponseJson;
    }    

    @PostMapping("/employ/updateOrderStatus")
    public void updateOrderStatus
    (@RequestBody OrdersRequestJson ordersRequestJson) {
        Optional<Orders> optionalOrder = 
        orderRepository.findById(ordersRequestJson.getOrderId());
        optionalOrder.ifPresent(order -> {
        String newStatus = ordersRequestJson.getOrderStatus().toUpperCase();
        switch (newStatus) {
            case "INPROGRESS":
                order.setOrderStatus("INPROGRESS");
                break;
            case "DELIVERED":
                order.setOrderStatus("DELIVERED");
                break;
            case "CANCELLED":
                order.setOrderStatus("CANCELLED");
                break;
            case "ORDERED":
                order.setOrderStatus("ORDERED");
                break;
            default:
                break;
        }   
        order.setOrderTime();
        orderRepository.save(order);
        });
    }
//These below set methods are used in to set repositories in order to mock during test cases 
    public void setOrderRepository
    (OrderRepository orderRepository2) {
        this.orderRepository = orderRepository2;
    }

    public void setCustomerRepository
    (CustomerRepository customerRepository2) {
        this.customerRepository = customerRepository2;
    }

    public void setMainDishesRepository
    (MainDishesRepository mainDishesRepository2) {
        this.mainDishesRepository = mainDishesRepository2;
    }

    public void setAdditivesRepository
    (AdditivesRepository additivesRepository2) {
        this.additivesRepository = additivesRepository2;
    }

    public void setSidesRepository
    (SidesRepository sidesRepository2) {
        this.sidesRepository=sidesRepository2;
    }
}
