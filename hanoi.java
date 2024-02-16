import java.util.Stack;

public class iterative_tower_of_hanoi {
    static void iterativeTowerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        // Create three stacks to simulate the rods
        Stack<Integer> source = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        Stack<Integer> auxiliary = new Stack<>();

        // Fill the source stack with disks
        for (int i = n; i >= 1; i--) {
            source.push(i);
        }

        int totalMoves = (int) Math.pow(2, n) - 1; // Total number of moves required
        if (n % 2 == 0) {
            char temp = toRod;
            toRod = auxRod;
            auxRod = temp;
        }

        // Perform the iterative moves
        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                moveDisksBetweenTwoPoles(source, destination, fromRod, toRod);
            } else if (i % 3 == 2) {
                moveDisksBetweenTwoPoles(source, auxiliary, fromRod, auxRod);
            } else if (i % 3 == 0) {
                moveDisksBetweenTwoPoles(auxiliary, destination, auxRod, toRod);
            }
        }
    }

    static void moveDisksBetweenTwoPoles(Stack<Integer> src, Stack<Integer> dest, char s, char d) {
        // When source pole is empty
        if (src.isEmpty()) {
            int pole1Top = dest.pop();
            src.push(pole1Top);
            System.out.println("Move disk " + pole1Top + " from " + d + " to " + s);
        }
        // When destination pole is empty
        else if (dest.isEmpty()) {
            int pole1Top = src.pop();
            dest.push(pole1Top);
            System.out.println("Move disk " + pole1Top + " from " + s + " to " + d);
        }
        // When top disk of source pole is smaller than the top disk of destination pole
        else if (src.peek() > dest.peek()) {
            int pole1Top = dest.pop();
            src.push(pole1Top);
            System.out.println("Move disk " + pole1Top + " from " + d + " to " + s);
        } else {
            int pole1Top = src.pop();
            dest.push(pole1Top);
            System.out.println("Move disk " + pole1Top + " from " + s + " to " + d);
        }
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        iterativeTowerOfHanoi(n, 'A', 'C', 'B');
    }
}
