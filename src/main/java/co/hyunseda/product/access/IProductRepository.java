package co.hyunseda.product.access;

import co.hyunseda.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

}
