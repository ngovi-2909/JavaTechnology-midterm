package tdtu.edu.midterm2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.midterm2.model.BillOrder;
import tdtu.edu.midterm2.repository.BillOrderRepository;

import java.util.List;
import java.util.Optional;
@Service
public class BillOrderServiceImpl implements BillOrderService{
    @Autowired
    BillOrderRepository billOrderRepository;
    @Override
    public List<BillOrder> getAllBill() {
        return billOrderRepository.findAll();
    }

    @Override
    public BillOrder addBill(BillOrder billOrder) {
        return billOrderRepository.save(billOrder);
    }

    @Override
    public void removeBillById(long id) {
        billOrderRepository.deleteById(id);
    }

    @Override
    public Optional<BillOrder> getBillById(long id) {
        return billOrderRepository.findById(id);
    }
}
