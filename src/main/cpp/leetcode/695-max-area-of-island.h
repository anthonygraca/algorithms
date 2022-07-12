#ifndef LEETCODE_MEDIUM_GRAPHS_695_MAX_AREA_OF_ISLAND_H_
#define LEETCODE_MEDIUM_GRAPHS_695_MAX_AREA_OF_ISLAND_H_

#include <vector>

namespace leetcode {
class Solution {
public:
 int maxAreaOfIsland(std::vector<std::vector<int>>& grid) {
    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid[0].size(); j++) {
        if (grid[i][j] == 1) {
          int area = 0;
          area = dfs(grid, i, j, area);
          max_area_ = (max_area_ > area) ? max_area_ : area;
        }
      }
    }
    return max_area_;
  }
  int dfs(std::vector<std::vector<int>>& grid, int i, int j, int area) {
    if (grid[i][j] == 1) {
      grid[i][j] = 0;
      area++;
      if (i > 0) area = dfs(grid, i-1, j, area);
      if (i < grid.size() - 1) area = dfs(grid, i+1, j, area);
      if (j > 0) area = dfs(grid, i, j-1, area);
      if (j < grid[0].size() - 1) area = dfs(grid, i, j+1, area);
    }
    return area;
  }
private:
  int max_area_{0};
};
} // namespace leetcode
#endif
