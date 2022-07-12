#ifndef LEETCODE_GRAPH_NODE_H_
#define LEETCODE_GRAPH_NODE_H_

#include <vector>

namespace leetcode {
class Node {
public:
  int val_;
  std::vector<Node*> neighbors_;
  Node() {
    val_ = 0;
    neighbors_ = std::vector<Node*>();
  }
  Node(int val) {
    val_ = val;
    neighbors_ = std::vector<Node*>();
  }
  Node(int val, std::vector<Node*> neighbors) {
    val_ = val;
    neighbors_ = neighbors;
  }
};
} // namespace leetcode
#endif
