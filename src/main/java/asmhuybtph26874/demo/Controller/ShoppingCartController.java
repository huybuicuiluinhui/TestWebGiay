package asmhuybtph26874.demo.Controller;

import asmhuybtph26874.demo.Model.Cart;
import asmhuybtph26874.demo.Model.CartItem;
import asmhuybtph26874.demo.Model.Product;
import asmhuybtph26874.demo.Service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    @Autowired
    ParamService param;
    @Autowired
    ProductService productService;
    @Autowired
    ShoppingCartService cartService;

    @Autowired
    HttpSession session;

    @Autowired
    private Cart cart;
    @Autowired
    SessionService sessionService;
    @GetMapping("/view")
    public String viewCart(Model model){
        model.addAttribute("sanPhamTrongGio",cartService.getAllItems());
        model.addAttribute("total",cartService.getAmount());
        return "/product/cart/view-cart";
    }

    @GetMapping("add/{idProduct}")
    public String addItemToCart(@PathVariable("idProduct") Integer id) {
        if (checkSecurity()) {
            Product product = productService.findById(id);
            if (product != null) {
                CartItem item = new CartItem();
                item.setIdProduct(product.getIdProduct());
                item.setNameProduct(product.getNameProduct());
                item.setPrice(product.getPrice());
                item.setSize(product.getSize());
                item.setImg(product.getImg());
                item.setQty(1);
                cartService.add(item);
                session.setAttribute("cart", cart);
            }
            return "redirect:/shopping-cart/view";

        }
        return "redirect:/account/login";

    }
    @GetMapping("/clear")
    public String clearCart(){
        cartService.clear();
        session.setAttribute("cart", cart);
        return "redirect:/shopping-cart/view";
    }
    @GetMapping("/delete/{idProduct}")
    public String removeItemCart(@PathVariable("idProduct") Integer id){
        cartService.remove(id);
        session.setAttribute("cart", cart);
        return "redirect:/shopping-cart/view";

    }
    @PostMapping("/update")
    public String update(@RequestParam("id") Integer id,@RequestParam("qty") Integer qty){
        Product product = productService.findById(id);
        if(qty<product.getQuantity()){
            session.setAttribute("cart", cart);
            cartService.update(id,qty);
        }
        else if(qty == product.getQuantity()){
            product.setStatus(false);
            session.setAttribute("cart", cart);
            cartService.update(id,qty);
        }

        return "redirect:/shopping-cart/view";
    }
//    @PostMapping("/update")
//    public String update(){
//        int id = param.getInt("id",0);
//        int qty = param.getInt("qty",1);
//        cartService.update(id,qty);
//        return "redirect:/shopping-cart/view";
//    }
public boolean checkSecurity() {
    String userName = sessionService.get("username");
    System.err.println("checkSecurity" + userName);
    if (userName != null) {
        return true;
    }
    return false;
}
}
