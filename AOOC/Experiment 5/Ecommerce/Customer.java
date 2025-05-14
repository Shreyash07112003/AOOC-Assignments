package Ecommerce;

public class Customer {
    private String name;
    private int customerId;

    public Customer(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public void displayDetails() {
        System.out.println("Customer Name : " + name);
        System.out.println("Customer ID   : " + customerId);
    }
}
