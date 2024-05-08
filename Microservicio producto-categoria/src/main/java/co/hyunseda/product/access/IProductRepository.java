package co.hyunseda.product.access;

import co.hyunseda.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Marca esta interfaz como un componente de repositorio de Spring
public interface IProductRepository extends JpaRepository<Product, Long> {
    // Extiende JpaRepository para tener acceso a operaciones CRUD en la entidad Product con ID de tipo Long

    Optional<Product> findByName(String name); // Método para buscar un producto por su nombre

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%") // Consulta personalizada para buscar productos por nombre que contenga una cadena dada
    List<Product> searchProductByName(String name); // Método para buscar productos por nombre que contenga una cadena dada
}
