#ifndef LEETCODE_MEDIUM_GRAPHS_210_COURSE_SCHEDULE_2_H_
#define LEETCODE_MEDIUM_GRAPHS_210_COURSE_SCHEDULE_2_H_

#include <vector>
#include <stack>

namespace leetcode {
class Solution {
public:
  
  std::vector<int> findOrder(int num_courses, std::vector<std::vector<int>>& prereq) {
    adj = std::vector<std::vector<int>>(num_courses, std::vector<int>());
    marked = std::vector<bool>(num_courses, false);
    on_stack = std::vector<bool>(num_courses, false);
    for(int i = 0; i < prereq.size(); i++) {
      adj[prereq[i][1]].push_back(prereq[i][0]);
    }

    for (int i = 0; i < num_courses; i++) {
      if (!marked[i]) dfs(adj, i);
    }

    if (has_cycle) return std::vector<int>();

    std::vector<int> order;
    while (not topological.empty()) {
      order.push_back(topological.top());
      topological.pop();
    }
    return order;
  }
  void dfs(std::vector<std::vector<int>>& adj, int course) {
    marked[course] = true;
    on_stack[course] = true;
    for (int i = 0; i < adj[course].size(); i++) {
      if (!marked[adj[course][i]]) dfs(adj, adj[course][i]);
      else if(on_stack[adj[course][i]]) has_cycle = true;
      else {}
    }
    topological.push(course);
    on_stack[course] = false;
  }

private:
  std::vector<std::vector<int>> adj;
  std::vector<bool> marked;
  std::vector<bool> on_stack;
  std::stack<int> topological;
  bool has_cycle{false};

};
} // namespace leetcode
#endif
