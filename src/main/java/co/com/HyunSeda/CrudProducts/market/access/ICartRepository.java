package co.com.HyunSeda.CrudProducts.market.access;

public interface ICartRepository {
    boolean save(Product newProduct);

    List<Product> findAll();
    boolean edit(Long Id, Product newProduct);
    boolean delete(Long id);
    Product findById(Long id);
    Product findByName(String name);
    List<Product> searchProductByName(String name);
}
