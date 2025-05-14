package Ecommerce;

public class Product {
    private String name;
    private String productId;
    private double price;

    public Product(String name, String productId, double price) {
        this.name = name;
        this.productId = productId;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Product Name : " + name);
        System.out.println("Product ID   : " + productId);
        System.out.println("Price        : $" + price);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
