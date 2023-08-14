package group3.indian_flavor_scape.model.Requests;

public class OrdersRequestJson {
    private Long customerId;
    private String orderStatus;
    private Long orderId;
    private Long mainDishId;
    private Long additiveId;
    private Long sideId;

    public OrdersRequestJson(Long customerId, String orderStatus,
    Long mainDishId, Long additiveId, Long sideId) {
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.mainDishId = mainDishId;
        this.additiveId = additiveId;
        this.sideId = sideId;
    }

    public Long getMainDishId() {
        return mainDishId;
    }

    public void setMainDishId(Long mainDishId) {
        this.mainDishId = mainDishId;
    }

    public Long getAdditiveId() {
        return additiveId;
    }

    public void setAdditiveId(Long additiveId) {
        this.additiveId = additiveId;
    }

    public Long getSideId() {
        return sideId;
    }

    public void setSideId(Long sideId) {
        this.sideId = sideId;
    }

    public OrdersRequestJson(){
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }    
}
