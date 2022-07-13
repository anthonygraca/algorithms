#ifndef LEETCODE_MEDIUM_GRAPHS_997_ROTTING_ORANGES_H_
#define LEETCODE_MEDIUM_GRAPHS_997_ROTTING_ORANGES_H_

#include <queue>
#include <vector>

namespace leetcode {
class Solution {
public:
  int orangesRotting(std::vector<std::vector<int>>& grid) {
    int n = grid.size(); int m = grid[0].size();
    
    for(int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 2) {
          q.push({i,j});
        }
      }
    }

    if (not q.empty()) {
      last = q.back();
      bfs(grid);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) return -1;
      }
    }

    return minutes == -1 ? 0 : minutes;
  }
  void bfs(std::vector<std::vector<int>>& grid) {
    while (not q.empty()) {
      auto [i, j] = q.front(); q.pop();
      if (i > 0 && grid[i-1][j] == 1) {
        q.push({i-1, j});
        grid[i-1][j] = 2;
      }
      if (i < grid.size()-1 && grid[i+1][j] == 1) {
        q.push({i+1, j});
        grid[i+1][j] = 2;
      }
      if (j > 0 && grid[i][j-1] == 1) {
        q.push({i, j-1});
        grid[i][j-1] = 2;
      }
      if (j < grid[i].size()-1 && grid[i][j+1] == 1) {
        q.push({i, j+1});
        grid[i][j+1] = 2;
      }
      if (last.first == i && last.second == j) {
        minutes++;
        last = q.back();
      }

    }
  }
private:
  std::pair<int, int> last;
  std::queue<std::pair<int, int>> q;
  int minutes{-1};
};
} // namespace leetcode
#endif

