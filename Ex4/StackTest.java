package Ex4;

import java.util.Scanner;

interface StackOperations {
    void push();
    void pop();
    void display();
    void overflow();
    void underflow();
}

class IntegerStack implements StackOperations {
    int size;
    int[] stk;
    int top = -1;

    IntegerStack(int size) {
        this.size = size;
        this.stk = new int[size];
    }

    public void push() {
        if (top == size - 1) {
            overflow();
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter element to push: ");
            int ele = sc.nextInt();
            top++;
            stk[top] = ele;
            System.out.println("Element pushed.");
        }
    }

    public void pop() {
        if (top == -1) {
            underflow();
        } else {
            int ele = stk[top];
            top--;
            System.out.println("Popped element: " + ele);
        }
    }

    public void display() {
        if (top == -1) {
            underflow();
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stk[i]);
            }
        }
    }

    public void overflow() {
        System.out.println("Stack Overflow! Cannot push more elements.");
    }

    public void underflow() {
        System.out.println("Stack Underflow! No elements to pop/display.");
    }
}

public class StackTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the stack: ");
        int size = sc.nextInt();

        IntegerStack stack = new IntegerStack(size);

        while (true) {
            System.out.println("\nChoose Operation:\n1. Push\n2. Pop\n3. Display\n4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    stack.push();
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }
}

