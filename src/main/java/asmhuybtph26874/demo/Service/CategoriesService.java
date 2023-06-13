package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.Category;
import asmhuybtph26874.demo.Model.Product;
import asmhuybtph26874.demo.Repository.ICategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriesService implements ICategories{
    @Autowired
    private ICategoriesRepository categoriesRepository;
    @Override
    public List<Category> getList() {
        return categoriesRepository.findAll();
    }
    @Override
    public Category findById(Integer id) {
        return categoriesRepository.findById(id).orElse(null);
    }
}
