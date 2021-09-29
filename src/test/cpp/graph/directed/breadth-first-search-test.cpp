#include "graph/directed/breadth-first-search.h"

#include <unordered_set>

#include "gtest/gtest.h"

#include "graph/digraph.h"

TEST(DirectedBreadthFirstSearch, BookExample) {
  algorithms::Digraph g{6};
  g.addEdge(5,0);
  g.addEdge(2,4);
  g.addEdge(3,2);
  g.addEdge(1,2);
  g.addEdge(0,1);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(0,2);
  std::unordered_set<int> sources;
  sources.insert(0);
  algorithms::DirectedBreadthFirstSearch algo(g, sources);
  ASSERT_TRUE(algo.hasPathTo(0));
  ASSERT_TRUE(algo.hasPathTo(1));
  ASSERT_TRUE(algo.hasPathTo(2));
  ASSERT_TRUE(algo.hasPathTo(3));
  ASSERT_TRUE(algo.hasPathTo(4));
  ASSERT_TRUE(algo.hasPathTo(5));
}

TEST(DirectedBreadthFirstSearch, HasPathToFalse) {
  algorithms::Digraph g{7};
  g.addEdge(5,0);
  g.addEdge(2,4);
  g.addEdge(3,2);
  g.addEdge(1,2);
  g.addEdge(0,1);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(0,2);
  std::unordered_set<int> sources;
  sources.insert(0);
  algorithms::DirectedBreadthFirstSearch algo(g, sources);
  ASSERT_FALSE(algo.hasPathTo(6));
}

TEST(DirectedBreadthFirstSearch, VerifyPathToFive) {
  algorithms::Digraph g{6};
  g.addEdge(5,0);
  g.addEdge(2,4);
  g.addEdge(3,2);
  g.addEdge(1,2);
  g.addEdge(0,1);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(0,2);
  std::unordered_set<int> sources;
  sources.insert(0);
  algorithms::DirectedBreadthFirstSearch algo{g, sources};
  auto stack = algo.pathTo(5);
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(2, stack.top());
  stack.pop();
  ASSERT_EQ(4, stack.top());
  stack.pop();
  ASSERT_EQ(3, stack.top());
  stack.pop();
  ASSERT_EQ(5, stack.top());
  stack.pop();
}

TEST(DirectedBreadthFirstSearch, VerifyPathToFour) {
  algorithms::Digraph g{6};
  g.addEdge(5,0);
  g.addEdge(2,4);
  g.addEdge(3,2);
  g.addEdge(1,2);
  g.addEdge(0,1);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(0,2);
  std::unordered_set<int> sources;
  sources.insert(0);
  algorithms::DirectedBreadthFirstSearch algo{g, sources};
  auto stack = algo.pathTo(4);
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(2, stack.top());
  stack.pop();
  ASSERT_EQ(4, stack.top());
  stack.pop();
}

TEST(DirectedBreadthFirstSearch, VerifyPathToThree) {
  algorithms::Digraph g{6};
  g.addEdge(5,0);
  g.addEdge(2,4);
  g.addEdge(3,2);
  g.addEdge(1,2);
  g.addEdge(0,1);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(0,2);
  std::unordered_set<int> sources;
  sources.insert(0);
  algorithms::DirectedBreadthFirstSearch algo{g, sources};
  auto stack = algo.pathTo(3);
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(2, stack.top());
  stack.pop();
  ASSERT_EQ(4, stack.top());
  stack.pop();
  ASSERT_EQ(3, stack.top());
  stack.pop();
}

TEST(DirectedBreadthFirstSearch, VerifyPathToTwo) {
  algorithms::Digraph g{6};
  g.addEdge(5,0);
  g.addEdge(2,4);
  g.addEdge(3,2);
  g.addEdge(1,2);
  g.addEdge(0,1);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(0,2);
  std::unordered_set<int> sources;
  sources.insert(0);
  algorithms::DirectedBreadthFirstSearch algo{g, sources};
  auto stack = algo.pathTo(2);
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(2, stack.top());
  stack.pop();
}

TEST(DirectedBreadthFirstSearch, VerifyPathToOne) {
  algorithms::Digraph g{6};
  g.addEdge(5,0);
  g.addEdge(2,4);
  g.addEdge(3,2);
  g.addEdge(1,2);
  g.addEdge(0,1);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(0,2);
  std::unordered_set<int> sources;
  sources.insert(0);
  algorithms::DirectedBreadthFirstSearch algo{g, sources};
  auto stack = algo.pathTo(1);
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(1, stack.top());
  stack.pop();
}

TEST(DirectedBreadthFirstSearch, MultipleSources) {
  algorithms::Digraph g{13};
  g.addEdge(4,2);
  g.addEdge(2,3);
  g.addEdge(3,2);
  g.addEdge(6,0);
  g.addEdge(0,1);
  g.addEdge(2,0);
  g.addEdge(11,12);
  g.addEdge(12,9);
  g.addEdge(9,10);
  g.addEdge(9,11);
  g.addEdge(7,9);
  g.addEdge(10,12);
  g.addEdge(11,4);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(6,8);
  g.addEdge(8,6);
  g.addEdge(5,4);
  g.addEdge(0,5);
  g.addEdge(6,4);
  g.addEdge(6,9);
  g.addEdge(7,6);
  std::unordered_set<int> sources;
  sources.insert(1);
  sources.insert(7);
  sources.insert(10);
  algorithms::DirectedBreadthFirstSearch algo{g, sources};
  auto stack = algo.pathTo(4);
  ASSERT_EQ(7, stack.top());
  stack.pop();
  ASSERT_EQ(6, stack.top());
  stack.pop();
  ASSERT_EQ(4, stack.top());
  stack.pop();
  stack = algo.pathTo(5);
  ASSERT_EQ(7, stack.top());
  stack.pop();
  ASSERT_EQ(6, stack.top());
  stack.pop();
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(5, stack.top());
  stack.pop();
  stack = algo.pathTo(12);
  ASSERT_EQ(10, stack.top());
  stack.pop();
  ASSERT_EQ(12, stack.top());
  stack.pop();
}
