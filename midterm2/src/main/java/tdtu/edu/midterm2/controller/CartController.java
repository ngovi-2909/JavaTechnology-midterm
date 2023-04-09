package tdtu.edu.midterm2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.midterm2.model.BillOrder;
import tdtu.edu.midterm2.model.Customer;
import tdtu.edu.midterm2.model.ProductCart;
import tdtu.edu.midterm2.model.Product;
import tdtu.edu.midterm2.service.*;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    ProductCartServiceImpl productCartService;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    BillOrderServiceImpl billOrderService;
    @GetMapping("/home/cart")
    public String shoppingCart(Model model){
        List<ProductCart> productCartList = productCartService.getAllProductCart();
        model.addAttribute("total", getTotalPrice());
        model.addAttribute("cart", productCartList);
        return "shoppingcart";
    }

    private double getTotalPrice() {
        List<ProductCart> productCartList = productCartService.getAllProductCart();
        double total = 0;
        for(ProductCart productCart: productCartList){
            total += productCart.getSubtotal();
        }
        return total;
    }

    @RequestMapping(value = "/home/cart/add/{id}", method = RequestMethod.POST)
    public String addProductToCart(@PathVariable long id, @RequestParam("quantity")int quantity){
        ProductCart productCart = new ProductCart();
        Product product = productService.getProductById(id).get();
        double subtotal = product.getPrice()* quantity;
        productCart.setId(product.getId());
        productCart.setName(product.getName());
        productCart.setBrand(product.getBrand());
        productCart.setImageName(product.getImage());
        productCart.setColor(product.getColor());
        productCart.setPrice(product.getPrice());
        productCart.setQuantity(quantity);
        productCart.setSubtotal(subtotal);
        productCartService.addProductCart(productCart);
        return "redirect:/";
    }
    @GetMapping("/home/cart/remove/{id}")
    public String removeItem(@PathVariable int id){
        productCartService.removeProductCartById(id);
        return "redirect:/home/cart";
    }
    @GetMapping("/home/cart/checkout")
    public String checkoutProduct(Model model){
        if(productCartService.getAllProductCart().isEmpty()){
            return "redirect:/home/cart";
        }
        model.addAttribute("customer", new Customer());
        return "checkoutproduct";
    }
    @RequestMapping(value = "/home/cart/checkout/thanks", method = RequestMethod.POST)
    public String addProductCart(@ModelAttribute("customer")Customer customer){
        BillOrder billOrder = new BillOrder();
        billOrder.setName(getAllNameProduct());
        billOrder.setTotal(getTotalPrice());
        billOrder.setCustomerName(customer.getName());
        billOrder.setAddress(customer.getAddress());
        billOrder.setAge(customer.getAge());
        billOrder.setPhone(customer.getPhone());
        billOrderService.addBill(billOrder);
        customerService.addCustomer(customer);
        return "thankyoupage";
    }

    private String getAllNameProduct() {
        List<ProductCart> productCartList = productCartService.getAllProductCart();
        String nameProduct="";
        for(ProductCart productCart: productCartList){
            nameProduct += productCart.getName() + " " + productCart.getColor()+ "( " + productCart.getQuantity() +" ) ";
        }
        return nameProduct;
    }

}
