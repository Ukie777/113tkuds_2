class LC34_SearchRange_DelaySpan {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }
        int last = lowerBound(nums, target + 1) - 1;
        return new int[]{first, last};
    }

    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        LC34_SearchRange_DelaySpan sol = new LC34_SearchRange_DelaySpan();
        int[] nums = {5,7,7,8,8,10};
        int[] res = sol.searchRange(nums, 8);
        System.out.println(res[0] + " " + res[1]); // 3 4
    }
}
