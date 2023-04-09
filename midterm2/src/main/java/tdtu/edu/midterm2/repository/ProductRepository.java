package tdtu.edu.midterm2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tdtu.edu.midterm2.model.Product;

import java.util.Collection;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT s FROM Product s WHERE s.name like %:key%")
    public Collection<Product> searchByName(@Param("key") String key);

}
