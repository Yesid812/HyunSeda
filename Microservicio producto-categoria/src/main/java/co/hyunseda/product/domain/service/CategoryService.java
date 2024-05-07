package co.hyunseda.product.domain.service;

import co.hyunseda.product.access.ICategoryRepository;
import co.hyunseda.product.domain.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marca esta clase como un componente de servicio de Spring
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository; // Repositorio para acceder a las operaciones de base de datos relacionadas con Category

    @Autowired // Inyección de dependencias para el repositorio Category
    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override // Sobrescribe el método de la interfaz para guardar una nueva categoría
    public boolean save(Category newCategory) {
        try {
            categoryRepository.save(newCategory); // Guarda la nueva categoría en la base de datos
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el rastro de la excepción si ocurre un error
            return false;
        }
    }

    @Override // Sobrescribe el método de la interfaz para buscar una categoría por su ID
    public Category findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id); // Busca la categoría por su ID en la base de datos
        return categoryOptional.orElse(null); // Retorna la categoría encontrada o null si no se encuentra
    }

    @Override // Sobrescribe el método de la interfaz para buscar una categoría por su nombre
    public Category findByName(String name) {
        return categoryRepository.findByName(name); // Busca la categoría por su nombre en la base de datos
    }

    @Override // Sobrescribe el método de la interfaz para eliminar una categoría por su ID
    public boolean delete(Long id) {
        try {
            categoryRepository.deleteById(id); // Elimina la categoría de la base de datos por su ID
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el rastro de la excepción si ocurre un error
            return false;
        }
    }

    @Override // Sobrescribe el método de la interfaz para editar una categoría existente
    public boolean edit(Long id, Category updatedCategory) {
        try {
            Optional<Category> categoryOptional = categoryRepository.findById(id); // Busca la categoría por su ID en la base de datos
            if (categoryOptional.isPresent()) { // Verifica si la categoría existe
                updatedCategory.setCategoryId(id); // Establece el ID de la categoría actualizada
                categoryRepository.save(updatedCategory); // Guarda la categoría actualizada en la base de datos
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el rastro de la excepción si ocurre un error
            return false;
        }
    }

    @Override // Sobrescribe el método de la interfaz para obtener todas las categorías
    public List<Category> findAll() {
        return categoryRepository.findAll(); // Obtiene todas las categorías de la base de datos
    }
}
