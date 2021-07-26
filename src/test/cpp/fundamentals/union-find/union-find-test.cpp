#include "union-find/union-find.h"

#include "gtest/gtest.h"

TEST(UnionFind, InitializedUnionFindHasZeroComponents) {
  algorithms::UnionFind uf;
  ASSERT_TRUE(uf.count() == 0);
}
