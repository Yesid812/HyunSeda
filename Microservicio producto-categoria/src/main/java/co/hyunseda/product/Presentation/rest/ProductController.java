package co.hyunseda.product.Presentation.rest;


import co.hyunseda.product.domain.entity.Product;
import co.hyunseda.product.domain.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@Api(value="Microservicios de productos", description="Crud de productos")

public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean create(@RequestBody Product product) {
        return productService.save(product);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @ApiOperation(value="Busca un producto por id")
    public Product findById(@ApiParam(value="Identificador del producto") @PathVariable Long id)  {

        Product product = productService.findById(id);
        return product;
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public boolean edit(@RequestBody Product product, @PathVariable Long id){
        return productService.edit(id, product);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Long id)  {
        return productService.delete(id);
    }
}
