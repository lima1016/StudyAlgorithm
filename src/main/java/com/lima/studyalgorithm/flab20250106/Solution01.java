package com.lima.studyalgorithm.flab20250106;

/*
https://leetcode.com/problems/jump-game-ii/description/
index 0부터 시작하는 n 길이의 정수 배열 nums가 주어집니다. 당신은 nums[0]에서 시작합니다.
각 nums[i]는 해당 지점(i)에서 앞으로 점프할 수 있는 최대 길이를 나타냅니다.
즉 만약 당신이 nums[i]에 위치해 있다면, 당신은
0 <= j <= nums[i] 이며 i + j < n
인 위치로 점프할 수 있습니다. (nums[i]위치에서 최대 nums[i]의 값만큼 점프할 수 있음)
nums[n - 1]에 도달하기 위한 최소 점프 수를 리턴하세요. 테스트 케이스는 항상 nums[n - 1]에 도달할 수 있도록 주어집니다.
예제 1:
입력: nums = [2, 3, 1, 1, 4]
출력: 2
설명: 2번 점프하여 n - 1에 도달할 수 있습니다. 첫 점프는 index 0(값 2)에서 1로 이동하고, 그 다음 점프는 index 1(값 3)에서 4로 점프할 수 있습니다.

예제 2:
입력: nums = [2, 3, 0, 1, 4]
출력: 2
제약사항:
1 <= nums.length <= 10^4
0 <= nums[i] <= 1000
구현할 method:
public int jump(int[] nums) {
	// implementation
}
 */
public class Solution01 {

  // TODO: Test case 42번에서 막힌 상태
  public int jump(int[] nums) {
    int endIndex = nums.length - 1;
    int endValue = nums[endIndex];
    int count = 0;

    if (nums.length != 1) {
      for (int i = 0; i < nums.length - 1; i++) {
        int start = nums[i];
        int jumpIndex = i + start;

        count++;
        if (jumpIndex < nums.length) {
          if (nums[jumpIndex] == endValue && jumpIndex == endIndex) {
            break;
          }
        } else {
          break;
        }
      }
    }
    // 최종 결과는 i + nums[i] 값이 nums[n-1] 값이여야함
    return count;
  }

  public static void main(String[] args) {
    Solution01 solution01 = new Solution01();
    // nums[index]는 앞으로 점프할 수 있는 최대 길이
//    int[] nums1 = {2, 1};
//    System.out.println("expected: 1, result: " + solution01.jump(nums1));
//    int[] nums2 = {0};
//    System.out.println("expected: 0, result: " + solution01.jump(nums2));
//    int[] nums3 = {2, 3, 0, 1, 4};
//    System.out.println("expected: 2, result: " + solution01.jump(nums3));
//    int[] nums4 = {2, 3, 1, 1, 4};
//    System.out.println("expected: 2, result: " + solution01.jump(nums4));
//    int[] nums5 = {3,2,1};
//    System.out.println("expected: 1, result: " + solution01.jump(nums5));
//    int[] nums6 = {1, 1, 1, 1};
//    System.out.println("expected: 3, result: " + solution01.jump(nums6));
//    int[] nums7 = {1,2,3};
//    System.out.println("expected: 2, result: " + solution01.jump(nums7));
    int[] nums8 = {1,2,1,1,1};
    System.out.println("expected: 3, result: " + solution01.jump(nums8));
  }
}