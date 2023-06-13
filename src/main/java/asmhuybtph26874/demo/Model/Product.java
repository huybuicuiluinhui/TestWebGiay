package asmhuybtph26874.demo.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

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
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    public Product() {
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getImg() {
        return img;
    }

    public Double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getMaterial() {
        return material;
    }

    public String getBrand() {
        return brand;
    }

    public Boolean getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
