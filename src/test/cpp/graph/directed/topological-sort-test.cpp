#include "graph/directed/topological-sort.h"

#include "gtest/gtest.h"

#include "graph/digraph.h"

TEST(TopologicalSort, CourseraExample) {
  algorithms::Digraph g{7};
  g.addEdge(0,5);
  g.addEdge(0,2);
  g.addEdge(0,1);
  g.addEdge(3,6);
  g.addEdge(3,5);
  g.addEdge(3,4);
  g.addEdge(5,2);
  g.addEdge(6,4);
  g.addEdge(6,0);
  g.addEdge(3,2);
  g.addEdge(1,4);
  algorithms::TopologicalSort algo{g};
  std::stack<int> stack = algo.order();
  ASSERT_EQ(3, stack.top());
  stack.pop();
  ASSERT_EQ(6, stack.top());
  stack.pop();
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(1, stack.top());
  stack.pop();
  ASSERT_EQ(4, stack.top());
  stack.pop();
  ASSERT_EQ(5, stack.top());
  stack.pop();
  ASSERT_EQ(2, stack.top());
  stack.pop();
}

TEST(TopologicalSort, BookExample) {
  algorithms::Digraph g{13};
  g.addEdge(0,1);
  g.addEdge(0,5);
  g.addEdge(0,6);
  g.addEdge(2,0);
  g.addEdge(2,3);
  g.addEdge(3,5);
  g.addEdge(5,4);
  g.addEdge(6,4);
  g.addEdge(6,9);
  g.addEdge(7,6);
  g.addEdge(8,7);
  g.addEdge(9,10);
  g.addEdge(9,11);
  g.addEdge(9,12);
  g.addEdge(11,12);
  algorithms::TopologicalSort algo{g};
  std::stack<int> stack = algo.order();
  ASSERT_EQ(8, stack.top());
  stack.pop();
  ASSERT_EQ(7, stack.top());
  stack.pop();
  ASSERT_EQ(2, stack.top());
  stack.pop();
  ASSERT_EQ(3, stack.top());
  stack.pop();
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(5, stack.top());
  stack.pop();
  ASSERT_EQ(6, stack.top());
  stack.pop();
  ASSERT_EQ(9, stack.top());
  stack.pop();
  ASSERT_EQ(11, stack.top());
  stack.pop();
  ASSERT_EQ(12, stack.top());
  stack.pop();
  ASSERT_EQ(10, stack.top());
  stack.pop();
  ASSERT_EQ(4, stack.top());
  stack.pop();
  ASSERT_EQ(1, stack.top());
  stack.pop();
}
