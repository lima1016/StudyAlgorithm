package com.lima.studyalgorithm.flab.flab20250106;

import java.util.Arrays;

/*
https://leetcode.com/problems/first-missing-positive/description/
정렬되지 않은 배열 nums가 주어졌을 때, 정수 양수 중 배열에 포함되어있지 않은 최소 숫자를 리턴하세요.
알고리즘은 반드시 O(n)의 시간복잡도를 가져야하며 constant 공간을 추가로 사용해야합니다.
예제 1:
입력: nums = [1, 2, 0]
출력: 3
예제 2:
입력: nums = [3, 4, -1, 1]
출력: 2
예제 3:
입력: nums = [7, 8, 9, 11, 12]
출력: 1
예제 4:
입력: nums = [5, 2, 3, 7, 6, 4, 1, 9]
출력: 8
제약사항:
1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
구현할 method:
public int firstMissingPositive(int[] nums) {
	// implementation
}
 */
public class Solution03 {

//  public int firstMissingPositive(int[] nums) {
//    int[] filteredNums = Arrays.stream(nums).filter(n -> n > 0).toArray();
//
//    Arrays.sort(filteredNums);
//
//    int target = 1;
//    for (int n : filteredNums) {
//      if (n == target) {
//        target++;
//      } else if (n > target) {
//        return target;
//      }
//    }
//
//    return target;
//  }

  // Function to swap elements in the array
  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    // Place each positive integer i at index i-1 if possible
    for (int i = 0; i < n; i++) {           // 자기 자리인지확인 값 = 인덱스-1 (본인자리임)
      while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      }
    }

    // Find the first missing positive integer
    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }

    // If all positive integers from 1 to n are present, return n + 1
    return n + 1;
  }

  public static void main(String[] args) {
    Solution03 solution03 = new Solution03();
    int[] nums = {3,3333,8,1, 2, 4, 5, 555555, 99};
    System.out.println(solution03.firstMissingPositive(nums));
  }
}
