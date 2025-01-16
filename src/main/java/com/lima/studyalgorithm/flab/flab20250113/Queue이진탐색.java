package com.lima.studyalgorithm.flab.flab20250113;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Queue이진탐색 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currLevel = new ArrayList<>();

    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();

      if (currentNode == null) {
        result.add(currLevel);
        currLevel = new ArrayList<>();
        if (queue.isEmpty()) {
          break;
        }
        queue.add(null);
      } else {
        currLevel.add(currentNode.val);
        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Queue이진탐색 queue이진탐색 = new Queue이진탐색();
    TreeNode treeNode = new TreeNode();
    // [3,9,20,null,null,15,7]
    treeNode.val = 3;
    treeNode.left = new TreeNode(9);
    treeNode.right = new TreeNode(20);
    treeNode.right.left = new TreeNode(15);
    treeNode.right.right = new TreeNode(7);

    System.out.println(queue이진탐색.levelOrder(treeNode));
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
