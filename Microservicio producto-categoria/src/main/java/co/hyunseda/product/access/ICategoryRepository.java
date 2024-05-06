package co.hyunseda.product.access;

import co.hyunseda.product.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // Marca esta interfaz como un componente de repositorio de Spring
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    // Extiende JpaRepository para tener acceso a operaciones CRUD en la entidad Category con ID de tipo Long

    @Query("SELECT c FROM Category c WHERE c.name = :name") // Consulta personalizada para buscar una categoría por nombre
    Category findByName(String name); // Método para buscar una categoría por nombre
}
