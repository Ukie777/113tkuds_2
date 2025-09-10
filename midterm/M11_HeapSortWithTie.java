
import java.util.*;

public class M11_HeapSortWithTie {

    static class Student {

        int score, idx;

        Student(int s, int i) {
            score = s;
            idx = i;
        }
    }

    static void heapify(Student[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && compare(arr[l], arr[largest]) > 0) {
            largest = l;
        }
        if (r < n && compare(arr[r], arr[largest]) > 0) {
            largest = r;
        }
        if (largest != i) {
            Student tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, n, largest);
        }
    }

    // 比較器：分數大者優先；分數相同 index 小者優先
    static int compare(Student a, Student b) {
        if (a.score != b.score) {
            return a.score - b.score;
        }
        return b.idx - a.idx; // index 小的視為較大（因為 max-heap）
    }

    static void heapSort(Student[] arr, int n) {
        // 建 Max-Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 取出元素並放到尾端
        for (int i = n - 1; i > 0; i--) {
            Student tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Student(sc.nextInt(), i);
        }
        heapSort(arr, n);
        // 遞增輸出
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].score + (i == n - 1 ? "" : " "));
        }
    }
}
