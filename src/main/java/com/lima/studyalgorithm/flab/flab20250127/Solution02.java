package com.lima.studyalgorithm.flab.flab20250127;

import java.sql.SQLOutput;

// https://leetcode.com/problems/top-k-frequent-elements/description/
public class Solution02 {
  public int[] topKFrequent(int[] nums, int k) {
    return null;
  }

  public static void main(String[] args) {
//    int[] nums = {1,1,1,2,2,3};
    int[] nums = {1};
    int k = 1;

    Solution02 solution02 = new Solution02();
    int[] ints = solution02.topKFrequent(nums, k);
    for (int anInt : ints) {
      System.out.println(anInt);
    }
  }
}
