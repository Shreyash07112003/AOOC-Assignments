import java.util.*;
public class IntegerStack implements Stack {
    private int[] stack;
    private int top;

    public IntegerStack() {
        stack = new int[size];
        top = -1;
    }

    @Override
    public void push(int value) {
        if (overflow()) {
            System.out.println("Stack Overflow! Cannot push " + value);
        } else {
            stack[++top] = value;
            System.out.println("Pushed: " + value);
        }
    }

    @Override
    public int pop() {
        if (underflow()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1;
        } else {
            int poppedValue = stack[top--];
            System.out.println("Popped: " + poppedValue);
            return poppedValue;
        }
    }

    @Override
    public void display() {
        if (underflow()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean overflow() {
        return top == size - 1;
    }

    @Override
    public boolean underflow() {
        return top == -1;
    }
}
