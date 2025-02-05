package com.lima.studyalgorithm.flab.flab20250127;

// https://leetcode.com/problems/word-search/description/
// m == board.length, n = board[i].length
// 1 <= m, n <= 6, 1 <= word.length <= 15
// board and word consists of only lowercase English letters.
public class Solution01 {

  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;

    // 모든 셀에서 시작해서 단어를 찾는다.
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (dfs(board, word, row, col, 0)) {
          return true; // 단어를 찾으면 true
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, String word, int row, int col, int index) {
    // 1. 조건 확인: 단어를 다 찾았는지 확인
    if (index == word.length()) {
      return true;
    }

    // 2. 범위를 벗어나거나, 현재 셀이 단어의 현재 문자와 다르다면 false
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
      return false;
    }

    // 3. 현재 셀을 사용 중임을 표기 (방문 처리)
    char temp = board[row][col];
    board[row][col] = '#'; // 사용한 셀은 #로 표시

    // 4. 상하좌우로 탐색
    boolean found = dfs(board, word, row + 1, col, index + 1) ||  // 아래
                    dfs(board, word, row - 1, col, index + 1) ||  // 위
                    dfs(board, word, row, col + 1, index + 1) ||  // 오른 쪽
                    dfs(board, word, row, col - 1, index + 1);    // 왼쪽

    board[row][col] = temp;

    return found;
  }

  public static void main(String[] args) {
    char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    char[][] board2 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

    String word1 = "ABCCED";
    String word2 = "SEE";

    Solution01 solution01 = new Solution01();
//    System.out.println("expected: true, result: " + solution01.exist(board1, word1));
    System.out.println("expected: true, result: " + solution01.exist(board2, word2));
  }
}
