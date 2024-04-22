package co.hyunseda.product.domain.service;

import co.hyunseda.product.domain.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    boolean edit(Long Id, Product newProduct);
    boolean delete(Long id);
    Product findById(Long id);
    Product findByName(String name);
    List<Product> searchProductByName(String name);
}
