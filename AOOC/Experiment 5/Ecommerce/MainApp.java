import Ecommerce.Product;
import Ecommerce.Customer;
import Ecommerce.Order;

public class MainApp {
    public static void main(String[] args) {
        Product product = new Product("Wireless Mouse", "P1001", 25.99);
        Customer customer = new Customer("Bob", 2001);
        Order order = new Order(product, customer, 2);

        order.placeOrder();
    }
}
