package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Service
@SessionScope
public class ShoppingCartService implements IShoppingCartService{
    @Autowired
    HttpSession session;
    @Autowired
    Cart cart;
    @Autowired
    HttpServletRequest request;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailService orderDetailService;
    public Cart getCart() {
        return cart;
    }
    Map<Integer, CartItem> maps = new HashMap<>(); // hiển thị danh sách giỏ hàng
    @Override
    public  void add(CartItem item){
            CartItem cartItem = maps.get(item.getIdProduct());
            if(cartItem == null){
                maps.put(item.getIdProduct(), item);
            }else{
                cartItem.setQty(cartItem.getQty()+1);
                maps.put(item.getIdProduct(), cartItem); // Gán item vào cartItem sau khi tăng số lượng
            }


    }
    @Override
    public void remove(int id){
        maps.remove(id);
    }
    @Override
    public CartItem update(int idProduct, int qty){
        CartItem cartItem = maps.get(idProduct);
        cartItem.setQty(qty);
        return  cartItem;
    }
    @Override
    public void clear(){
        maps.clear();
    }
    @Override
    public Collection<CartItem> getAllItems(){
        return maps.values();
    }
    @Override
    public int getCount(){
        return maps.values().size();

    }
    @Override
    public double getAmount(){
        return maps.values().stream().mapToDouble(item -> item.getQty()*item.getPrice()).sum();
    }
    @Override
    public void checkOut(String address){
        Account account = (Account) session.getAttribute("account");
        //String address = request.getParameter("address");
        Order order = new Order();
        order.setAccount(account);
        order.setAddress(address);
        order.setOderDate(new Date());
        order.setAddress(address);

        List<OrderDetail> orderDetails = new ArrayList<>();
        for (CartItem item : maps.values()) {
            System.out.println("đã vô đây rồi nhé");
            Product product = productService.findById(item.getIdProduct());

            int soLuongMua = item.getQty();
      int soLuongTon =  product.getQuantity();
      if (soLuongMua==soLuongTon){
          product.setStatus(false);
      }
      product.setQuantity(soLuongTon - soLuongMua);
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(item.getIdProduct());
            orderDetail.setPrice(item.getPrice());
            orderDetail.setQuantity(item.getQty());
            orderDetails.add(orderDetail);
             Product pr = new Product();
             pr.setQuantity(item.getQty());
             pr.setSize(item.getSize());
             pr.setImg(item.getImg());
             pr.setPrice(item.getPrice());
             pr.setIdProduct(item.getIdProduct());
             pr.setPrice(item.getPrice());
            orderDetail.setProduct(pr);
        }
        order.setOrderDetails(orderDetails);
        orderService.saveHoaDon(order);
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrder(order);
            orderDetailService.insert(orderDetail);
        }
        cart.clearCart();
        session.setAttribute("cart", cart);
    }

}
