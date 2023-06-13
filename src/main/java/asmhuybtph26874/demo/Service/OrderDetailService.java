package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.Account;
import asmhuybtph26874.demo.Model.Order;
import asmhuybtph26874.demo.Model.OrderDetail;
import asmhuybtph26874.demo.Repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public void insert(OrderDetail orderDetail) { orderDetailRepository.save(orderDetail); }
    public List<OrderDetail> getList(){
        return orderDetailRepository.findAll();
    }

    public List<OrderDetail> findByHD(Order order) {
        return orderDetailRepository.findByOrder(order);
    }
    public List<Object[]> getTop10BestSellingProductsByDateRange(Date startDate, Date endDate) {
        return orderDetailRepository.findTop10BestSellingProductsByDateRange(startDate, endDate, PageRequest.of(0, 10));
    }
    public List<Object[]> getTop10BesstSellingProductsByMonthRange(Integer startMonth, Integer endMonth) {
        return orderDetailRepository.findTopSellingProductsByMonthRange(startMonth, endMonth, PageRequest.of(0, 10));
    }
    public double calculateTotalAmountByOrderId(Integer orderId) {
        double totalAmount = orderDetailRepository.calculateTotalAmountByOrderId(orderId);
        return totalAmount;
    }
}
