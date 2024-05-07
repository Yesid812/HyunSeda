package co.HyunSeda.protduct.HyunSeda.Product;

import co.hyunseda.product.access.IProductRepository;
import co.hyunseda.product.domain.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest // Indica que esta clase de prueba es para probar componentes de acceso a datos usando JPA
public class ProductRepositoryMockTest {
    @Autowired // Inyección de dependencias de la interfaz de servicio de productos
    private IProductService productService;
}
