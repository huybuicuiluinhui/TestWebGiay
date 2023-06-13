package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class CartService {
    @Autowired
    HttpSession session;

    @Autowired
    HttpServletRequest request;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    private final Cart cart = new Cart();
    public void themSanPham(Integer sphamId, Integer soLuong){
        Map<Integer, Integer> dsSanPham = cart.getDanhSachSanPham();
//        Nếu trong giỏ đã có hàng
        if(dsSanPham.containsKey(sphamId)){
//            Thì tăng số lương
//            Bước 1 : Lấy số lượng hiện tại
            Integer soLuongHienTai = dsSanPham.get(sphamId);
//            Bước 2 : Cộng dồn só lượng
             Integer soLuongMoi = soLuongHienTai + soLuong ;
//            Bước 3: Cập nhật lại danh sách
            dsSanPham.put(sphamId, soLuongMoi);
        }
        else{
            dsSanPham.put(sphamId,soLuong);
        }
    }
    public Map<Integer,Integer> xemSanPham(){
        return cart.getDanhSachSanPham();
    }
    public void  remove(int sanPhamId){
        cart.getDanhSachSanPham().remove(sanPhamId);
    }
    public Cart getCart() {
        return cart;
    }
//    public void checkOut(){
//        Account account = (Account) session.getAttribute("account");
//        //String address = request.getParameter("address");
//        Order order = new Order();
//        order.setAccount(account);
//        order.setOderDate(new Date());
//        //order.setAddress(address);
//        List<OrderDetail> orderDetails = new ArrayList<>();
//        Cart cart = new Cart();
//        int danhSachSanPham = cart.getCartItemCount();
//        System.out.println(danhSachSanPham);
//        for (CartItem item : cart.getItems()) {
//            System.out.println("hihih");
//            int soLuongMua = item.getQty();
//            System.out.println(soLuongMua);
//            Product product = new Product();
//          int soLuongTon =  product.getQuantity();
//            System.out.println(soLuongTon);
//            product.setQuantity(soLuongTon - soLuongMua);
//            OrderDetail orderDetail = new OrderDetail();
//            orderDetail.setId(item.getIdProduct());
//            orderDetail.setPrice(item.getPrice());
//            orderDetail.setQuantity(item.getQty());
//            orderDetails.add(orderDetail);
//        }
//
//        order.setOrderDetails(orderDetails);
//        orderService.saveHoaDon(order);
//        for (OrderDetail orderDetail : orderDetails) {
//            orderDetail.setOrder(order);
//            orderDetailService.insert(orderDetail);
//        }
//        cart.clearCart();
//        session.setAttribute("cart", cart);
//    }

}
