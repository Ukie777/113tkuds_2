
import java.util.*;

/**
 * M04_TieredTaxSimple
 *
 * 題目：簡化級距稅試算
 *
 * 解法： - 依據題目給的稅率級距，對每筆收入逐段計算稅額。 - 將所有人的稅額輸出，並累加後計算平均稅額。
 *
 * 複雜度分析： - 每筆收入最多經過 4 個級距計算 → O(1)。 - 總共有 n 筆輸入 → O(n)。 - 空間僅存放 n 筆輸入與總和 → O(n)
 * 或可邊算邊輸出降為 O(1)。
 */
public class M04_TieredTaxSimple {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long totalTax = 0; // 用 long 防止溢位

        for (int i = 0; i < n; i++) {
            long income = sc.nextLong();
            long tax = computeTax(income);
            System.out.println("Tax: " + tax);
            totalTax += tax;
        }

        System.out.println("Average: " + (totalTax / n));
    }

    // 計算單筆收入稅額
    private static long computeTax(long income) {
        long tax = 0;

        if (income <= 120000) {
            tax = (long) (income * 0.05);
        } else if (income <= 500000) {
            tax = (long) (120000 * 0.05 + (income - 120000) * 0.12);
        } else if (income <= 1000000) {
            tax = (long) (120000 * 0.05 + (500000 - 120000) * 0.12
                    + (income - 500000) * 0.20);
        } else {
            tax = (long) (120000 * 0.05 + (500000 - 120000) * 0.12
                    + (1000000 - 500000) * 0.20
                    + (income - 1000000) * 0.30);
        }
        return tax;
    }
}
