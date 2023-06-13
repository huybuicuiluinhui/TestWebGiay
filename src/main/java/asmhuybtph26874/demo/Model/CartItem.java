package asmhuybtph26874.demo.Model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int qty= 1;
    private String img;
    private String size;
}
