package asmhuybtph26874.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idProduct;
    @Column(name = "name_product")
    private String nameProduct;
    @Column(name = "img")
    private String img;
    @Column(name = "price")
    private Double price;
    @Column(name = "size")
    private String size;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "material")
    private String material;
    @Column(name = "brand")
    private String brand;
    @Column(name = "statusproduct")
    private Boolean status;
    @Column(name = "create_date")
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

}
