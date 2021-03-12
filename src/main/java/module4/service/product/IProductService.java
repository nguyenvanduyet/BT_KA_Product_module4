package module4.service.product;

import module4.model.Category;
import module4.model.Product;
import module4.service.IGenericService;

import java.util.List;

public interface IProductService extends IGenericService<Product> {
   List<Product> findTop5NewProduct();


   List<Product> findAllByCategory(Category category);

}
