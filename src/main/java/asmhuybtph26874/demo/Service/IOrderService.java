package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();

    void saveHoaDon(Order order);

    void delete(Integer id);

    Order findById(Integer id);

    int soLuong(List<Order> orders);

    String generateInvoiceCode();
}
