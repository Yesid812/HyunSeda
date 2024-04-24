package co.hyunseda.product.Presentation.rest;

import co.hyunseda.product.domain.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")

public class CategoryController {

    @Autowired
    ICategoryService categoryService;
    @GetMapping()
    public String index(){return "Conectado";};
}
