#include "graph/undirected/breadth-first-paths.h"

#include "gtest/gtest.h"

#include "graph/graph.h"

TEST(BreadthFirstPaths, FirstExample) {
  algorithms::Graph g{7};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::BreadthFirstPaths algo{g, 0};
  ASSERT_TRUE(algo.hasPathTo(0));
  ASSERT_TRUE(algo.hasPathTo(1));
  ASSERT_TRUE(algo.hasPathTo(2));
  ASSERT_TRUE(algo.hasPathTo(3));
  ASSERT_TRUE(algo.hasPathTo(4));
  ASSERT_TRUE(algo.hasPathTo(5));
}

TEST(BreadthFirstPaths, HasPathToReturnsFalse) {
  algorithms::Graph g{7};
  algorithms::BreadthFirstPaths algo{g, 0};
  ASSERT_FALSE(algo.hasPathTo(6));
}

TEST(BreadthFirstPaths, VerifyPathToFive) {
  algorithms::Graph g{6};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::BreadthFirstPaths algo{g, 0};
  auto stack = algo.pathTo(5);
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(5, stack.top());
  stack.pop();
}

TEST(BreadthFirstPaths, VerifyPathToFour) {
  algorithms::Graph g{6};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::BreadthFirstPaths algo{g, 0};
  auto stack = algo.pathTo(4);
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(2, stack.top());
  stack.pop();
  ASSERT_EQ(4, stack.top());
  stack.pop();
}

TEST(BreadthFirstPaths, VerifyPathToThree) {
  algorithms::Graph g{6};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::BreadthFirstPaths algo{g, 0};
  auto stack = algo.pathTo(3);
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(5, stack.top());
  stack.pop();
  ASSERT_EQ(3, stack.top());
  stack.pop();
}

TEST(BreadthFirstPaths, VerifyPathToTwo) {
  algorithms::Graph g{6};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::BreadthFirstPaths algo{g, 0};
  auto stack = algo.pathTo(2);
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(2, stack.top());
  stack.pop();
}

TEST(BreadthFirstPaths, VerifyPathToOne) {
  algorithms::Graph g{6};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::BreadthFirstPaths algo{g, 0};
  auto stack = algo.pathTo(1);
  ASSERT_EQ(0, stack.top());
  stack.pop();
  ASSERT_EQ(1, stack.top());
  stack.pop();
}

