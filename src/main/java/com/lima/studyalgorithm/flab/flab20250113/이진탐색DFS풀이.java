package com.lima.studyalgorithm.flab.flab20250113;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 이진탐색DFS풀이 {

  // DFS 로 푼 엄청난 분...
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    levelHelper(res, root, 0);
    return res;
  }

  public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
    if (root == null) return;
    if (height >= res.size()) {
      res.add(new LinkedList<Integer>());
    }
    res.get(height).add(root.val);
    levelHelper(res, root.left, height+1);
    levelHelper(res, root.right, height+1);
  }

  public static void main(String[] args) {
    이진탐색DFS풀이 solution01 = new 이진탐색DFS풀이();
    TreeNode treeNode = new TreeNode();
    // [3,9,20,null,null,15,7]
    treeNode.val = 3;
    treeNode.left = new TreeNode(9);
    treeNode.right = new TreeNode(20);
    treeNode.right.left = new TreeNode(15);
    treeNode.right.right = new TreeNode(7);

    System.out.println(solution01.levelOrder(treeNode));
  }

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
