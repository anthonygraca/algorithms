#ifndef LEETCODE_MEDIUM_GRAPHS_417_PACIFIC_ATLANTIC_WATER_FLOW_H_
#define LEETCODE_MEDIUM_GRAPHS_417_PACIFIC_ATLANTIC_WATER_FLOW_H_

#include <vector>

namespace leetcode {
class Solution {
public:
  std::vector<std::vector<int>>
      pacificAtlantic(std::vector<std::vector<int>>& heights) {
    int n = heights.size();
    int m = heights[0].size();
    reach_pacific = std::vector<std::vector<bool>>(n, std::vector<bool>(m, false));
    reach_atlantic = std::vector<std::vector<bool>>(n, std::vector<bool>(m, false));
    // dfs on pacific side from left and atlantic side from right
    for (int i = 0; i < n; i++) {
      dfs(heights, reach_pacific, i, 0);
      dfs(heights, reach_atlantic, i, m-1);
    }
    // dfs on pacific side from top and atlantic side from bottom
    for (int j = 0; j < m; j++) {
      dfs(heights, reach_pacific, 0, j);
      dfs(heights, reach_atlantic, n-1, j);
    }
    std::vector<std::vector<int>> coord;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (reach_pacific[i][j] && reach_atlantic[i][j]) {
          coord.push_back({i, j});
        }
      }
    }
    return coord;
  }
  void dfs(std::vector<std::vector<int>>& heights,
           std::vector<std::vector<bool>>& visited, int i, int j) {
    if (!visited[i][j]) {
      visited[i][j] = true;
      if (i > 0 && doesFlowUp(heights, i, j)) {
        dfs(heights, visited, i-1, j);
      }
      if (i < heights.size() -1 && doesFlowDown(heights, i, j)) {
        dfs(heights, visited, i+1, j);
      }
      if (j > 0 && doesFlowLeft(heights, i, j)) {
        dfs(heights, visited, i, j-1);
      }
      if (j < heights[0].size() -1 && doesFlowRight(heights, i, j)) {
        dfs(heights, visited, i, j+1);
      }
    }
  }
  
  bool doesFlowDown(std::vector<std::vector<int>>& heights, int i, int j) {
    return heights[i][j] <= heights[i+1][j];
  }
  bool doesFlowUp(std::vector<std::vector<int>>& heights, int i, int j) {
    return heights[i][j] <= heights[i-1][j];
  }
  bool doesFlowLeft(std::vector<std::vector<int>>& heights, int i, int j) {
    return heights[i][j] <= heights[i][j-1];
  }
  bool doesFlowRight(std::vector<std::vector<int>>& heights, int i, int j) {
    return heights[i][j] <= heights[i][j+1];
  }
private:
  std::vector<std::vector<bool>> reach_pacific;
  std::vector<std::vector<bool>> reach_atlantic;
};
} // namespace leetcode
#endif
