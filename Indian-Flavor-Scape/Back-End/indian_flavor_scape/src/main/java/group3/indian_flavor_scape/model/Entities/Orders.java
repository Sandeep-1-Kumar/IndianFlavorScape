package group3.indian_flavor_scape.model.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "main")
    private Main main;

    @ManyToOne
    @JoinColumn(name = "additives")
    private Additives additives;

    @ManyToOne
    @JoinColumn(name = "sides")
    private Sides side;

    @Column(name = "orderTime")
    private LocalDateTime orderTime;

    @Column(name = "orderstatus")
    private String orderstatus;

    // Default constructor, getters, and setters

    public Orders() {
    }

    
    public Orders(Customer customer, Main main, Additives additives, Sides side, String orderStatus) {
        this.customer = customer;
        this.main = main;
        this.additives = additives;
        this.side = side;
        this.orderstatus = orderStatus;
    }

    // Getters and Setters

    public Long getOrderId() {
        return id;
    }

    public void setOrderId(Long orderId) {
        this.id = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Additives getAdditives() {
        return additives;
    }

    public void setAdditives(Additives additives) {
        this.additives = additives;
    }

    public Sides getSide() {
        return side;
    }

    public void setSide(Sides side) {
        this.side = side;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime() {
        LocalDateTime orderTime = LocalDateTime.now();
        this.orderTime = orderTime;
    }


    public String getOrderStatus() {
        return orderstatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderstatus = orderStatus;
    }
}
