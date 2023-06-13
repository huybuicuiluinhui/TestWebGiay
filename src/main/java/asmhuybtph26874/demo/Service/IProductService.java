package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.BrandModel;
import asmhuybtph26874.demo.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProductService {
    List<Product> getList();
    Product insert(Product product);
    Page<Product> getPage(Pageable pageable);
    boolean delete(Integer idProduct);
    Product update(Integer idProduct, Product product);
    Product findById(Integer idProduct);
Page<Product> findAllOrderByPriceDesc(Pageable pageable);
List<Object[]> findProductsByBrandWithCount();
}
