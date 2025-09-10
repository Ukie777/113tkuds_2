
import java.util.*;

public class KthSmallestElement {

    // 方法 1：Min Heap，取 K 次
    public static int kthSmallestMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }
        int ans = -1;
        for (int i = 0; i < k; i++) {
            ans = minHeap.poll();
        }
        return ans;
    }

    // 方法 2：Max Heap，只保留 K 個元素
    public static int kthSmallestMaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("方法1 Min Heap → 第 " + k1 + " 小: " + kthSmallestMinHeap(arr1, k1));
        System.out.println("方法2 Max Heap → 第 " + k1 + " 小: " + kthSmallestMaxHeap(arr1, k1));

        int[] arr2 = {1};
        int k2 = 1;
        System.out.println("方法1 Min Heap → 第 " + k2 + " 小: " + kthSmallestMinHeap(arr2, k2));
        System.out.println("方法2 Max Heap → 第 " + k2 + " 小: " + kthSmallestMaxHeap(arr2, k2));

        int[] arr3 = {3, 1, 4, 1, 5, 9, 2, 6};
        int k3 = 4;
        System.out.println("方法1 Min Heap → 第 " + k3 + " 小: " + kthSmallestMinHeap(arr3, k3));
        System.out.println("方法2 Max Heap → 第 " + k3 + " 小: " + kthSmallestMaxHeap(arr3, k3));
    }
}
