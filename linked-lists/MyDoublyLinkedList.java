class Node { 
    public int data; 
    public Node next; 
    public Node prev; 

    public void displayNodeData() {
        System.out.println(" { " + data + " } " );
    }
}

public class MyDoublyLinkedList {
    private Node head; 
    private Node tail; 
    int size;

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        newNode.prev = null;
        if (head!= null) {
            head.prev = newNode;
        }
        head = newNode; 
        if (tail == null) {
            tail = newNode; 
        }
        size++;
    }

    public void insertLast(int data) {
        Node newNode = new Node(); 
        newNode.data = data; 
        newNode.next = null; 
        if(tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if(head == null) {
            head = newNode;
        }
        size++;
    }

    public Node deleteFirst() {
        if(size == 0) {
            throw new RuntimeException("Doubly linked list is already empty");
        }
        Node temp = head; 
        head = head.next;
        head.prev = null;
        size--;
        return temp;
    }

    public Node deleteLast() {
        if(size == 0) {
            throw new RuntimeException("Doubly linked list is already empty");
        }    
        Node temp = tail; 
        tail = tail.prev;
        tail.next = null; 
        size--;
        return temp;
    }

    public void deleteAfter(Node after) {
        Node temp = head;
        while(temp.next != null && temp.data != after.data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next.prev=temp; 
        }
        temp.next = temp.next.next;
    }

    public void printLinkedListForward() {
        System.out.println("Printing doubly linked list (head --> tail) ");
        Node curr = head;
        while (curr != null) {
            curr.displayNodeData();
            curr = curr.next;
        }
        System.out.println(); 
    }

    public void printLinkedListBackward() {
        System.out.println("Printing doubly linked list (tail --> head) ");
        Node curr = tail;
        while (curr.prev != null) {
            curr.displayNodeData();
            curr = curr.prev;
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        MyDoublyLinkedList mdll = new MyDoublyLinkedList();
        mdll.insertFirst(50);
        mdll.insertFirst(60);
        mdll.insertFirst(70);
        mdll.insertFirst(10);
        mdll.insertLast(20);
        mdll.printLinkedListForward();
        mdll.printLinkedListBackward();
 
        System.out.println("================");
        // Doubly Linked list will be
        // 10 ->  70 -> 60 -> 50 -> 20
 
        Node node=new Node();
        node.data=10;
        mdll.deleteAfter(node);
        mdll.printLinkedListForward();
        mdll.printLinkedListBackward();
        // After deleting node after 1,doubly Linked list will be
        // 20 -> 10 -> 60-> 50
        System.out.println("================");
        mdll.deleteFirst();
        mdll.deleteLast();
 
        // After performing above operation, doubly Linked list will be
        //  60 -> 50
        mdll.printLinkedListForward();
        mdll.printLinkedListBackward();
    }
}