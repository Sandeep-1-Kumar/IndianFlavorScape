package group3.indian_flavor_scape;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import group3.indian_flavor_scape.controller.AuthController;
import group3.indian_flavor_scape.model.Entities.Customer;
import group3.indian_flavor_scape.model.Entities.Employ;
import group3.indian_flavor_scape.model.Requests.SignInRequestJson;
import group3.indian_flavor_scape.model.Requests.SignUpRequestJson;
import group3.indian_flavor_scape.model.Responses.AuthorizationResponseJson;
import group3.indian_flavor_scape.repositories.CustomerRepository;
import group3.indian_flavor_scape.repositories.EmployRepository;

public class AuthControllerTests {

    private AuthController authController;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private EmployRepository employRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authController = new AuthController();
        authController.setCustomerRepository(customerRepository);
        authController.setEmployRepository(employRepository);
    }

    @Test
    void testSignInCustomer_ValidCredentials() {
        String email = "bhanu@gmail.com";
        String password = "password";
        SignInRequestJson signInRequestJson = new SignInRequestJson(email, password);
        Customer customer = new Customer(email, "bhanu", password);
        when(customerRepository.findByEmail(email)).thenReturn(customer);
        AuthorizationResponseJson response = authController.signInCustomer(signInRequestJson);
        assertEquals(AuthController.SIGN_IN_SUCCESS_CODE, response.getStatusCode());
        assertEquals(AuthController.SIGN_IN_SUCCESS_DESCRIPTION, response.getStatusMessage());
        assertEquals(email.toLowerCase(), response.getEmail());
    }

    @Test
    void testSignInCustomer_InvalidCredentials() {
        String email = "bhanu@gmail.com";
        String password = "password";
        SignInRequestJson signInRequestJson = new SignInRequestJson(email, password);
        when(customerRepository.findByEmail(email)).thenReturn(null);
        AuthorizationResponseJson response = authController.signInCustomer(signInRequestJson);
        assertEquals(AuthController.SIGN_IN_FAILURE_CODE, response.getStatusCode());
        assertEquals(AuthController.SIGN_IN_FAILURE_DESCRIPTION, response.getStatusMessage());
    }

    @Test
    void testSignUpCustomer_Success() {
        String email = "bhanu@gmail.com";
        String name = "Bhanu";
        String password = "password";
        SignUpRequestJson signUpRequestJson = new SignUpRequestJson(email, password, name);
        when(customerRepository.findByEmail(email)).thenReturn(null);
        AuthorizationResponseJson response = authController.signUpCustomer(signUpRequestJson);
        assertEquals(AuthController.SIGN_UP_SUCCESS_CODE, response.getStatusCode());
        assertEquals(AuthController.SIGN_UP_SUCCESS_DESCRIPTION, response.getStatusMessage());
        assertEquals(email, response.getEmail());
        assertEquals(name, response.getName());
    }

    @Test
    void testSignUpCustomer_Failure() {
        String email = "bhanu@gmail.com";
        String name = "Bhanu";
        String password = "password";
        SignUpRequestJson signUpRequestJson = new SignUpRequestJson(email, password, name);
        Customer existingCustomer = new Customer(email, name, password);
        when(customerRepository.findByEmail(email)).thenReturn(existingCustomer);
        AuthorizationResponseJson response = authController.signUpCustomer(signUpRequestJson);
        assertEquals(AuthController.SIGN_UP_FAILURE_CODE, response.getStatusCode());
        assertEquals(AuthController.SIGN_UP_FAILURE_DESCRIPTION, response.getStatusMessage());
    }

    @Test
    void testSignInEmploy_ValidCredentials() {
        String email = "test@example.com";
        String password = "password";
        SignInRequestJson signInRequestJson = new SignInRequestJson(email, password);
        Employ employ = new Employ( "John Doe",email, password);
        when(employRepository.findByEmail(email)).thenReturn(employ);
        AuthorizationResponseJson response = authController.signInEmploy(signInRequestJson);
		assertEquals(AuthController.SIGN_IN_SUCCESS_CODE, response.getStatusCode());
        assertEquals(AuthController.EMPLOY_SIGN_IN_SUCCESS_DESCRIPTION, response.getStatusMessage());
        assertEquals(email.toLowerCase(), response.getEmail());
        assertEquals(employ.getName(), response.getName());
    }

    @Test
    void testSignInEmploy_InvalidCredentials() {
        String email = "test@example.com";
        String password = "password";
        SignInRequestJson signInRequestJson = new SignInRequestJson(email, password);
        when(employRepository.findByEmail(email)).thenReturn(null);
        AuthorizationResponseJson response = authController.signInEmploy(signInRequestJson);
        assertEquals(AuthController.SIGN_IN_FAILURE_CODE, response.getStatusCode());
        assertEquals(AuthController.SIGN_IN_FAILURE_DESCRIPTION, response.getStatusMessage());
    }
}
