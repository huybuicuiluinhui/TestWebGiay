package asmhuybtph26874.demo.Controller;
import asmhuybtph26874.demo.Model.Category;
import asmhuybtph26874.demo.Model.Product;
import asmhuybtph26874.demo.Repository.IProductRepository;
import asmhuybtph26874.demo.Service.IAccountService;
import asmhuybtph26874.demo.Service.ICategories;
import asmhuybtph26874.demo.Service.IProductService;
import asmhuybtph26874.demo.Service.SessionService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/asm/product")
public class ProductController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategories categoriesService;
    @Autowired
    ServletContext app;
    @Autowired
    private IProductRepository repository;
    @Autowired
    SessionService sessionService;

//    Tìm kiếm sản phẩm theo khoảng giá
    @PostMapping("/admin/searchPrice")
    public String filer(Model model,
                        @RequestParam("min") Optional<Double> min,
                        @RequestParam("max") Optional<Double> max){
        Double minPrice = min.orElse(Double.MIN_VALUE);
        Double maxPrice = max.orElse(Double.MAX_VALUE);
        System.out.println(minPrice);
        System.out.println(maxPrice);
        List<Product> products = repository.findByPriceBetween(minPrice,maxPrice);
        model.addAttribute("products",products);
        return "/product/admin/productManage";
    }
//    Tìm kiếm sản phẩm theo tên
    @PostMapping("/admin/searchName")
    public String searchName(Model model,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(required = false) String nameProduct){
        Page<Product> pageProduct;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 6);
        if (nameProduct == null || nameProduct.isBlank()) {
            pageProduct = repository.findAll(pageable);
        } else {
            pageProduct = repository.findByNameProductContains(nameProduct, pageable);
        }
        model.addAttribute("products", pageProduct.getContent());
        model.addAttribute("pageNumber", pageProduct.getNumber());
        model.addAttribute("pageTotal", pageProduct.getTotalPages());
        model.addAttribute("pageTotal", pageProduct.getTotalPages());
        model.addAttribute("page", pageProduct);
        return "/product/admin/productManage";
    }
    //    Tìm kiếm sản phẩm đa thuộc tính
    @PostMapping("/admin/searchNameAndBrandAndSize")
    public String searchNameAndBrandAndSize(Model model,
                                            @RequestParam("nameProduct") String nameProduct,
                                            @RequestParam("brand") String brand,
                                            @RequestParam("size") String size
                                            ){
        List<Product> products = repository.findByNameProductOrAndBrandOrSizeContains(nameProduct,brand,size);
        model.addAttribute("products",products);
        return "/product/admin/productManage";
    }
//    Hiển thị với admin
    @GetMapping("/admin")
    public String viewAdmin(Model model,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(required = false) String nameProduct) {
//  phân trang
        if(checkSecurity()){
            Page<Product> pageProduct;
            if (page < 1) page = 1;
            Pageable pageable = PageRequest.of(page - 1, 6);
            if (nameProduct == null || nameProduct.isBlank()) {
                pageProduct = productService.findAllOrderByPriceDesc(pageable);
            } else {
//            tìm kiếm sản phẩm
                pageProduct = repository.findByNameProductContains(nameProduct, pageable);
            }
            model.addAttribute("products", pageProduct.getContent());
            model.addAttribute("pageNumber", pageProduct.getNumber());
            model.addAttribute("pageTotal", pageProduct.getTotalPages());
            model.addAttribute("pageTotal", pageProduct.getTotalPages());
            model.addAttribute("page", pageProduct);
            return "/product/admin/productManage";
        }
        return "redirect:/account/login";
    }
// Hiển thị trang thêm giầy
    @GetMapping("/admin/viewAdd")
    public String viewAddAdmin(Model model) {
        List<Category> list1 = categoriesService.getList();
        model.addAttribute("listCategories", list1);
        System.out.println(list1);
        return "/product/admin/addProduct";
    }
// Thêm sản phẩm
    @PostMapping("/admin/addProduct")
    public String add(HttpServletRequest request,@RequestParam("img") MultipartFile file, @RequestParam("status") Boolean status,@RequestParam("size") String size) {
//        System.out.println( request.getParameterMap().toString());
        Product newProduct = new Product();
        Integer idCate = Integer.parseInt(request.getParameter("category"));
        newProduct.setCategory(categoriesService.findById(idCate));
        newProduct.setImg(file.getOriginalFilename());
        newProduct.setStatus(status);
//        newProduct.setSize(size);
        System.out.println(newProduct.getStatus());
        try {
            BeanUtils.populate(newProduct, request.getParameterMap());
        } catch (Exception e){
            e.printStackTrace();
        }
        save(file, "/resources/imgProduct/");
        System.out.println(file.getOriginalFilename());
        productService.insert(newProduct);
        return "redirect:/asm/product/admin";
    }
// Xóa sản phẩm theo id
    @GetMapping("/admin/delete/{idProduct}")
    public String delete(@PathVariable("idProduct") Integer id, MultipartFile file) {
//        this.delete(file.getOriginalFilename(),("/resources/imgProduct/"));
        productService.delete(id);
        return "redirect:/asm/product/admin";
    }

//    Hiển thị update
    @GetMapping("/admin/viewUpdate/{idProduct}")
    public String viewUpdate(Model model, @PathVariable("idProduct") Integer idProduct) {
        Product product = productService.findById(idProduct);
        model.addAttribute("product", product);
        System.out.println(product.getImg());
        List<Category> list = categoriesService.getList();
        model.addAttribute("list", list);
        return "/product/admin/updateProduct";
    }

//    Update sản phẩm
    @PostMapping("/admin/updateProduct/{idProduct}")
    public String update(@PathVariable("idProduct") Integer idProduct, HttpServletRequest request,@RequestParam("img") MultipartFile file,@RequestParam("size") String size) {
        Product newProduct = productService.findById(idProduct);
        Integer idCate = Integer.parseInt(request.getParameter("category"));
        newProduct.setSize(size);
        newProduct.setCategory(categoriesService.findById(idCate));
        if(file.getOriginalFilename()==""){
            newProduct.setImg(newProduct.getImg());
        }
        else{
            newProduct.setImg(file.getOriginalFilename());
            save(file, "/resources/imgProduct/");

        }
        try {
            BeanUtils.populate(newProduct, request.getParameterMap());
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(file.getOriginalFilename());
        productService.insert(newProduct);
        return "redirect:/asm/product/admin";

//        return "redirect: /asm/product/admin";
    }
//    Hàm xóa ảnh
    public void delete(String fileName, String folder) {
        File deleteFile = new File(app.getRealPath(folder) + fileName);
        if (deleteFile.exists()) {
            boolean checkDelete = deleteFile.delete();
            if (checkDelete) {
                System.out.println("Xóa thành công ảnh " + fileName);
            } else {
                System.out.println("Xóa thất bại");
            }
        } else {
            System.out.println("File không tồn tại!");
        }
    }

//    Hàm thêm sản phẩm
    public File save(MultipartFile file, String folder) {
        File dir = new File(app.getRealPath(folder));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            File saveFile = new File(dir, file.getOriginalFilename());
            file.transferTo(saveFile);
            return saveFile;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
// Hiển thị người dùng
@GetMapping("/user")
public String viewAllProduct(Model model,
                             @RequestParam(defaultValue = "1") int page
) {
//  if(checkSecurity()){
      Page<Product> pageSanPham;
      if (page < 1) page = 1;
      Pageable pageable = PageRequest.of(page - 1, 6);
      pageSanPham = productService.getPage(pageable);
      System.out.println(pageSanPham);
      List<Category> list1 = categoriesService.getList();
      model.addAttribute("page", pageSanPham);
      model.addAttribute("listCategories", list1);
      return "/product/productView";
//  }
//  return "redirect:/account/login";
}
    @PostMapping("/user/searchName")
    public String searchProduct(Model model,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(required = false) String nameProduct){
        Page<Product> pageProduct;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 6);
        if (nameProduct == null || nameProduct.isBlank()) {
            pageProduct = repository.findAll(pageable);
        } else {
            pageProduct = repository.findByNameProductContains(nameProduct, pageable);
        }
        model.addAttribute("products", pageProduct.getContent());
        model.addAttribute("pageNumber", pageProduct.getNumber());
        model.addAttribute("pageTotal", pageProduct.getTotalPages());
        model.addAttribute("pageTotal", pageProduct.getTotalPages());
        model.addAttribute("page", pageProduct);
        return "/product/productView";
    }
@GetMapping("/view-brand")
    public String filterBrand(Model model){
    List<Object[]> products = productService.findProductsByBrandWithCount();
         model.addAttribute("products",products);
         return "/product/brand-model";
}
public boolean checkSecurity(){
        String userName  = sessionService.get("username");
    System.err.println("checkSecurity"+userName );
        if(userName != null){
            return  true;
        }
        return false;
}
}
