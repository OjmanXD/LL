import java.util.HashSet;

public class loop_detection {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    static void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    static boolean detectLoop(Node h) {
        HashSet<Node> set = new HashSet<>();
        while (h != null) {
            if (!set.add(h))
                return true;
            h = h.next;
        }
        return false;
    }

    public static void main(String[] args) {
        loop_detection.push(20);
        loop_detection.push(4);
        loop_detection.push(15);
        loop_detection.push(10);
        loop_detection.head.next.next.next.next = loop_detection.head;

        System.out.println(detectLoop(head) ? "Loop Found" : "No Loop");
    }
}
