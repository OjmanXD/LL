public class block_swap {
    public static void RotateArray(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        if (d == 0)
            return;
        swap(arr, 0, d - 1);
        swap(arr, d, n - 1);
        swap(arr, 0, n - 1);
    }

    public static void swap(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int rotations = 3;
        RotateArray(arr, rotations);

        System.out.println("rotated array: ");
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }
}