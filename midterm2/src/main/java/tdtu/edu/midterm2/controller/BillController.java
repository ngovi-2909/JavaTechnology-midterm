package tdtu.edu.midterm2.controller;

import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tdtu.edu.midterm2.model.BillOrder;
import tdtu.edu.midterm2.model.ProductCart;
import tdtu.edu.midterm2.service.BillOrderServiceImpl;
import tdtu.edu.midterm2.service.CustomerServiceImpl;
import tdtu.edu.midterm2.service.ProductCartServiceImpl;

import java.util.List;

@Controller
public class BillController {
    @Autowired
    BillOrderServiceImpl billOrderService;

    @GetMapping("/admin/bill/list")
    public String listOfBill(Model model){
        model.addAttribute("billorders", billOrderService.getAllBill());
        return "listbill";
    }
    @GetMapping("/admin/bill/delete/{id}")
    public String deleteBill(@PathVariable int id){
        billOrderService.removeBillById(id);
        return "redirect:/admin/bill/list";
    }


}
