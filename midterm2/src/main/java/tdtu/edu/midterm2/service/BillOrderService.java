package tdtu.edu.midterm2.service;

import tdtu.edu.midterm2.model.BillOrder;
import tdtu.edu.midterm2.model.Category;

import java.util.List;
import java.util.Optional;

public interface BillOrderService {
    List<BillOrder> getAllBill();
    BillOrder addBill(BillOrder billOrder);
    void removeBillById(long id);
    Optional<BillOrder> getBillById(long id);
}
