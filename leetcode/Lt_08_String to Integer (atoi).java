class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0, n = s.length();
        // 忽略前導空白
        while (i < n && s.charAt(i) == ' ') i++;

        // 判斷符號
        int sign = 1;
        if (i < n) {
            if (s.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }
        }

        int result = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break; // 遇到非數字就停

            int digit = c - '0';

            // 檢查溢位
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
