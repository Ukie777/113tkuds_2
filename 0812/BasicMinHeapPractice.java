import java.util.ArrayList;
import java.util.List;

public class BasicMinHeapPractice {
    private List<Integer> heap;

    public BasicMinHeapPractice() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // 插入元素
    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    // 取出最小值
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }
        return min;
    }

    // 查看最小值
    public int getMin() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap.get(i) < heap.get(parent(i))) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int minIndex = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < heap.size() && heap.get(left) < heap.get(minIndex)) {
            minIndex = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(minIndex)) {
            minIndex = right;
        }
        if (minIndex != i) {
            swap(i, minIndex);
            heapifyDown(minIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        BasicMinHeapPractice minHeap = new BasicMinHeapPractice();
        int[] values = {15, 10, 20, 8, 25, 5};

        for (int val : values) {
            minHeap.insert(val);
        }

        System.out.println("Extract Min 順序：");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.extractMin() + " ");
        }
    }
}
