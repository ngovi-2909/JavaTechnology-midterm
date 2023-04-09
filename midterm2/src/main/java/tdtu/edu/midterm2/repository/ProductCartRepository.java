package tdtu.edu.midterm2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.midterm2.model.ProductCart;

public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
}
