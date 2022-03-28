/* Stack implementation using Array */

public class MyStack {
    int size; 
    int arr[];
    int top;

    MyStack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int element) {
        if(!isFull()) {
            top++;
            arr[top] = element;
        }
    }

    public int pop() {
        if(!isEmpty()) {
            int topElement = top; 
            top--;
            return arr[topELement];
        }
        else return -1;
    }

    public int peek() {
        if(!this.isEmpty()) {
            return arr[top];
        }
        else return -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (size - 1 == top);
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.pop();
        System.out.println("=================");
        myStack.push(100);
        myStack.push(90);
        myStack.push(10);
        myStack.push(50);
        System.out.println("=================");
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println("=================");
    }
}
