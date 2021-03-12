package module4.controller;

import module4.model.Category;
import module4.model.Product;
import module4.service.category.CategoryService;
import module4.service.category.ICategoryService;
import module4.service.product.IProductService;
import module4.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categorylist")
    public List<Category> categoryList() {
        List<Category> categoryList = categoryService.findAll();
        return categoryList;
    }

    @GetMapping
    public ModelAndView ShowAll() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = productService.findAll();
        modelAndView.addObject("product", products);
        return modelAndView;
    }
    @PostMapping("search")
    public ModelAndView searchProduct(@ModelAttribute Category category){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = productService.findAllByCategory(category);
        modelAndView.addObject("product",products);
        return modelAndView;
    }


    @GetMapping("delete/{id}")
    public ModelAndView remote(@PathVariable int id) {
        productService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product products = productService.findId(id);
        modelAndView.addObject("product", products);
        return modelAndView;
    }

    @PostMapping("edit/{id}")
    public ModelAndView editProduct(@ModelAttribute Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView createProduct(@ModelAttribute Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        return modelAndView;
    }
    @GetMapping("list5ProductNew")
    public ModelAndView showTop5(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = productService.findTop5NewProduct();
        modelAndView.addObject("product",products);
        return modelAndView;
    }

}
