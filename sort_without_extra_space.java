import java.util.LinkedList;
import java.util.Queue;

public class sort_without_extra_space {
    public static void sortQueue(Queue<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int min_index = findMinIndex(list, size - i);
            insertMinToRear(list, min_index);
        }
    }

    public static int findMinIndex(Queue<Integer> list, int sortIndex) {
        int min_index = -1, min_value = Integer.MAX_VALUE;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int current = list.poll();
            if (current <= min_value && i <= sortIndex) {
                min_index = i;
                min_value = current;
            }
            list.add(current);
        }
        return min_index;
    }

    public static void insertMinToRear(Queue<Integer> list, int min_index) {
        int min_value = 0, size = list.size();
        for (int i = 0; i < size; i++) {
            int current = list.poll();
            if (i != min_index)
                list.add(current);
            else
                min_value = current;
        }
        list.add(min_value);
    }

    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        list.add(30);
        list.add(11);
        list.add(15);
        list.add(4);

        sortQueue(list);

        while (!list.isEmpty()) {
            System.out.print(list.poll() + " ");
        }
    }
}
