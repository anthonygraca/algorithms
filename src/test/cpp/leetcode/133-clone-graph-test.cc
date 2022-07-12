#include <leetcode/133-clone-graph.h>

#include <gtest/gtest.h>

#include <leetcode/node.h>

TEST(CloneGraph, FirstExample) {
  // setup
  leetcode::Node a(1);
  leetcode::Node b(2);
  leetcode::Node c(3);
  leetcode::Node d(4);
  a.neighbors_.push_back(&b);
  a.neighbors_.push_back(&d);
  b.neighbors_.push_back(&a);
  b.neighbors_.push_back(&c);
  c.neighbors_.push_back(&b);
  c.neighbors_.push_back(&d);
  d.neighbors_.push_back(&a);
  d.neighbors_.push_back(&c);
  // exercise
  leetcode::CloneGraph solution;
  leetcode::Node* n = solution.solve(&a);
  // verify
  EXPECT_EQ(1, n->val_);
  EXPECT_TRUE(n != &a);
  EXPECT_EQ(2, n->neighbors_[0]->val_);
  EXPECT_EQ(4, n->neighbors_[1]->val_);
  EXPECT_TRUE(n->neighbors_[0] != &b);
  EXPECT_EQ(1, n->neighbors_[0]->neighbors_[0]->val_);
  EXPECT_EQ(3, n->neighbors_[0]->neighbors_[1]->val_);
  EXPECT_TRUE(n->neighbors_[0]->neighbors_[1] != &c);
  EXPECT_EQ(2, n->neighbors_[0]->neighbors_[1]->neighbors_[0]->val_);
  EXPECT_EQ(4, n->neighbors_[0]->neighbors_[1]->neighbors_[1]->val_);
  EXPECT_TRUE(n->neighbors_[0]->neighbors_[1]->neighbors_[1] != &d);
  EXPECT_EQ(1, n->neighbors_[0]->neighbors_[1]->neighbors_[1]->neighbors_[0]->val_);
  EXPECT_EQ(3, n->neighbors_[0]->neighbors_[1]->neighbors_[1]->neighbors_[1]->val_);
  // teardown
  delete n->neighbors_[0]->neighbors_[1]->neighbors_[1];
  delete n->neighbors_[0]->neighbors_[1];
  delete n->neighbors_[0];
  delete n;
}

TEST(CloneGraph, NullExample) {
  leetcode::CloneGraph solution;
  EXPECT_EQ(nullptr, solution.solve(nullptr));
}

TEST(CloneGraph, SecondExample) {
  // setup
  leetcode::Node a(1);
  // exercise
  leetcode::CloneGraph solution;
  leetcode::Node* n = solution.solve(&a);
  // verify
  EXPECT_EQ(1, n->val_);
  EXPECT_TRUE(n != &a);
  // teardown
  delete n;
}
