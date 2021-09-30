#include "graph/digraph.h"

#include "gtest/gtest.h"

TEST(Digraph, NoVertices) {
  algorithms::Digraph g{0};
  ASSERT_EQ(0, g.vertices());
}

TEST(Digraph, NoVerticesNoEdges) {
  algorithms::Digraph g{0};
  ASSERT_EQ(0, g.vertices());
}

TEST(Digraph, OnlyOneVertex) {
  algorithms::Digraph g{1};
  ASSERT_EQ(1, g.vertices());
}

TEST(Digraph, OnlyOneVertexNoEdges) {
  algorithms::Digraph g{1};
  ASSERT_EQ(0, g.edges());
}

TEST(Digraph, AddEdge) {
  algorithms::Digraph g{2};
  g.addEdge(0,1);
  ASSERT_EQ(2, g.vertices());
  ASSERT_EQ(1, g.edges());
}

TEST(Digraph, BigExample) {
  algorithms::Digraph g{13};
  g.addEdge(0,5);
  g.addEdge(4,3);
  g.addEdge(0,1);
  g.addEdge(9,12);
  g.addEdge(6,4);
  g.addEdge(5,4);
  g.addEdge(0,2);
  g.addEdge(11,12);
  g.addEdge(9,10);
  g.addEdge(0,6);
  g.addEdge(7,8);
  g.addEdge(9,11);
  g.addEdge(5,3);
  ASSERT_EQ(13, g.vertices());
  ASSERT_EQ(13, g.edges());
  ASSERT_TRUE(g.adj(0).contains(5));
  ASSERT_TRUE(g.adj(0).contains(1));
  ASSERT_TRUE(g.adj(0).contains(2));
  ASSERT_TRUE(g.adj(0).contains(6));
  ASSERT_FALSE(g.adj(1).contains(0));
  ASSERT_FALSE(g.adj(2).contains(0));
  ASSERT_FALSE(g.adj(3).contains(5));
  ASSERT_FALSE(g.adj(3).contains(4));
  ASSERT_FALSE(g.adj(4).contains(5));
  ASSERT_FALSE(g.adj(4).contains(6));
  ASSERT_TRUE(g.adj(4).contains(3));
  ASSERT_TRUE(g.adj(5).contains(3));
  ASSERT_TRUE(g.adj(5).contains(4));
  ASSERT_FALSE(g.adj(5).contains(0));
  ASSERT_FALSE(g.adj(6).contains(0));
  ASSERT_TRUE(g.adj(6).contains(4));
  ASSERT_TRUE(g.adj(7).contains(8));
  ASSERT_FALSE(g.adj(8).contains(7));
  ASSERT_TRUE(g.adj(9).contains(11));
  ASSERT_TRUE(g.adj(9).contains(10));
  ASSERT_TRUE(g.adj(9).contains(12));
  ASSERT_FALSE(g.adj(10).contains(9));
  ASSERT_TRUE(g.adj(11).contains(12));
  ASSERT_FALSE(g.adj(12).contains(11));
  ASSERT_FALSE(g.adj(12).contains(9));
}

TEST(Digraph, BigExampleAdjacentToZero) {
  std::unordered_set<int> set;
  set.insert(6);
  set.insert(5);
  set.insert(2);
  set.insert(1);
  algorithms::Digraph g{13};
  g.addEdge(0,5);
  g.addEdge(4,3);
  g.addEdge(0,1);
  g.addEdge(9,12);
  g.addEdge(6,4);
  g.addEdge(5,4);
  g.addEdge(0,2);
  g.addEdge(11,12);
  g.addEdge(9,10);
  g.addEdge(0,6);
  g.addEdge(7,8);
  g.addEdge(9,11);
  g.addEdge(5,3);
  for(int w : g.adj(0)) {
    ASSERT_TRUE(set.contains(w));
  }
}

TEST(Digraph, BookBigExample) {
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
  ASSERT_EQ(13, g.vertices());
  ASSERT_EQ(22, g.edges());
  ASSERT_TRUE(g.adj(0).contains(1));
  ASSERT_FALSE(g.adj(1).contains(0));
}

TEST(Digraph, ReverseGraph) {
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
  auto reversed = g.reverse();
  ASSERT_TRUE(reversed.adj(2).contains(4));
  ASSERT_FALSE(reversed.adj(4).contains(2));
  ASSERT_TRUE(reversed.adj(3).contains(2));
  ASSERT_TRUE(reversed.adj(2).contains(3));
  ASSERT_TRUE(reversed.adj(0).contains(6));
  ASSERT_FALSE(reversed.adj(6).contains(0));
  ASSERT_TRUE(reversed.adj(1).contains(0));
  ASSERT_FALSE(reversed.adj(0).contains(1));
  ASSERT_TRUE(reversed.adj(0).contains(2));
  ASSERT_FALSE(reversed.adj(2).contains(0));
}
