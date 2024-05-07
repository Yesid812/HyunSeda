package co.hyunseda.product.domain.service;

import co.hyunseda.product.access.IProductRepository;
import co.hyunseda.product.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marca esta clase como un componente de servicio de Spring
public class ProductService implements IProductService {

    private final IProductRepository productRepository; // Repositorio para acceder a las operaciones de base de datos relacionadas con Product

    @Autowired // Inyección de dependencias para el repositorio Product
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override // Sobrescribe el método de la interfaz para guardar un nuevo producto
    public boolean save(Product product) {
        try {
            productRepository.save(product); // Guarda el nuevo producto en la base de datos
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el rastro de la excepción si ocurre un error
            return false;
        }
    }

    @Override // Sobrescribe el método de la interfaz para obtener todos los productos
    public List<Product> findAll() {
        return productRepository.findAll(); // Obtiene todos los productos de la base de datos
    }

    @Override // Sobrescribe el método de la interfaz para editar un producto existente
    public boolean edit(Long Id, Product newProduct) {
        Optional<Product> optionalProduct = productRepository.findById(Id); // Busca el producto por su ID en la base de datos
        if (optionalProduct.isPresent()) { // Verifica si el producto existe
            Product existingProduct = optionalProduct.get(); // Obtiene el producto existente
            // Actualiza los campos del producto existente con los valores del nuevo producto
            existingProduct.setName(newProduct.getName());
            existingProduct.setDescription(newProduct.getDescription());
            existingProduct.setCantidad(newProduct.getCantidad());
            existingProduct.setPrice(newProduct.getPrice());
            existingProduct.setCategory(newProduct.getCategory());
            productRepository.save(existingProduct); // Guarda el producto actualizado en la base de datos
            return true;
        }
        return false;
    }

    @Override // Sobrescribe el método de la interfaz para eliminar un producto por su ID
    public boolean delete(Long id) {
        if (productRepository.existsById(id)) { // Verifica si el producto existe por su ID
            productRepository.deleteById(id); // Elimina el producto de la base de datos por su ID
            return true;
        }
        return false;
    }

    @Override // Sobrescribe el método de la interfaz para buscar un producto por su ID
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null); // Busca el producto por su ID y lo retorna, si no se encuentra, retorna null
    }

    @Override // Sobrescribe el método de la interfaz para buscar un producto por su nombre
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name); // Busca el producto por su nombre y lo retorna
    }

    @Override // Sobrescribe el método de la interfaz para buscar productos cuyo nombre contenga una cadena dada
    public List<Product> searchProductByName(String name) {
        return productRepository.searchProductByName(name); // Busca productos cuyo nombre contenga una cadena dada y los retorna
    }
}
