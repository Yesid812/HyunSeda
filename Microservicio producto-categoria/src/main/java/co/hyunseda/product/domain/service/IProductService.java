package co.hyunseda.product.domain.service;

import co.hyunseda.product.domain.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marca esta interfaz como un componente de servicio de Spring
public interface IProductService {

    // Método para guardar un nuevo producto en la base de datos
    boolean save(Product product);

    // Método para obtener todos los productos de la base de datos
    List<Product> findAll();

    // Método para editar un producto existente en la base de datos
    boolean edit(Long Id, Product newProduct);

    // Método para eliminar un producto de la base de datos por su ID
    boolean delete(Long id);

    // Método para buscar un producto por su ID en la base de datos
    Product findById(Long id);

    // Método para buscar un producto por su nombre en la base de datos
    Optional<Product> findByName(String name);

    // Método para buscar productos cuyo nombre contenga una cadena dada en la base de datos
    List<Product> searchProductByName(String name);
}
