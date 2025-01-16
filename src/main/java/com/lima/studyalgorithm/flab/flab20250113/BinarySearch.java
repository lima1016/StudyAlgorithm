package com.lima.studyalgorithm.flab.flab20250113;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/description/
public class BinarySearch {

  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int[] dp = new int[nums.length];
    int length= 0;
    for (int num : nums) {
      int i = Arrays.binarySearch(dp, 0, length, num);
      if (i < 0) {
        i = -(i + 1);
      }
      dp[i] = num;

      if (i == length) {
        length++;
      }
    }

    return length;
  }

  public static void main(String[] args) {
    BinarySearch binarySearch = new BinarySearch();
    int[] nums = {10,9,2,5,3,7,101,18};
    System.out.println("extected: 4, result:" + binarySearch.lengthOfLIS(nums));
    int[] nums1 = {4,10,4,3,8,9};
    System.out.println("extected: 3, result:" + binarySearch.lengthOfLIS(nums1));
    int[] nums2 = {1,3,6,7,9,4,10,5,6};
    System.out.println("extected: 6, result:" + binarySearch.lengthOfLIS(nums2));
  }
}
