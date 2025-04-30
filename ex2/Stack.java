package ex2;

import java.util.Scanner;
public class Stack {
    int size;
    int[] stk;
    int top = -1;

    Stack(int size){
        this.size = size;
        this.stk = new int[size];
    }
    void push(){
        Scanner sc = new Scanner(System.in);
        if(top == size - 1){
            System.out.println("Stack is full");
        }
        else{
            System.out.println("Enter element to push");
            int ele = sc.nextInt();
            top++;
            stk[top] = ele;
        }
    }
    void pop(){
        if(top == -1){
            System.out.println("Stack is empty");
        }
        else{
            int ele = stk[top];
            top--;
            System.out.println("Poped element: " + ele);
        }
    }
    void display(){
        if(top == -1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack elements: ");
            for(int i = top;i >= 0; i--){
                System.out.println(stk[i]);
            }
        }
    }
    void peek(){
        if(top == -1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Top element: " + stk[top]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of stack: ");
        int size = sc.nextInt();

        Stack s = new Stack(size);

        while(true){
            System.out.println("Choose Operation: 1.Push 2.Pop 3.Display 4.Peek 5.Exit");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    s.push();
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    s.peek();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice!!");
            }
        }
    }
}
