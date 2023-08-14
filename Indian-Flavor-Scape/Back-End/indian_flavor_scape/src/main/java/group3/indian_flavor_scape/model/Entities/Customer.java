package group3.indian_flavor_scape.model.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customerid;

  private String email;
  private String password;
  private String name;
  public Customer() {
  }
  
  public Customer(String email, String name, String password) {
    this.email = email;
    this.name = name;
    this.password = password;
  }
  
  public Long getCustomerId() {
    return customerid;
  }
  
  public void setCustomerId(Long customerId) {
    this.customerid = customerId;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
}
