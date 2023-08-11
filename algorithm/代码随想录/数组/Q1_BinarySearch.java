/**
 * 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 例子：
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class Q1_BinarySearch {

    // 方式一：区间选择左闭右闭——循环条件为 left <= right
    public int binarySearchOne(int[] nums, int target) {
        // 排除边界条件：target < nums[0] || target > nums[nums.length - 1]
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        // 左右指针
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = ((right - left) >> 1) + left;  // 移位运算符优先级低于加减运算符
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;  // 注意：这里要加1，因为是闭区间
            } else {
                right = middle - 1;  // 注意：这里要减1，同上
            }
        }
        return -1;
    }

    // 方式二：区间选择左开右开——循环条件为 left < right
    public int binarySearchTwo (int[] nums, int target) {
        // 排除边界条件：target < nums[0] || target > nums[nums.length - 1]
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        // 左右指针
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = ((right - left) >> 1) + left;  // 移位运算符优先级低于加减运算符
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;  // 注意：这里要加1，因为是闭区间
            } else {
                right = middle;  // 注意：这里不用减1，因为是开区间
            }
        }
        return -1;
    }

    // test.
    public static void main(String[] args) {
        Q1_BinarySearch q1_binarySearch = new Q1_BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(q1_binarySearch.binarySearchOne(nums, target));
        System.out.println(q1_binarySearch.binarySearchTwo(nums, target));
    }
}

