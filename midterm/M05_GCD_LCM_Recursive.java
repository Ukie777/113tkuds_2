
import java.util.*;

public class M05_GCD_LCM_Recursive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        long g = gcd(a, b);
        long l = (a / g) * b; // 避免溢位，先除後乘

        System.out.println("GCD: " + g);
        System.out.println("LCM: " + l);
    }

    // 遞迴歐幾里得算法
    private static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
