package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.BrandModel;
import asmhuybtph26874.demo.Model.Product;
import asmhuybtph26874.demo.Repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService  implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> getList() {
        return productRepository.findAll();
    }
    @Override
    public Product insert(Product product) {
        return productRepository.save(product);
    }
    @Override
    public Page<Product> getPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    @Override
    public boolean  delete(Integer idProduct) {
       productRepository.deleteById(idProduct);
       return  true;
    }
    @Override
    public Product update(Integer idProduct, Product product) {
        Product product1 = this.productRepository.findById(product.getIdProduct()).orElse(null);
        product1.setNameProduct(product.getNameProduct());
        product1.setBrand(product.getBrand());
        product1.setImg(product.getImg());
        product1.setCategory(product.getCategory());
        product1.setMaterial(product.getMaterial());
        product1.setPrice(product.getPrice());
        product1.setSize(product.getSize());
        product1.setStatus(product.getStatus());
        product1.setCategory(product.getCategory());
        return productRepository.save(product1);
    }
    @Override
    public Product findById(Integer idProduct) {
        return productRepository.findById(idProduct).orElse(null);
    }

    @Override
    public Page<Product> findAllOrderByPriceDesc(Pageable pageable) {
        return productRepository.findAllOrderByPriceDesc(pageable);
    }
    @Override
    public List<Object[]> findProductsByBrandWithCount() {
        return productRepository.findProductsByBrandWithCount();
    }

}
