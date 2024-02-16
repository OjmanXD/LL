class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }
}

public class merge_sort_dll {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
            newNode.prev = last;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        merge_sort_dll dll = new merge_sort_dll();
        dll.add(100);
        dll.add(20);
        dll.add(313);

        dll.display(); // Output: 10 20 30
    }
}