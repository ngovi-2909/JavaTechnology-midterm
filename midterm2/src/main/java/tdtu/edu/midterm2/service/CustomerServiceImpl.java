package tdtu.edu.midterm2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.midterm2.model.Category;
import tdtu.edu.midterm2.model.Customer;
import tdtu.edu.midterm2.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void removeCustomerById(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getCusomerById(long id) {
        return customerRepository.findById(id);
    }
}
