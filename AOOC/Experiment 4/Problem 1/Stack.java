public interface Stack {
    int size = 5; // Fixed stack size (can be changed or made dynamic)
    
    void push(int value);
    int pop();
    void display();
    boolean overflow();
    boolean underflow();
}
