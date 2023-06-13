package asmhuybtph26874.demo.Repository;

import asmhuybtph26874.demo.Model.Order;
import asmhuybtph26874.demo.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository  extends JpaRepository<Order,Integer> {
}
