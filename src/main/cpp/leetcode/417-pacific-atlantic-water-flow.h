#ifndef LEETCODE_MEDIUM_GRAPHS_417_PACIFIC_ATLANTIC_WATER_FLOW_H_
#define LEETCODE_MEDIUM_GRAPHS_417_PACIFIC_ATLANTIC_WATER_FLOW_H_

#include <vector>

namespace leetcode {
class Solution {
public:

  std::vector<std::vector<bool>> initializeArray(
      std::vector<std::vector<int>>& heights) {
    std::vector<std::vector<bool>> output;
    for (int i = 0; i < heights.size(); i++) {
      output.push_back(std::vector(heights[i].size(), false));
    }
    return output;
  }
  std::vector<std::vector<int>>
      pacificAtlantic(std::vector<std::vector<int>>& heights) {

    reach_pacific = initializeArray(heights);
    reach_atlantic = initializeArray(heights);
    marked = initializeArray(heights);
        // initialize default tiles that are reachable
    for (int i = 0; i < heights.size(); i++) {
      for (int j = 0; j < heights[i].size(); j++) {
        if (i == 0 || j == 0) {
          reach_pacific[i][j] = true;
        }
        if (i == heights.size() - 1 || j == heights[i].size()-1) {
          reach_atlantic[i][j] = true;
        }
          
      }
    }
    // dfs on pacific side
    for (int i = 0; i < heights.size(); i++) {
      for (int j = 0; j < heights[0].size(); j++) {
        if (!marked[i][j] && reach_pacific[i][j]) {
          dfs(heights, reach_pacific, i, j);
        }

      }
    }
    marked = initializeArray(heights);
    // dfs on atlantic side
    for (int i = heights.size() - 1; i >= 0; i--) {
      for (int j = heights[0].size() - 1; j >= 0; j--) {
        if (!marked[i][j] && reach_atlantic[i][j])
          dfs(heights, reach_atlantic, i, j);
      }
    }
    // find intersection of two sides
    std::vector<std::vector<int>> coord;
    for (int i = 0; i < heights.size(); i++) {
      for (int j = 0; j < heights[0].size(); j++) {
        if (reach_pacific[i][j] && reach_atlantic[i][j]) {
          coord.push_back({i, j});
        }
      }
    }
    return coord;
  }
  void dfs(std::vector<std::vector<int>>& heights,
           std::vector<std::vector<bool>>& reach, int i, int j) {
    if (!marked[i][j] && reach[i][j]) {
      marked[i][j] = true;
      if (i > 0 && doesFlowUp(heights, i, j) && !reach[i-1][j]) {
        reach[i-1][j] = true;
        dfs(heights, reach, i-1, j);
      }
      if (i < heights.size() -1 && doesFlowDown(heights, i, j) && !reach[i+1][j]) {
        reach[i+1][j] = true;
        dfs(heights, reach, i+1, j);
      }
      if (j > 0 && doesFlowLeft(heights, i, j) && !reach[i][j-1]) {
        reach[i][j-1] = true;
        dfs(heights, reach, i, j-1);
      }
      if (j < heights[0].size() -1 && doesFlowRight(heights, i, j) && !reach[i][j+1]) {
        reach[i][j+1] = true;
        dfs(heights, reach, i, j+1);
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
  std::vector<std::vector<bool>> marked;
};
} // namespace leetcode
#endif
