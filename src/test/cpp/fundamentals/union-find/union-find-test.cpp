#include "union-find/union-find.h"
#include "union-find/quick-find.h"

#include "gtest/gtest.h"

TEST(QuickFind, InitializedUnionFindHasZeroComponents) {
  algorithms::QuickFind uf;
  ASSERT_TRUE(uf.count() == 0);
}

TEST(QuickFind, InitializedUnionFindHasNComponents) {
  int n = 100;
  algorithms::QuickFind uf(n);
  ASSERT_TRUE(uf.count() == n);
}

TEST(QuickFind, UniqueComponentsAreNotConnected) {
  int n = 10;
  algorithms::QuickFind uf(n);
  ASSERT_FALSE(uf.connected(1, 2));
}
