package asmhuybtph26874.demo.Repository;

import asmhuybtph26874.demo.Model.BrandModel;
import asmhuybtph26874.demo.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findByNameProductContains(String nameProduct, Pageable pageable);
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Product> findByNameProductAndAndBrandAndSize(String nameProduct,String brandName, String size);
    List<Product> findByNameProductOrAndBrandOrSizeContains(String nameProduct,String brandName, String size);
    @Query("SELECT o FROM Product o  ORDER BY o.price desc")
    Page<Product> findAllOrderByPriceDesc(Pageable pageable);

//    @Query(value = """
//SELECT new  asmhuybtph26874.demo.Model.BrandModel(p.brand,COUNT(p.brand)) FROM Product p  GROUP BY p.brand
//""", nativeQuery = true)
//    List<BrandModel> findProductsByBrandWithCount();

    @Query("SELECT p.brand, COUNT(p.brand) FROM Product p GROUP BY p.brand")
    List<Object[]> findProductsByBrandWithCount();

}
