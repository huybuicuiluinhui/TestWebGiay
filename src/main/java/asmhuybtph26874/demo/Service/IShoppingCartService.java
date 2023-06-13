package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.CartItem;
import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.List;

public interface IShoppingCartService {

    void add(CartItem item);

    void remove(int id);

    CartItem update(int idProduct, int qty);

    void clear();

    Collection<CartItem> getAllItems();

    int getCount();

    double getAmount();

    void checkOut(String email);
}
