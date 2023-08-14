package group3.indian_flavor_scape.model;

import group3.indian_flavor_scape.model.Entities.Customer;
import group3.indian_flavor_scape.model.Entities.Employ;
import group3.indian_flavor_scape.model.Requests.SignInRequestJson;
//This class deal with the Authentication logic
public class Authenticator {
    //This method validates customer  details
    public boolean customerDetailsValidator
    (SignInRequestJson signInRequestJson, Customer customer){
        boolean flag = false;
        if(signInRequestJson.getEmail().toLowerCase().
        equals(customer.getEmail().toLowerCase()) &&
         signInRequestJson.getPassword().equals(customer.getPassword())){
            flag = true;
        }
        return flag;
    }
    //This method validates employee details
    public boolean employeeDetailsValidator
    (SignInRequestJson signInRequestJson, Employ employ){
        boolean flag = false;
        if(signInRequestJson.getEmail().toLowerCase().equals(employ.getEmail().toLowerCase()) &&
         signInRequestJson.getPassword().equals(employ.getPassword())){
            flag = true;
        }
        return flag;
    }
}
