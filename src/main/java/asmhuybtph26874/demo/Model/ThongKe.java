package asmhuybtph26874.demo.Model;

public class ThongKe {
    private String nameProduct;
    private Integer amount;

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ThongKe(String nameProduct, Integer amount) {
        this.nameProduct = nameProduct;
        this.amount = amount;
    }
}
