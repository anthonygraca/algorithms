#include "searching/binary-search-tree/binary-search-tree.h"

#include <type_traits>

#include "gtest/gtest.h"

TEST(BinarySearchTree, TrivialExample) {
  const std::string input{"S"};
  algorithms::BinarySearchTree bst;
  bst.put(input[0], 0);
  ASSERT_EQ(1, bst.size());
  ASSERT_EQ("S", bst.inorder());
  ASSERT_EQ(0, bst.get(input[0]));
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

TEST(BinarySearchTree, DeleteMin) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  bst.deleteMin();
  ASSERT_EQ(9, bst.size());
  ASSERT_EQ("CEHLMPRSX", bst.inorder());
}

TEST(BinarySearchTree, DeleteNodeWithTwoChildren) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  bst.deleteNode('E');
  ASSERT_EQ(9, bst.size());
  ASSERT_EQ("ACHLMPRSX", bst.inorder());
}

TEST(BinarySearchTree, FloorOfKeyDShouldBeC) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ('C', bst.floor('D'));
}

TEST(BinarySearchTree, FloorOfKeyCShouldBeC) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ('C', bst.floor('C'));
}

TEST(BinarySearchTree, NumberOfNodesSmallerThanLIs4) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ('L', bst.select(4));
}

TEST(BinarySearchTree, RankOfLIs4) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(4, bst.rank('L'));
}

TEST(BinarySearchTree, RankAndSelectAreInverseOperations) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ('L', bst.select(bst.rank('L')));
}

TEST(BinarySearchTree, SelectAndRankAreInverseOperations) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::BinarySearchTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(4, bst.rank(bst.select(4)));
}

TEST(BinarySearchTree, IsConstructable) {
  ASSERT_TRUE(std::is_default_constructible<algorithms::BinarySearchTree>::value);
  // Node Member variable m_root is not trivially default constructable;
  ASSERT_FALSE(std::is_trivially_default_constructible<algorithms::BinarySearchTree>::value);
  ASSERT_TRUE(std::is_nothrow_default_constructible<algorithms::BinarySearchTree>::value);
}

TEST(BinarySearchTree, IsDestructable) {
  ASSERT_TRUE(std::is_destructible<algorithms::BinarySearchTree>::value);
  // Node Member variable m_root is not trivially default destructible;
  ASSERT_FALSE(std::is_trivially_destructible<algorithms::BinarySearchTree>::value);
  ASSERT_TRUE(std::is_nothrow_destructible<algorithms::BinarySearchTree>::value);
}

TEST(BinarySearchTree, IsNotCopyable) {
  ASSERT_FALSE(std::is_copy_assignable<algorithms::BinarySearchTree>::value);
  ASSERT_FALSE(std::is_copy_constructible<algorithms::BinarySearchTree>::value);
  ASSERT_FALSE(std::is_trivially_copy_constructible<algorithms::BinarySearchTree>::value);
  ASSERT_FALSE(std::is_nothrow_copy_constructible<algorithms::BinarySearchTree>::value);
}

TEST(BinarySearchTree, IsNotMovable) {
  ASSERT_FALSE(std::is_move_assignable<algorithms::BinarySearchTree>::value);
  ASSERT_FALSE(std::is_move_constructible<algorithms::BinarySearchTree>::value);
  ASSERT_FALSE(std::is_trivially_move_constructible<algorithms::BinarySearchTree>::value);
  ASSERT_FALSE(std::is_nothrow_move_constructible<algorithms::BinarySearchTree>::value);
}
