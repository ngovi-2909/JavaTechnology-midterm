package tdtu.edu.midterm2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.midterm2.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
