package tdtu.edu.midterm2.service;

import tdtu.edu.midterm2.model.Category;
import tdtu.edu.midterm2.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer addCustomer(Customer customer);
    void removeCustomerById(long id);
    Optional<Customer> getCusomerById(long id);
}
