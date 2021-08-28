#include "searching/binary-search-tree/binary-search-tree.h"

#include "gtest/gtest.h"

TEST(BinarySearchTree, TrivialExample) {
  constexpr int insert_count{1};
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < insert_count) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(val, bst.size());
  ASSERT_EQ("S", bst.inorder());
  ASSERT_EQ(val-1, bst.get(input[val-1]));
}

TEST(BinarySearchTree, TwoElements) {
  constexpr int insert_count{2};
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < insert_count) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(val, bst.size());
  ASSERT_EQ("ES", bst.inorder());
  ASSERT_EQ(val-1, bst.get(input[val-1]));
}

TEST(BinarySearchTree, ThreeElements) {
  constexpr int insert_count{3};
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < insert_count) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(val, bst.size());
  ASSERT_EQ("AES", bst.inorder());
  ASSERT_EQ(val-1, bst.get(input[val-1]));
}

TEST(BinarySearchTree, FourElements) {
  constexpr int insert_count{4};
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < insert_count) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(val, bst.size());
  ASSERT_EQ("AERS", bst.inorder());
  ASSERT_EQ(val-1, bst.get(input[val-1]));
}

TEST(BinarySearchTree, InsertWholeExample) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(10, bst.size());
  ASSERT_EQ("ACEHLMPRSX", bst.inorder());
  ASSERT_EQ(val-1, bst.get(input[val-1]));
}

TEST(BinarySearchTree, MinimumValue) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ('A', bst.min());
}
