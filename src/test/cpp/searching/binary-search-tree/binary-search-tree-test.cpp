#include "searching/binary-search-tree/binary-search-tree.h"

#include "gtest/gtest.h"

TEST(BinarySearchTree, TrivialExample) {
  char key{'S'};
  int val{0};
  algorithms::BinarySearchTree bst;
  bst.put(key, val);
  ASSERT_EQ(val, bst.get(key));
}
