package group3.indian_flavor_scape.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import group3.indian_flavor_scape.model.Authenticator;
import group3.indian_flavor_scape.model.Entities.Customer;
import group3.indian_flavor_scape.model.Entities.Employ;
import group3.indian_flavor_scape.model.Requests.SignInRequestJson;
import group3.indian_flavor_scape.model.Requests.SignUpRequestJson;
import group3.indian_flavor_scape.model.Responses.AuthorizationResponseJson;
import group3.indian_flavor_scape.repositories.CustomerRepository;
import group3.indian_flavor_scape.repositories.EmployRepository;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(path="/IndianFlavorScape")

public class AuthController
{
    //Defining all response attributes
    private AuthorizationResponseJson authorizationResponseJson;
    public static final String SIGN_IN_SUCCESS_CODE = "10200";
    public static final String SIGN_IN_FAILURE_CODE = "10404";
    public static final String SIGN_UP_SUCCESS_CODE = "10201";
    public static final String SIGN_UP_FAILURE_CODE = "10409";
    public static final String
    SIGN_IN_SUCCESS_DESCRIPTION = "Customer sucessfully validated";
    public static final String
    EMPLOY_SIGN_IN_SUCCESS_DESCRIPTION = "Employ sucessfully validated";
    public static final String
    SIGN_IN_FAILURE_DESCRIPTION = "Please check the login credentials";
    public static final String
    SIGN_UP_SUCCESS_DESCRIPTION = "Customer sucessfully Created";
    public static final String
    SIGN_UP_FAILURE_DESCRIPTION = "Customer already exsists";
    private Map<String, String> responseValuesMap = 
    new HashMap<String, String>(){{
        put(SIGN_IN_SUCCESS_CODE, SIGN_IN_SUCCESS_DESCRIPTION);
        put(SIGN_IN_FAILURE_CODE, SIGN_IN_FAILURE_DESCRIPTION);
        put(SIGN_UP_SUCCESS_CODE, SIGN_UP_SUCCESS_DESCRIPTION);
        put(SIGN_UP_FAILURE_CODE, SIGN_UP_FAILURE_DESCRIPTION);
    }};

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployRepository employRepository;
    //This method takes care of the customer sign in part
    @PostMapping(path="/customer/signIn")
    public @ResponseBody AuthorizationResponseJson signInCustomer
    (@RequestBody SignInRequestJson signInRequestJson){
        try{
            Customer customer;
            customer = customerRepository.findByEmail
            (signInRequestJson.getEmail());
            authorizationResponseJson = new AuthorizationResponseJson
            (SIGN_IN_FAILURE_CODE,
            responseValuesMap.get(SIGN_IN_FAILURE_CODE));
            Authenticator authenticator = new Authenticator();
            // Validating customer details in Authenticator class
            if(customer != null && authenticator.customerDetailsValidator
            (signInRequestJson,customer)){
                authorizationResponseJson = new AuthorizationResponseJson
                (SIGN_IN_SUCCESS_CODE,
                responseValuesMap.get(SIGN_IN_SUCCESS_CODE),
                customer.getEmail().toLowerCase(),
                customer.getName(),
                customer.getCustomerId());
            }
            return authorizationResponseJson;
        }
        catch(Exception e){
            authorizationResponseJson = new AuthorizationResponseJson
            (responseValuesMap.get(SIGN_IN_FAILURE_CODE),
            e.getMessage());
            return authorizationResponseJson;
        }
    }
    //This method takes care of the customer sign up part
    @PostMapping(path = "/customer/signUp")
    public @ResponseBody AuthorizationResponseJson signUpCustomer
    (@RequestBody SignUpRequestJson signUpRequestJson){
        try{
            authorizationResponseJson = new AuthorizationResponseJson
            (SIGN_UP_FAILURE_CODE,
            responseValuesMap.get(SIGN_UP_FAILURE_CODE));
            if(customerRepository.findByEmail
            (signUpRequestJson.getEmail()) == null){
                //Creating a new customer if the user details not available
                customerRepository.save(new Customer
                (signUpRequestJson.getEmail(),
                signUpRequestJson.getName(),
                signUpRequestJson.getPassword()));
                authorizationResponseJson = new AuthorizationResponseJson
                (SIGN_UP_SUCCESS_CODE,
                responseValuesMap.get(SIGN_UP_SUCCESS_CODE),
                signUpRequestJson.getEmail(),
                signUpRequestJson.getName()
                );
            }
            return authorizationResponseJson;
        }
        catch (Exception e ){
            authorizationResponseJson = new AuthorizationResponseJson
            (responseValuesMap.get(SIGN_UP_FAILURE_CODE),
            e.getMessage());
            return authorizationResponseJson;
        }
    }
    //This method takes care of the employee sign in part
    @PostMapping(path="/employ/signIn")
    public @ResponseBody AuthorizationResponseJson signInEmploy
    (@RequestBody SignInRequestJson signInRequestJson){
        try{
            Employ employ;
            employ = employRepository.findByEmail
            (signInRequestJson.getEmail());
            authorizationResponseJson = new AuthorizationResponseJson
            (SIGN_IN_FAILURE_CODE,
            responseValuesMap.get(SIGN_IN_FAILURE_CODE));
            Authenticator authenticator = new Authenticator();
            // Validating employ details in Authenticator class
            if(employ != null && authenticator.employeeDetailsValidator
            (signInRequestJson, employ)){
                authorizationResponseJson = new AuthorizationResponseJson
                (SIGN_IN_SUCCESS_CODE,
                EMPLOY_SIGN_IN_SUCCESS_DESCRIPTION,
                employ.getEmail().toLowerCase(),
                employ.getName());
            }
            return authorizationResponseJson;
        }
        catch(Exception e){
            authorizationResponseJson = new AuthorizationResponseJson
            (responseValuesMap.get(SIGN_IN_FAILURE_CODE),
            e.getMessage());
            return authorizationResponseJson;
        }
    }
    //These below set methods are used in to set repositories in order to mock during test cases 
    public void setCustomerRepository
    (CustomerRepository customerRepository2) {
        this.customerRepository = customerRepository2;
    }

    public void setEmployRepository
    (EmployRepository employRepository2) {
        this.employRepository = employRepository2;
    }
}
