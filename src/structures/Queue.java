package structures;

public class Queue {
    private int length;
    private int nElem; // количество элементов в стеке
    private int head;
    private int tail;
    private int[] arr;

    public Queue(int length) {
        this.length = length;
        this.head = 0;
        this.tail = -1;
        this.nElem = 0;
        this.arr = new int[length];
    }

    public boolean isEmpty() {
        return this.nElem == 0;
    }

    public boolean isFull() {
        return this.nElem == this.length;
    }

    public void push(int value) {
        if (isFull()) {
            return;
        }

        // перенос хвоста с конца в начало массива
        if (this.tail == this.length - 1) {
            this.tail = -1;
        }

        this.nElem++;
        this.arr[++this.tail] = value;
        System.out.println(String.format("%d pushed", value));
    }

    public int pop() {
        if (this.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        this.nElem--;
        int value = this.arr[this.head];

        if (this.head == this.length - 1) { // перенос головного указателя с конца вперед
            this.head = 0;
        }
        System.out.println(String.format("%d popped", this.arr[this.head]));
        return value;
    }
}
