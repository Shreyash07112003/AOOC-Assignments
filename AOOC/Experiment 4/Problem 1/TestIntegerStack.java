import java.util.*;
public class TestIntegerStack {
    public static void main(String[] args) {
        IntegerStack myStack = new IntegerStack();

        myStack.display();
        myStack.pop(); // underflow

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);
        myStack.display();

        myStack.push(60); // overflow

        myStack.pop();
        myStack.pop();
        myStack.display();
    }
}
