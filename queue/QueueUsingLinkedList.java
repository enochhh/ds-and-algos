public class QueueUsingLinkedList {
    private Node front, rear;
    private int currentSize;

    private class Node {
        int data;
        Node next;
    }

    public QueueUsingLinkedList() {
        front = null; 
        rear = null; 
        currentSize = 0;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public int dequeue() {
        int data = front.data;
        front = front.next;
        if(isEmpty()) {
            rear = null;
        }
        currentSize--;
        return data;
    }

    public void enqueue(int data) {
        Node oldRear = rear;
        rear = new Node();
        rear.data = data;
        rear.next = null;
        if (isEmpty()) {
            front = rear;
        }
        else {
            oldRear.next = rear;
        }
        currentSize++;;
    }
    public static void main(String a[]){
 
        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
        queueUsingLinkedList.enqueue(60);
        queueUsingLinkedList.dequeue();
        queueUsingLinkedList.enqueue(10);
        queueUsingLinkedList.enqueue(20);
        queueUsingLinkedList.enqueue(40);
        queueUsingLinkedList.dequeue();
        queueUsingLinkedList.enqueue(70);
        queueUsingLinkedList.dequeue();
        queueUsingLinkedList.enqueue(80);
        queueUsingLinkedList.enqueue(100);
        queueUsingLinkedList.dequeue();
        queueUsingLinkedList.enqueue(150);
        queueUsingLinkedList.enqueue(50);
    }
}
