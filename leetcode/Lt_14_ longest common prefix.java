class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // 將第一個字串當作初始前綴
        String prefix = strs[0];
        
        // 逐一與其他字串比對
        for (int i = 1; i < strs.length; i++) {
            // 找出 prefix 與 strs[i] 的共同部分
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        
        return prefix;
    }
}
