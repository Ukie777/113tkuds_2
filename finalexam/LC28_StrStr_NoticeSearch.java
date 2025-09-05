class LC28_StrStr_NoticeSearch {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        // 暴力解
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC28_StrStr_NoticeSearch sol = new LC28_StrStr_NoticeSearch();
        System.out.println(sol.strStr("hello", "ll")); // 2
        System.out.println(sol.strStr("aaaaa", "bba")); // -1
    }
}
