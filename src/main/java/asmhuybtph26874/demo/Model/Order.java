package asmhuybtph26874.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "orderDate")
    private Date oderDate;
    @Column(name = "address")
    private String  address;

    @ManyToOne
    @JoinColumn(name = "idAccount",nullable = false)
    private Account account;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;
//    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
//    private List<OrderDetail> orderDetails;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", oderDate=" + oderDate +
                ", address='" + address + '\'' +
                ", account=" + account +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
