public class Product {

    private String productId;

    private String brand;

    private String price;

    public Product() {

    }

    public Product(String productId, String brand, String price) {
        this.productId = productId;
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product{" + "productId='" + productId + '\''
                + ", brand='" + brand + '\''
                + ", price='" + price + '\'' + '}';
    }
}
