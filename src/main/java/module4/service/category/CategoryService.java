package module4.service.category;

import module4.model.Category;
import module4.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        List<Category> categories= (List<Category>) categoryRepository.findAll();

        return categories;
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Category findId(int id) {
        return null;
    }
}
