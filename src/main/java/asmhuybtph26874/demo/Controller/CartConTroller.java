package asmhuybtph26874.demo.Controller;

import asmhuybtph26874.demo.Service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartConTroller {
    private final CartService service = new CartService();
    @RequestMapping("/add/{idProduct}")
        public String themSanPhamVaoGio(@PathVariable(name = "idProduct") Integer idSP){
        service.themSanPham(idSP, 1);
        return "redirect:/cart";
    }
    @GetMapping

    public String viewCart(Model model){
        Map<Integer, Integer> sanPhamTrongGio = service.xemSanPham();
        model.addAttribute("sanPhamTrongGio",sanPhamTrongGio);
        System.out.println(sanPhamTrongGio);
        return "product/cart/view-cart";
    }
    @GetMapping("/delete/{idProduct}")
    public String removeCart(@PathVariable(name ="idProduct") Integer idSP ){
        service.remove(idSP);
        return "redirect:/cart";
    }




}
