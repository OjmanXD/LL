// to segregate even and odd nodes in a linked list
// Algorithm:
// 1) Create two lists Even List and Odd list.
// 2) Traversing the original list and sending the vales to otheir respective lists
// 3) Merge odd tail connection to the even tail of the lists

import java.util.LinkedList;
import java.util.Scanner;

public class even_odd_LL {

    static LinkedList<Integer> mainl = new LinkedList<>();
    static LinkedList<Integer> odd = new LinkedList<>();
    static LinkedList<Integer> even = new LinkedList<>();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                mainl.add(x);
                if (x % 2 == 0) {
                    even.add(x);
                } else {
                    odd.add(x);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        odd.addAll(even);
        System.out.println("MergedList = " + odd);

    }
}
