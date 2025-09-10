
import java.util.*;

public class M12_MergeKTimeTables {

    static class Entry {

        int time, listIdx, pos;

        Entry(int t, int li, int p) {
            time = t;
            listIdx = li;
            pos = p;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int len = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                list.add(sc.nextInt());
            }
            lists.add(list);
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.time));
        for (int i = 0; i < K; i++) {
            if (!lists.get(i).isEmpty()) {
                pq.offer(new Entry(lists.get(i).get(0), i, 0));
            }
        }

        List<Integer> merged = new ArrayList<>();
        while (!pq.isEmpty()) {
            Entry e = pq.poll();
            merged.add(e.time);
            if (e.pos + 1 < lists.get(e.listIdx).size()) {
                pq.offer(new Entry(lists.get(e.listIdx).get(e.pos + 1), e.listIdx, e.pos + 1));
            }
        }

        for (int i = 0; i < merged.size(); i++) {
            System.out.print(merged.get(i) + (i == merged.size() - 1 ? "" : " "));
        }
    }
}
