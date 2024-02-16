public class recursion {

    static void rec_fun(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.print("raj" + i + "\n");
        rec_fun(i + 1, n);

    }

    public static void main(String[] args) {
        int num = 33;
        System.out.println("\nRecursion Function Call:");
        rec_fun(1, num);
    }
}
