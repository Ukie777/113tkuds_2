
import java.util.*;

public class M01_BuildHeap {

    static int n;
    static boolean isMax;
    static int[] heap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.next();   // "max" or "min"
        isMax = type.equals("max");
        n = sc.nextInt();
        heap = new int[n];
        for (int i = 0; i < n; i++) {
            heap[i] = sc.nextInt();
        }

        // bottom-up 建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }

        // 輸出
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(heap[i]);
        }
        System.out.println();
    }

    private static void heapifyDown(int i) {
        while (true) {
            int left = 2 * i + 1, right = 2 * i + 2, target = i;

            if (isMax) {
                if (left < n && heap[left] > heap[target]) {
                    target = left;
                }
                if (right < n && heap[right] > heap[target]) {
                    target = right;
                }
            } else {
                if (left < n && heap[left] < heap[target]) {
                    target = left;
                }
                if (right < n && heap[right] < heap[target]) {
                    target = right;
                }
            }

            if (target == i) {
                break; // 已經符合 Heap 性質

            }
            swap(i, target);
            i = target; // 繼續往下調整
        }
    }

    private static void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
