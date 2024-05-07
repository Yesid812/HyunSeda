package co.hyunseda.product.domain.service;

import co.hyunseda.product.domain.entity.Category;
import java.util.List;

// Interfaz que define los métodos que debe implementar el servicio de categoría
public interface ICategoryService {

    // Método para guardar una nueva categoría
    boolean save(Category newCategory);

    // Método para encontrar una categoría por su ID
    Category findById(Long id);

    // Método para encontrar una categoría por su nombre
    Category findByName(String name);

    // Método para eliminar una categoría por su ID
    boolean delete(Long id);

    // Método para editar una categoría existente
    boolean edit(Long id, Category category);

    // Método para obtener todas las categorías
    List<Category> findAll();
}
