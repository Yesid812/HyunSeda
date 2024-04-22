package co.hyunseda.product.Presentation.rest;


import co.hyunseda.product.domain.service.IProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@Api(value="Microservicios de productos", description="Crud de productos")

public class ProductController {

    @Autowired
    private IProductService productService;


}
