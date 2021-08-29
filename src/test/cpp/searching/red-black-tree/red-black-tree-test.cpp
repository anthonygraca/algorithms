#include "searching/red-black-tree/red-black-tree.h"

#include "gtest/gtest.h"

TEST(RedBlackTree, TrivialExample) {
  const std::string input{"S"};
  algorithms::RedBlackTree bst;
  bst.put(input[0], 0);
  ASSERT_EQ(1, bst.size());
  ASSERT_EQ("S", bst.inorder());
  ASSERT_EQ(0, bst.get(input[0]));
}
