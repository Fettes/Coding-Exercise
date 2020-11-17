/*
动态规划
状态转移方程（转换方程，转移方法）

f(100), f(3)

f(100) <- f(3)

f(n) = f(n - 1) + f(n - 2)

背包问题
holding: 5kg
diamond：500g, $200

重复子问题
f(n) = f(n - 1) + f(n - 2)

解决动态规划问题的核心：找出子问题及其子问题与原问题的关系

找到了子问题以及子问题与原问题的关系，就可以递归地求解子问题了。
但重叠的子问题使得直接递归会有很多重复计算，
于是就想到记忆化递归法：若能事先确定子问题的范围就可以建表存储子问题的答案。

动态规划算法中关于最优子结构和重复子问题的理解的关键点：

证明问题的方案中包含一种选择，选择之后留下一个或多个子问题
设计子问题的递归描述方式
证明对原问题的最优解包括了对所有子问题的最优解
证明子问题是重叠的（这一步不是动态规划正确性必需的，但是如果子问题无重叠，则效率与一般递归是相同的）

*/

/*
300. 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
*/

/*
将问题规模减小的方式有很多种，
一些典型的减小方式是动态规划分类的依据，例如线性，区间，树形等。这里考虑数组上常用的两种思路：

1.每次减少一半。 [10,9,2,5]-[3,7,101,18]-->[2,3,7,101]
2.每次减少一个。规定 f(n) 为以第N个数结尾的最长子序列。f(n) -> f(n - 1), f(n - 2),... f(1)

f(7):[10, 9, 2, 5, 3, 7, 101] -> [2, 5, 7, 101]
f(6):[10, 9, 2, 5, 3, 7] -> [2, 5, 7]
[10, 9, 2, 5, 3] -> [2, 3]
[10, 9, 2, 5] -> [2, 5]
[10, 9, 2] -> [2]
[10, 9] -> [9]
[10] -> [10]

f(n) = maxf(i) + 1 (i < n && a[i] < a[n])
*/


class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            //
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}


/*
198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。
每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

 

示例 1：
输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2：
输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

提示：
0 <= nums.length <= 100
0 <= nums[i] <= 400

f(n) = Math.max(f(n-1),f(n-2)+nums[n-1])

*/

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }
        if (nums.length == 1) { 
            return nums[0]; 
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];    
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] curr = new int[nums.length + 1];
        curr[0] = 0;
        curr[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            curr[i] = Math.max(curr[i - 1], curr[i - 2] + nums[i - 1]);
        }
        return curr[nums.length];
    }
}


/*213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

 

示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：

输入：nums = [0]
输出：0
*/

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }
        if (nums.length == 1) { 
            return nums[0]; 
        }
        if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(rob1(nums1), rob1(nums2));
    }
    
    public int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]); //[0,0]
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];    
    }
}

/*
337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

输出: 7 
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = helper(root);
        
        //0表示不偷
        //1表示偷
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode root) {
        if (root == null) {
            int[] temp = {0, 0};
            return temp;
        }

        int[] result = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}