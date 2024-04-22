package co.hyunseda.product.access;

import co.hyunseda.product.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
