package asmhuybtph26874.demo.Model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Cart {
    private List<CartItem> items;
    public Cart() {
        this.items = new ArrayList<>();
    }
    private Map<Integer, Integer> danhSachSanPham = new HashMap<>();
    public Map<Integer, Integer> getDanhSachSanPham(){
        return danhSachSanPham;
    }
    public void setDanhSachSanPham(Map<Integer,Integer>danhSachSanPham){
        this.danhSachSanPham = danhSachSanPham;
    }
    public List<CartItem> getItems() {

        return items;
    }
    public void clearCart() {
        items.clear();
    }
    public int getCartItemCount() {
            return items.size();
    }



}
