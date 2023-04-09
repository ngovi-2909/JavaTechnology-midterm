package tdtu.edu.midterm2.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.midterm2.dto.ProductDTO;
import tdtu.edu.midterm2.model.Product;
import tdtu.edu.midterm2.repository.ProductRepository;
import tdtu.edu.midterm2.service.CategoryServiceImpl;
import tdtu.edu.midterm2.service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    CategoryServiceImpl categoryService;
    @GetMapping("/")
    public String showProduct(Model model){
        model.addAttribute("products",productService.getAllproduct());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("colors", getColorList());
        model.addAttribute("brands", getBrandList());
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/admin")
    public String adminhome(){
        return "adminpage";
    }

    @RequestMapping(value = "/home/filter", method = RequestMethod.POST)
    public String filterProduct(@RequestParam("customRadio")String radioCheckedValues,
                                @RequestParam("productcolor")String colorValues,
                                @RequestParam("min")String minPrice,
                                @RequestParam("max")String maxPrice,
                                Model model)throws Exception{
        List<Product> listOfProduct = productService.getAllproduct();
        List<Product> products = new ArrayList<>();
        if(!radioCheckedValues.equals(""))
        {
            if(!radioCheckedValues.equals("all"))
            {
                for(Product product: listOfProduct){
                    if(product.getBrand().toLowerCase().equals(radioCheckedValues.toLowerCase())){
                        products.add(product);
                    }
                }
            }else {
                for(Product product: listOfProduct){
                    products.add(product);
                }
            }

        }

        if(!colorValues.equals(""))
        {
            if(!colorValues.equals("all"))
            {
                for(Product product: listOfProduct){
                    if(!product.getColor().toLowerCase().equals(colorValues.toLowerCase())){
                        products.remove(product);
                    }
                }
            }
        }
        if(!minPrice.equals("") && !maxPrice.equals("")){
            Double min = Double.parseDouble(minPrice);
            Double max = Double.parseDouble(maxPrice);
            for(Product product: listOfProduct){
                if(product.getPrice() < min || product.getPrice() > max){
                    products.remove(product);
                }
            }
        }
        model.addAttribute("products", products);
        model.addAttribute("colors", getColorList());
        model.addAttribute("brands", getBrandList());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "index";
    }
    private List<String> getColorList()
    {
        List<String> color = new ArrayList<>();
        for(Product product: productService.getAllproduct()){
            if(!color.contains(product.getColor()))
            {
                color.add(product.getColor());
            }
        }
        return color;
    }
    private List<String> getBrandList()
    {
        List<String> brand = new ArrayList<>();
        for(Product product: productService.getAllproduct()){
            if(!brand.contains(product.getBrand()))
            {
                brand.add(product.getBrand());
            }
        }
        return brand;
    }
    @GetMapping("/home/product/detail/{id}")
    public String productDetail(@PathVariable long id, Model model){
        Product product = productService.getProductById(id).get();
        model.addAttribute(product);
        return "productdetail";
    }
    @RequestMapping(value = "/home/search", method = RequestMethod.POST)
    public String searchProduct(@RequestParam("nameofproduct")String nameproduct, Model model){

        System.out.println(nameproduct);
        List<Product> products = (List<Product>) productService.searchProductByName(String.valueOf(nameproduct));
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", products);
        model.addAttribute("colors", getColorList());
        model.addAttribute("brands", getBrandList());
        return "index";
    }

}
