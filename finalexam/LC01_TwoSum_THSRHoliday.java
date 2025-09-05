import java.util.*;

public class LC01_TwoSum_THSRHoliday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }
        
        int[] result = twoSum(seats, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            // 如果有人在等 x，就找到解答
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            // 記錄還需要的數字 target - x
            map.put(target - x, i);
        }
        return new int[]{-1, -1}; // 找不到
    }
}
