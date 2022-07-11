#ifndef LEETCODE_MEDIUM_GRAPHS_200_NUMBER_OF_ISLANDS_H_
#define LEETCODE_MEDIUM_GRAPHS_200_NUMBER_OF_ISLANDS_H_

/*
  Given an m x n 2D binary grid grid which represents a map of '1's (land) and
  '0's (water), return the number of islands.

  An island is surrounded by water and is formed by connecting adjacent lands
  horiznontally or vertically. You may assume all four edges of the grid are all
  surrounded by water.
*/

#include <vector>
namespace leetcode {
class NumberOfIslands {
public:
  int solve(std::vector<std::vector<char>>& grid) {
    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid[0].size(); j++) {
        if (grid[i][j] == '1') {
          islands_++;
          dfs(grid, i, j);
        }
      }
    }
    return islands_;
  }
  void dfs(std::vector<std::vector<char>>& grid, int i, int j) {
    if (grid[i][j] == '1') {
      grid[i][j] = '0';
      if (i > 0) dfs(grid, i - 1, j);
      if (i < grid.size()-1) dfs(grid, i + 1, j);
      if (j > 0) dfs(grid, i, j - 1);
      if (j < grid[i].size() - 1) dfs(grid, i, j + 1);
    }
    
  }
private:
  int islands_{0};
  
};
} //namespace leetcode

#endif
