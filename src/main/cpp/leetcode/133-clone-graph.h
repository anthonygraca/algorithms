#ifndef LEETCODE_MEDIUM_GRAPHS_133_CLONE_GRAPH_H_
#define LEETCODE_MEDIUM_GRAPHS_133_CLONE_GRAPH_H_

#include <unordered_map>

#include <leetcode/node.h>

namespace leetcode {
class CloneGraph {
public:
  Node* solve(Node* node) {
    // check if we have a copy of this node. if not create a copy.
    // go to next neighbor node that we didn't make copy.
    // if we have a copy of neighbor, add to neighbors_
    if (node == nullptr) return nullptr;
    copy.insert({node, new Node(node->val_)});
    for (auto n : node->neighbors_) {
      if (copy.find(n) == copy.end()) {
        copy[node]->neighbors_.push_back(solve(n));
      }
      else {
        copy[node]->neighbors_.push_back(copy[n]);
      }
    }
    return copy[node];
  }
private:
  std::unordered_map<Node*, Node*> copy;
};
} // namespace leetcode

#endif

