package tdtu.edu.midterm2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.midterm2.model.BillOrder;

public interface BillOrderRepository extends JpaRepository<BillOrder, Long> {
}
