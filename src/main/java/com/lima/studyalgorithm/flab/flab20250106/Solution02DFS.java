package com.lima.studyalgorithm.flab.flab20250106;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/possible-bipartition/description/
n(1부터 n까지)명의 사람이 있는 그룹을 두 개의 임의의 그룹으로 나누려고 합니다. 각각의 사람은 특정 사람을 싫어할 수 있으며 그 둘은 같은 그룹에 있지 않아야합니다.
정수 n과 배열 dislikes(dislikes[i] = [ai, bi] - ai와 bi는 서로 싫어함)가 주어질 때, 모든 사람을 룰에 따라 두 개의 그룹으로 나눌 수 있으면 true 그렇지 않으면 false를 리턴하세요.
예제 1:
입력: n = 4, dislikes = [[1, 2], [1, 3], [2, 4]]
출력: true
설명: 그룹 1, 4와 그룹 2, 3으로 나눌 수 있습니다.
예제 2:
입력: n = 3, dislikes = [[1, 2], [1, 3], [2, 3]]
출력: false
예제 3:
입력: n = 5, dislikes = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]]
출력: false
제약사항:
1 <= n <= 2000
0 <= dislikes.length <= 10^4
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
ai < bi
dislikes의 값들은 유일합니다
구현할 method:
public boolean possibleBipartition(int n, int[][] dislikes) {
// implementation
	}

 */
public class Solution02DFS {

  public boolean possibleBipartition(int n, int[][] dislikes) {
    List<Integer>[] graph = new List[n + 1];

    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] dislike : dislikes) {
      graph[dislike[0]].add(dislike[1]);
      graph[dislike[1]].add(dislike[0]);
    }

    Integer[] colors = new Integer[n + 1];

    for (int i = 1; i <= n; i++) {
      if (colors[i] == null && !dfs(graph, colors, i, 1)) {
        return false;
      }
    }

    return true;
  }

  private boolean dfs(List<Integer>[] graph, Integer[] colors, int currNode, int currColor) {
    colors[currNode] = currColor;

    for (Integer adjacentNode  : graph[currNode]) {
      if (colors[adjacentNode ] == null) {
        if (!dfs(graph, colors, adjacentNode , currColor * -1)) {
          return false;
        }
      } else if (colors[adjacentNode ] == currColor) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    Solution02DFS solution02DFS = new Solution02DFS();
    int n = 10;
    int[][] dislikes = {{1, 2}, {3, 4}, {5, 6}, {6, 7}, {8, 9}, {7, 8}};

    System.out.println(solution02DFS.possibleBipartition(n, dislikes));
  }
}
