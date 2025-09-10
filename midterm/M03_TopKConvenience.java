
import java.util.*;

public class M03_TopKConvenience {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), K = sc.nextInt();

        // Min-Heap (qty 小在前, qty 相同則 name 字典序小在前)
        PriorityQueue<Item> heap = new PriorityQueue<>(
                (a, b) -> a.qty != b.qty ? Integer.compare(a.qty, b.qty)
                        : a.name.compareTo(b.name)
        );

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            Item item = new Item(name, qty);

            if (heap.size() < K) {
                heap.offer(item);
            } else if (compare(item, heap.peek()) > 0) {
                // 若新商品比堆頂更大，才替換
                heap.poll();
                heap.offer(item);
            }
        }

        // 取出元素並排序 (大到小)
        List<Item> result = new ArrayList<>(heap);
        result.sort((a, b) -> {
            if (b.qty != a.qty) {
                return Integer.compare(b.qty, a.qty);
            }
            return a.name.compareTo(b.name);
        });

        // 輸出
        for (Item it : result) {
            System.out.println(it.name + " " + it.qty);
        }
    }

    // 比較器 (回傳 >0 代表 a 比 b 大)
    private static int compare(Item a, Item b) {
        if (a.qty != b.qty) {
            return a.qty - b.qty;
        }
        return a.name.compareTo(b.name);
    }

    // 商品資料結構
    static class Item {

        String name;
        int qty;

        Item(String n, int q) {
            name = n;
            qty = q;
        }
    }
}
