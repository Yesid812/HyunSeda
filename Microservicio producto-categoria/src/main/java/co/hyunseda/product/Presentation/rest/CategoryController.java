package co.hyunseda.product.Presentation.rest;

import co.hyunseda.product.domain.entity.Category;
import co.hyunseda.product.domain.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Endpoint para crear una nueva categoría
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        boolean created = categoryService.save(category);
        if (created) {
            return new ResponseEntity<>(category, HttpStatus.CREATED); // Devuelve 201 CREATED si la categoría se crea con éxito
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Devuelve 400 BAD_REQUEST si la categoría no se puede crear
        }
    }

    // Endpoint para obtener una categoría por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK); // Devuelve 200 OK si se encuentra la categoría
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve 404 NOT_FOUND si no se encuentra la categoría
        }
    }

    // Endpoint para obtener una categoría por su nombre
    @GetMapping("/name/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {
        Category category = categoryService.findByName(name);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK); // Devuelve 200 OK si se encuentra la categoría
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve 404 NOT_FOUND si no se encuentra la categoría
        }
    }

    // Endpoint para actualizar una categoría por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        boolean updated = categoryService.edit(id, category);
        if (updated) {
            return new ResponseEntity<>(category, HttpStatus.OK); // Devuelve 200 OK si la categoría se actualiza con éxito
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve 404 NOT_FOUND si no se puede actualizar la categoría
        }
    }

    // Endpoint para eliminar una categoría por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Devuelve 204 NO_CONTENT si la categoría se elimina con éxito
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve 404 NOT_FOUND si no se puede eliminar la categoría
        }
    }

    // Endpoint para obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        if (categories != null && !categories.isEmpty()) {
            return new ResponseEntity<>(categories, HttpStatus.OK); // Devuelve 200 OK si se encuentran categorías
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve 404 NOT_FOUND si no se encuentran categorías
        }
    }
}
