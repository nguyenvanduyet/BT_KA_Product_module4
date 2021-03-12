//package module4.formatter;
//
//import javassist.NotFoundException;
//import module4.model.Category;
//import module4.service.category.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.format.Formatter;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.util.Locale;
//
//@Component
//public class CategoryFormatter implements Formatter<Category> {
//    private ICategoryService iCategoryService;
//    @Autowired
//    public CategoryFormatter(ICategoryService categoryService){
//        this.iCategoryService=categoryService;
//    }
//    @Override
//    public Category parse(String text, Locale locale) throws ParseException {
//        Category category = new Category();
//        try {
//            category = iCategoryService.findId(Integer.parseInt(text));
//        } catch (NotFoundException notFoundException) {
//            notFoundException.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public String print(Category object, Locale locale) {
//        return null;
//    }
//}
