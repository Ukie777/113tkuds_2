class LC33_SearchRotated_RentHot {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;

            // 左半有序
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // 右半有序
            else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LC33_SearchRotated_RentHot sol = new LC33_SearchRotated_RentHot();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(sol.search(nums, 0)); // 4
        System.out.println(sol.search(nums, 3)); // -1
    }
}
