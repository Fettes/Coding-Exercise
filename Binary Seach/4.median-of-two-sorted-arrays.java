/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        //should keep the second array longer to make a postive partition Y
        if (x > y) return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = x; 
        double result = 0;

        while (low <= high) {
            int partX = (low + high) / 2;
            int partY = (x + y + 1) / 2 - partX;
            // corner cases
            int xLeft = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int xRight = partX == x ? Integer.MAX_VALUE : nums1[partX];
            int yRight = partY == y ? Integer.MAX_VALUE : nums2[partY];

            //medium found
            if (xLeft <= yRight && yLeft <= xRight) {
                if ((x + y) % 2 == 0) {
                    result = (double) (Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2; 
                } else {
                    result = Math.max(xLeft, yLeft);
                }
                return result;
            } else if (yLeft > xRight) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }

        }
        return result;
    }
}
// @lc code=end

