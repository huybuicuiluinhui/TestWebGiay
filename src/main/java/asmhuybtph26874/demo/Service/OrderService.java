package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.Order;
import asmhuybtph26874.demo.Repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void saveHoaDon(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Integer id) { orderRepository.deleteById(id); }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public int soLuong(List<Order> orders) {
        return 0;
    }

    @Override
    public String generateInvoiceCode() {
        // Lấy thời gian hiện tại
        long timestamp = System.currentTimeMillis();

        // Tạo mã hoá đơn từ timestamp
        String code = "HD" + timestamp;

        return code;
    }

}
