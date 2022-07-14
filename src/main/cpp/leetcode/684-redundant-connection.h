#ifndef LEETCODE_MEDIUM_GRAPHS_684_REDUNDANT_CONNECTION_H_
#define LEETCODE_MEDIUM_GRAPHS_684_REDUNDANT_CONNECTION_H_

#include <vector>

namespace leetcode {
class Solution {
public:
  
  std::vector<int> findRedundantConnection(std::vector<std::vector<int>>& edges) {
    for (int i = 0; i < edges.size()+1; i++) {
      components.push_back(i);
    }
    for (int i = 0; i < edges.size(); i++) {
      int v = edges[i][0];
      int w = edges[i][1];
      if (connect(v, w)) {
        return {v, w};
      }
    }
    return {};
  }
  int find(int n) {
    while (n != components[n]) n = components[n];
    return n;
  }
  bool connect(int v, int w) {
    int i = find(v);
    int j = find(w);
    if (i == j) return true;
    components[i] = find(w);
    return false;
  }
private:
  std::vector<int> components;
  
};
} // namespace leetcode

#endif
