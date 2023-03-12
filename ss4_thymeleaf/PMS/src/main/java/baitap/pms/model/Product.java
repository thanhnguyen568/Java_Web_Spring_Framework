package baitap.pms.model;

public class Product {
    private int productNo;
    private String productDescription;
    private int customerPrice;
    private String customerManufacture;

    public Product() {
    }

    public Product(int productNo, String productDescription, int customerPrice, String customerManufacture) {
        this.productNo = productNo;
        this.productDescription = productDescription;
        this.customerPrice = customerPrice;
        this.customerManufacture = customerManufacture;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getCustomerPrice() {
        return customerPrice;
    }

    public void setCustomerPrice(int customerPrice) {
        this.customerPrice = customerPrice;
    }

    public String getCustomerManufacture() {
        return customerManufacture;
    }

    public void setCustomerManufacture(String customerManufacture) {
        this.customerManufacture = customerManufacture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNo=" + productNo +
                ", productDescription='" + productDescription + '\'' +
                ", customerPrice=" + customerPrice +
                ", customerManufacture='" + customerManufacture + '\'' +
                '}';
    }
}
