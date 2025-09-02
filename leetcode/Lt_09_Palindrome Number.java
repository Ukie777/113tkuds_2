class Solution {
    public boolean isPalindrome(int x) {
         負數或末位為0但不是0本身都不是回文
        if (x  0  (x % 10 == 0 && x != 0)) return false;

        int revertedNumber = 0;
        while (x  revertedNumber) {
            int pop = x % 10;
            x = 10;
            revertedNumber = revertedNumber  10 + pop;
        }

         偶數位數：x == revertedNumber
         奇數位數：x == revertedNumber  10
        return x == revertedNumber  x == revertedNumber  10;
    }
}
