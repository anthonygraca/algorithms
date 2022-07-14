#ifndef LEETCODE_MEDIUM_GRAPHS_207_COURSE_SCHEDULE_1_H_
#define LEETCODE_MEDIUM_GRAPHS_207_COURSE_SCHEDULE_1_H_

#include <vector>

namespace leetcode {
class Solution {
public:
  
  bool canFinish(int num_courses, std::vector<std::vector<int>> prereq) {
    if (num_courses == 1) return true;
    std::vector<std::vector<int>> adj(num_courses, std::vector<int>());
    marked = std::vector<bool>(num_courses, false);
    on_stack = std::vector<bool>(num_courses, false);
    for (int i = 0; i < prereq.size(); i++) {
      adj[prereq[i][1]].push_back(prereq[i][0]);
    }
    for (int i = 0; i < num_courses; i++) {
      if (!marked[i]) dfs(adj, i);
    }

    return can_finish;
  }
  void dfs(std::vector<std::vector<int>>& graph, int course) {
    marked[course] = true;
    on_stack[course] = true;
    for (int i = 0; i < graph[course].size(); i++) {
      if (!marked[graph[course][i]]) {
        dfs(graph, graph[course][i]);
      }
      else if (on_stack[graph[course][i]]) {
        can_finish = false;
      }
      else {}
    }
    on_stack[course] = false;
  }
private:
  std::vector<bool> marked;
  std::vector<bool> on_stack;
  bool can_finish{true};
  
};
} // namespace leetcode
#endif
