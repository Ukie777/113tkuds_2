class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            maxArea = Math.max(maxArea, area);

            // 移動較小的那邊
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
