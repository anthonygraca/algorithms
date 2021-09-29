#include "graph/directed/cycle.h"

#include <stack>

#include "gtest/gtest.h"

#include "graph/digraph.h"

TEST(DirectedCycle, BookExample) {
  algorithms::Digraph g{13};
  g.addEdge(0,1);
  g.addEdge(0,5);
  g.addEdge(2,0);
  g.addEdge(2,3);
  g.addEdge(3,2);
  g.addEdge(3,5);
  g.addEdge(4,2);
  g.addEdge(4,3);
  g.addEdge(5,4);
  g.addEdge(6,0);
  g.addEdge(6,4);
  g.addEdge(6,8);
  g.addEdge(6,9);
  g.addEdge(7,6);
  g.addEdge(7,9);
  g.addEdge(8,6);
  g.addEdge(9,10);
  g.addEdge(9,11);
  g.addEdge(10,12);
  g.addEdge(11,4);
  g.addEdge(11,12);
  g.addEdge(12,9);
  algorithms::DirectedCycle algo{g};
  ASSERT_TRUE(algo.hasCycle());
  std::stack<int> cycle_path = algo.cycle();
  ASSERT_EQ(2, cycle_path.top());
  cycle_path.pop();
  ASSERT_EQ(0, cycle_path.top());
  cycle_path.pop();
  ASSERT_EQ(5, cycle_path.top());
  cycle_path.pop();
  ASSERT_EQ(4, cycle_path.top());
  cycle_path.pop();
  ASSERT_EQ(2, cycle_path.top());
  cycle_path.pop();
}
