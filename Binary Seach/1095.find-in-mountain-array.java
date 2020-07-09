/*
 * @lc app=leetcode id=1095 lang=java
 *
 * [1095] Find in Mountain Array
 */

// @lc code=start
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        
        int mid = 0;
        int peak = 0;
        //find the index of the mountain number
        int low = 0;
        int high = size - 1;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
                peak = mid + 1;
            } else {
                high = mid;
            }
        }
        //find the target in the left subarray
        low = 0;
        high = peak;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        //find the target in the right subarray
        low = peak;
        high = size - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }
}
// @lc code=end

