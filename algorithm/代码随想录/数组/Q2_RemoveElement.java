/**
 * 移除元素：
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 */

public class Q2_RemoveElement {

    // 暴力的解法就是两层for循环，一个for循环遍历数组元素 ，第二个for循环更新数组。

    // 双指针法：快慢指针——
    // 快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
    // 慢指针：指向更新 新数组下标的位置
    public int removeElementMethodOne(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    // 双指针法：左右相向指针——基于元素顺序可以改变的题目描述改变了元素相对位置，确保了移动最少元素
    public int removeElementMethodTwo(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }

    // test
    public static void main(String[] args) {
        Q2_RemoveElement q2_removeElement = new Q2_RemoveElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(q2_removeElement.removeElementMethodOne(nums, val));
        System.out.println(q2_removeElement.removeElementMethodTwo(nums, val));
    }
}