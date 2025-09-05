import java.util.*;

public class LC04_Median_QuakeFeeds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        double[] A = new double[n];
        double[] B = new double[m];
        
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextDouble();
        }
        for (int j = 0; j < m; j++) {
            B[j] = sc.nextDouble();
        }
        
        System.out.printf("%.1f\n", findMedian(A, B));
    }
    
    private static double findMedian(double[] A, double[] B) {
        // 確保 A 是比較短的陣列
        if (A.length > B.length) {
            return findMedian(B, A);
        }
        
        int n = A.length;
        int m = B.length;
        int totalLeft = (n + m + 1) / 2; // 左半邊元素數量
        
        int left = 0, right = n; // binary search 在 A 上
        while (left <= right) {
            int i = (left + right) / 2;   // A 的切點
            int j = totalLeft - i;        // B 的切點
            
            // A 左右邊界
            double Aleft  = (i == 0) ? Double.NEGATIVE_INFINITY : A[i - 1];
            double Aright = (i == n) ? Double.POSITIVE_INFINITY : A[i];
            // B 左右邊界
            double Bleft  = (j == 0) ? Double.NEGATIVE_INFINITY : B[j - 1];
            double Bright = (j == m) ? Double.POSITIVE_INFINITY : B[j];
            
            if (Aleft <= Bright && Bleft <= Aright) {
                // 找到合法切割
                if ((n + m) % 2 == 1) {
                    return Math.max(Aleft, Bleft); // 奇數，取左邊最大
                } else {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
            } else if (Aleft > Bright) {
                right = i - 1; // A 切太多，往左縮
            } else {
                left = i + 1;  // A 切太少，往右擴
            }
        }
        return -1; // 理論不會到這裡
    }
}
