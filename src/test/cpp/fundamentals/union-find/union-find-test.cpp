#include "union-find/union-find.h"

#include "gtest/gtest.h"

TEST(UnionFind, InitializedUnionFindHasZeroComponents) {
  algorithms::UnionFind uf;
  ASSERT_TRUE(uf.count() == 0);
}

TEST(UnionFind, InitializedUnionFindHasNComponents) {
  int n = 100;
  algorithms::UnionFind uf(n);
  ASSERT_TRUE(uf.count() == n);
}

TEST(UnionFind, UniqueComponentsAreNotConnected) {
  int n = 10;
  algorithms::UnionFind uf(n);
  ASSERT_FALSE(uf.connected(1, 2));
}
