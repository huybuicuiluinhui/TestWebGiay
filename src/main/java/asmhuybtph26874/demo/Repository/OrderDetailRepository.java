package asmhuybtph26874.demo.Repository;

import asmhuybtph26874.demo.Model.Order;
import asmhuybtph26874.demo.Model.OrderDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    List<OrderDetail> findByOrder(Order order);

    @Query(value = "SELECT p.nameProduct, SUM(od.quantity)FROM OrderDetail od JOIN od.product p WHERE od.order.oderDate >= :startDate AND od.order.oderDate <= :endDate GROUP BY p.nameProduct ORDER BY SUM(od.quantity) DESC ")
    List<Object[]> findTop10BestSellingProductsByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);
    ///
    @Query("SELECT od.product.nameProduct, SUM(od.quantity),FUNCTION('MONTH', o.oderDate) FROM OrderDetail od JOIN od.order o WHERE FUNCTION('MONTH', o.oderDate) BETWEEN :startMonth AND :endMonth GROUP BY od.product.nameProduct,FUNCTION('MONTH', o.oderDate) ORDER BY SUM(od.quantity) DESC")
    List<Object[]> findTopSellingProductsByMonthRange(@Param("startMonth") int startMonth, @Param("endMonth") int endMonth,Pageable pageable);

    @Query("SELECT SUM(od.product.price) FROM OrderDetail od WHERE od.order.id = :orderId")
    double calculateTotalAmountByOrderId(Integer orderId);
//Thống kê số lượng tồn
@Query("SELECT p.nameProduct, p.quantity FROM Product p WHERE p.quantity > 0 ORDER BY p.createDate ASC, p.quantity DESC ")
List<Object[]> findUnsoldAndLeastSoldProductsByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

    @Query("SELECT p.nameProduct, p.quantity FROM Product p WHERE p.quantity > 0 AND FUNCTION('MONTH', p.createDate) >= :startMonth AND  FUNCTION('MONTH', p.createDate) <= :endMonth ORDER BY p.createDate ASC, p.quantity DESC ")
    List<Object[]> findTop10OldestStockProductsByMonthRange(@Param("startMonth") int startMonth, @Param("endMonth") int endMonth,Pageable pageable);


}
