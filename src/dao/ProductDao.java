package dao;

import model.Product;
import model.Response;
import model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ProductDao {
    void save(Product product);
    void update(Product product);
    void delete(Product product);
    Product get(String productName);
    List<Product> getAllProductz();
    Set<String> getAllProductCategories();
    List<Product> getByCategoryName(String categoryName);
    List<Product> getByProductSubstring(String productName);
    List<Product> filterProductsByPrice(BigDecimal min, BigDecimal max);
}
