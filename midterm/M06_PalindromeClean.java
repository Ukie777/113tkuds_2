
import java.util.*;

public class M06_PalindromeClean {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (isPalindrome(s)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // 找到左邊下一個字母
            while (left < right && !Character.isLetter(s.charAt(left))) {
                left++;
            }
            // 找到右邊上一個字母
            while (left < right && !Character.isLetter(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                char c1 = Character.toLowerCase(s.charAt(left));
                char c2 = Character.toLowerCase(s.charAt(right));
                if (c1 != c2) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
