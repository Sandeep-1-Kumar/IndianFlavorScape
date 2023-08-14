package group3.indian_flavor_scape.model.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//This Entity class represents Employ table in DB
@Entity
public class Employ {
    
    @Id
    private Integer employid;
    
    private String name;
    private String email;
    private String password;
    
    public Employ() {
    }
    
    public Employ(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public Integer getEmployId() {
        return employid;
    }
    
    public void setEmployId(Integer employId) {
        this.employid = employId;
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
