import java.util.*;

class Element {
    int value;  // 值
    int arrayIndex;  // 來自哪個陣列
    int elementIndex;  // 該陣列中的位置

    Element(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

public class MergeKSortedArrays {
    public static List<Integer> mergeKSortedArrays(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));

        // 把每個陣列的第一個元素放進 minHeap
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.add(new Element(arrays[i][0], i, 0));
            }
        }

        // 不斷取出最小的，並加入該陣列的下一個元素
        while (!minHeap.isEmpty()) {
            Element e = minHeap.poll();
            result.add(e.value);

            int nextIndex = e.elementIndex + 1;
            if (nextIndex < arrays[e.arrayIndex].length) {
                minHeap.add(new Element(arrays[e.arrayIndex][nextIndex], e.arrayIndex, nextIndex));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = {{1,4,5}, {1,3,4}, {2,6}};
        int[][] test2 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] test3 = {{1}, {0}};

        System.out.println(mergeKSortedArrays(test1)); // [1,1,2,3,4,4,5,6]
        System.out.println(mergeKSortedArrays(test2)); // [1,2,3,4,5,6,7,8,9]
        System.out.println(mergeKSortedArrays(test3)); // [0,1]
    }
}
