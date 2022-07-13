#ifndef LEETCODE_MEDIUM_GRAPHS_130_SURROUNDED_REGIONS_H_
#define LEETCODE_MEDIUM_GRAPHS_130_SURROUNDED_REGIONS_H_

#include <vector>

namespace leetcode {
class Solution {
 public:
  
  void solve(std::vector<std::vector<char>>& board) {
    int n = board.size(), m = board[0].size();
    visited = std::vector<std::vector<bool>>(n, std::vector<bool>(m, false));

    // traverse on left and right border
    for (int i = 0; i < n; i++) {
      if (!visited[i][0] && board[i][0] == 'O') dfs(board, i, 0);
      if (!visited[i][m-1] && board[i][m-1] == 'O') dfs(board, i, m-1);
    }

    // traverse on top and bottom border
    for (int j = 0; j < m; j++) {
      if (!visited[0][j] && board[0][j] == 'O') dfs(board, 0, j);
      if (!visited[n-1][j] && board[n-1][j] == 'O') dfs(board, n-1, j);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j]) {
          board[i][j] = 'X';
        }
      }
    }
  }
  void dfs(std::vector<std::vector<char>>& board, int i, int j) {
    if (!visited[i][j]) {
      visited[i][j] = true;
      // up
      if (i > 0 && board[i-1][j] == 'O') {
        dfs(board, i - 1, j);
      }
      // down
      if (i < board.size() - 1 && board[i+1][j] == 'O') {
        dfs(board, i + 1, j);
      }
      // left
      if (j > 0 && board[i][j-1] == 'O') {
        dfs(board, i, j-1);
      }
      // right
      if (j < board[0].size() - 1 && board[i][j+1] == 'O') {
        dfs(board, i, j+1);
      }
    }
  }
 private:
  std::vector<std::vector<bool>> visited;
  
};
} // namespace leetcode

#endif
