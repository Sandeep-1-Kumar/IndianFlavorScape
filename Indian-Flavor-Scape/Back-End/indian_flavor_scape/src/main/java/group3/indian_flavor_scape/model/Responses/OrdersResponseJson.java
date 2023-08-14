package group3.indian_flavor_scape.model.Responses;

import java.time.LocalDateTime;

public class OrdersResponseJson {
    private Long orderId;
    private String orderStatus;
    private Long customerId;
    private String mainDish;
    private String additive;
    private String sideDish;
    private LocalDateTime orederDateTime;
    public Long getOrderId() {
        return orderId;
    }
    public OrdersResponseJson() {
    }
    public OrdersResponseJson(Long orderId, String orderStatus, 
    Long customerId, String mainDish, String additive,
            String sideDish, LocalDateTime orederDateTime) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.customerId = customerId;
        this.mainDish = mainDish;
        this.additive = additive;
        this.sideDish = sideDish;
        this.orederDateTime = orederDateTime;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getMainDish() {
        return mainDish;
    }
    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }
    public String getAdditive() {
        return additive;
    }
    public void setAdditive(String additive) {
        this.additive = additive;
    }
    public String getSideDish() {
        return sideDish;
    }
    public void setSideDish(String sideDish) {
        this.sideDish = sideDish;
    }
    public LocalDateTime getOrederDateTime() {
        return orederDateTime;
    }
    public void setOrederDateTime(LocalDateTime orederDateTime) {
        this.orederDateTime = orederDateTime;
    }   
}
