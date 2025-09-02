class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 用 HashSet 儲存目前視窗內的字元
        java.util.Set<Character> set = new java.util.HashSet<>();

        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            // 如果重複，移動左指標直到移除掉重複的字元
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // 加入當前字元，更新最大長度
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}
