package module4.repository;


import module4.model.Category;
import module4.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findTop5ByOrderByDatetimeDesc();

    List<Product> findAllByCategory(Category category);
}
