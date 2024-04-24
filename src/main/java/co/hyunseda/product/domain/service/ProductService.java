package co.hyunseda.product.domain.service;

import co.hyunseda.product.access.IProductRepository;
import co.hyunseda.product.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean edit(Long Id, Product newProduct) {
        Optional<Product> optionalProduct = productRepository.findById(Id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(newProduct.getName());
            existingProduct.setDescription(newProduct.getDescription());
            existingProduct.setCantidad(newProduct.getCantidad());
            existingProduct.setPrice(newProduct.getPrice());
            existingProduct.setCategory(newProduct.getCategory());
            productRepository.save(existingProduct);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Product> findByName(String name) {
            return productRepository.findByName(name);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return productRepository.searchProductByName(name);
    }
}
