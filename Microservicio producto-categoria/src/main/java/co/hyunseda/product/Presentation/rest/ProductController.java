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

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("products") // Mapea todas las solicitudes bajo /products a este controlador
@Api(value="Microservicios de productos", description="Crud de productos") // Anotación Swagger para documentación de API
public class ProductController {

    @Autowired
    private IProductService productService; // Inyección de dependencias del servicio de productos

    // Endpoint para obtener todos los productos
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Product> findAll() {
        return productService.findAll();
    }

    // Endpoint para crear un nuevo producto
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean create(@RequestBody Product product) {
        return productService.save(product);
    }

    // Endpoint para obtener un producto por su ID
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @ApiOperation(value="Busca un producto por id") // Descripción de la operación para Swagger
    public Product findById(@ApiParam(value="Identificador del producto") @PathVariable Long id)  {
        Product product = productService.findById(id);
        return product;
    }

    // Endpoint para editar un producto existente
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public boolean edit(@RequestBody Product product, @PathVariable Long id){
        return productService.edit(id, product);
    }

    // Endpoint para eliminar un producto por su ID
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT) // Indica el código de estado HTTP a devolver
    public boolean delete(@PathVariable Long id)  {
        return productService.delete(id);
    }
}
