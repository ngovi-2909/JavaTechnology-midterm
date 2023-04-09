package tdtu.edu.midterm2.service;

import tdtu.edu.midterm2.model.Category;
import tdtu.edu.midterm2.model.ProductCart;

import java.util.List;
import java.util.Optional;

public interface ProductCartService {
    List<ProductCart> getAllProductCart();
    ProductCart addProductCart(ProductCart productCart);
    void removeProductCartById(long id);
    Optional<ProductCart> getProductCartById(long id);
    void removeAllProductCart();
}
