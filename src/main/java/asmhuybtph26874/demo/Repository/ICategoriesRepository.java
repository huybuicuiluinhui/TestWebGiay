package asmhuybtph26874.demo.Repository;

import asmhuybtph26874.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriesRepository extends JpaRepository<Category, Integer> {
}
