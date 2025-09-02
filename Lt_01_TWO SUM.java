class Solution {
    public int[] twoSum(int[] nums, int target) {  
        // 建立一個 HashMap，用來存放「數字 -> 索引」
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

        // 遍歷整個陣列
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 計算需要的另一個數字

            // 如果 map 中已經有這個數字，代表找到答案
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // 如果沒有，將當前數字和索引存入 map
            map.put(nums[i], i);
        }

        // 題目保證一定有解，所以這行理論上不會執行
        throw new IllegalArgumentException("No two sum solution");
    }
}
