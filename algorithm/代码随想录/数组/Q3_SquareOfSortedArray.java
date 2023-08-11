/**
 * 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Q3_SquareOfSortedArray {

    // 双指针：排序数组，考虑到负数的存在会使得平方后的数组存在相对位置的变化，所以需要双指针来对比首尾元素的平方值的大小
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }

    // test
    public static void main(String[] args) {
        Q3_SquareOfSortedArray q3_squareOfSortedArray = new Q3_SquareOfSortedArray();
        int[] nums = {-4,-1,0,3,10};
        int[] result = q3_squareOfSortedArray.sortedSquares(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}