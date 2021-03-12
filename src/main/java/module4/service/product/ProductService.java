package module4.service.product;


import module4.model.Category;
import module4.model.Product;
import module4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products;
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);

    }

    @Override
    public Product findId(int id) {
        return productRepository.findOne(id);
    }


    @Override
    public List<Product> findTop5NewProduct() {
        return productRepository.findTop5ByOrderByDatetimeDesc();
    }


    @Override
    public List<Product> findAllByCategory(Category category) {
        return productRepository.findAllByCategory(category);
    }
}
