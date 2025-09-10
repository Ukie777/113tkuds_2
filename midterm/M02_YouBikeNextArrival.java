
import java.util.*;

public class M02_YouBikeNextArrival {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        int[] times = new int[n];
        String[] original = new String[n];

        for (int i = 0; i < n; i++) {
            String t = sc.nextLine().trim();
            original[i] = t;
            times[i] = toMinutes(t);
        }

        String queryStr = sc.nextLine().trim();
        int query = toMinutes(queryStr);

        int idx = upperBound(times, query);
        if (idx == n) {
            System.out.println("No bike");
        } else {
            System.out.println(original[idx]);
        }
    }

    // 時間轉分鐘
    private static int toMinutes(String s) {
        String[] parts = s.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }

    // 找到第一個 > target 的索引
    private static int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length; // [l, r)
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
