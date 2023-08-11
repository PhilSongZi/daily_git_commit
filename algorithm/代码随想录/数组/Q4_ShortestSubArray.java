/**
 * 题目：长度最小的子数组。LeetCode 209
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 提示：
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class Q4_ShortestSubArray {

    // 双层for循环：暴力解法。复杂度：O(n^2)

    // 双指针：滑动窗口。复杂度：O(n)。——要注意的三点：窗口内是什么？如何移动窗口的起始位置？如何移动窗口的结束位置？
    // 滑动窗口的精妙之处在于根据当前子序列和大小的情况，不断调节子序列的起始位置。从而将O(n^2)暴力解法降为O(n)。
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        // 这个循环的索引，一定是表示 滑动窗口的终止位置。
        // 同时，考虑到可能存在相同的元素，所以选择while循环
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //test
    public static void main(String[] args) {
        Q4_ShortestSubArray q4_shortestSubArray = new Q4_ShortestSubArray();
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        System.out.println(q4_shortestSubArray.minSubArrayLen(s, nums));
    }
}