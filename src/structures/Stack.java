package structures;

public class Stack {
    private int top;
    private int capacity;
    private char[] arr;

    public Stack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.arr = new char[capacity];
    }

    public boolean isFull() {
        return this.top == this.capacity - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(char value) {
        if (this.isFull()) {
            return;
        }
        this.arr[++this.top] = value;
//        System.out.println(String.format("%s pushed", value));
    }

    public char pop() {
        if (this.isEmpty()) {
            return 0;
        }
//        System.out.println(String.format("%s popped", this.arr[this.top]));
        return this.arr[this.top--];
    }

    public char peek() {
        if (this.isEmpty()) {
            return 0;
        }
//        System.out.println(String.format("%s peeked", this.arr[this.top]));
        return this.arr[this.top];
    }

}
