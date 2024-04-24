package co.hyunseda.product.domain.service;

import co.hyunseda.product.access.ICategoryRepository;
import co.hyunseda.product.domain.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Autowired
    public CategoryService (ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public boolean save(Category newCategory) {
        return false;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public Category findByName(String name) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean edit(Long Id, Category category) {
        return false;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }
}
