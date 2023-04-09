package tdtu.edu.midterm2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.midterm2.model.Category;
import tdtu.edu.midterm2.model.Product;
import tdtu.edu.midterm2.model.ProductCart;
import tdtu.edu.midterm2.repository.ProductCartRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Service
public class ProductCartServiceImpl implements ProductCartService{
    @Autowired
    ProductCartRepository productCartRepository;

    @Override
    public List<ProductCart> getAllProductCart() {
        return productCartRepository.findAll();
    }

    @Override
    public ProductCart addProductCart(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

    @Override
    public void removeProductCartById(long id) {
        productCartRepository.deleteById(id);
    }

    @Override
    public Optional<ProductCart> getProductCartById(long id) {
        return productCartRepository.findById(id);
    }

    @Override
    public void removeAllProductCart() {
        productCartRepository.deleteAll();
    }
}
