package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.Category;
import asmhuybtph26874.demo.Repository.ICategoriesRepository;

import java.util.List;

public interface ICategories {
    List<Category> getList();
    Category findById(Integer id);
}
