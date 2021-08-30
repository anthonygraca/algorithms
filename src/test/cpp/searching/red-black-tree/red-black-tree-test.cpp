#include "searching/red-black-tree/red-black-tree.h"

#include <type_traits>

#include "gtest/gtest.h"

TEST(RedBlackTree, TrivialExample) {
  const std::string input{"S"};
  algorithms::RedBlackTree bst;
  bst.put(input[0], 0);
  ASSERT_EQ(1, bst.size());
  ASSERT_EQ("S", bst.inorder());
  ASSERT_EQ(0, bst.get(input[0]));
}

TEST(RedBlackTree, TwoElements) {
  constexpr int insert_count{2};
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < insert_count) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(val, bst.size());
  ASSERT_EQ("ES", bst.inorder());
  ASSERT_EQ(val-1, bst.get(input[val-1]));
}

TEST(RedBlackTree, ThreeElements) {
  constexpr int insert_count{3};
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < insert_count) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(val, bst.size());
  ASSERT_EQ("AES", bst.inorder());
  ASSERT_EQ(val-1, bst.get(input[val-1]));
}

TEST(RedBlackTree, FourElements) {
  constexpr int insert_count{4};
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < insert_count) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(val, bst.size());
  ASSERT_EQ("AERS", bst.inorder());
  ASSERT_EQ(val-1, bst.get(input[val-1]));
}

TEST(RedBlackTree, InsertWholeExample) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(10, bst.size());
  ASSERT_EQ("ACEHLMPRSX", bst.inorder());
  ASSERT_EQ(val-1, bst.get(input[val-1]));
}

TEST(RedBlackTree, MinimumValue) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ('A', bst.min());
}

TEST(RedBlackTree, DeleteMin) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  bst.deleteMin();
  ASSERT_EQ(9, bst.size());
  ASSERT_EQ("CEHLMPRSX", bst.inorder());
}

TEST(RedBlackTree, DeleteNodeWithTwoChildren) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  bst.deleteNode('E');
  ASSERT_EQ(9, bst.size());
  ASSERT_EQ("ACHLMPRSX", bst.inorder());
}

TEST(RedBlackTree, FloorOfKeyDShouldBeC) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ('C', bst.floor('D'));
}

TEST(RedBlackTree, FloorOfKeyCShouldBeC) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ('C', bst.floor('C'));
}

TEST(RedBlackTree, NumberOfNodesSmallerThanLIs4) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ('L', bst.select(4));
}

TEST(RedBlackTree, RankOfLIs4) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(4, bst.rank('L'));
}

TEST(RedBlackTree, RankAndSelectAreInverseOperations) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ('L', bst.select(bst.rank('L')));
}

TEST(RedBlackTree, SelectAndRankAreInverseOperations) {
  const std::string input{"SEARCHEXAMPLE"};
  algorithms::RedBlackTree bst;
  int val = 0;
  while (val < input.size()) {
    bst.put(input[val], val);
    val++;
  }
  ASSERT_EQ(4, bst.rank(bst.select(4)));
}

TEST(RedBlackTree, IsConstructable) {
  ASSERT_TRUE(std::is_default_constructible<algorithms::RedBlackTree>::value);
  // Node Member variable m_root is not trivially default constructable;
  ASSERT_FALSE(std::is_trivially_default_constructible<algorithms::RedBlackTree>::value);
  ASSERT_TRUE(std::is_nothrow_default_constructible<algorithms::RedBlackTree>::value);
}

TEST(RedBlackTree, IsDestructable) {
  ASSERT_TRUE(std::is_destructible<algorithms::RedBlackTree>::value);
  // Node Member variable m_root is not trivially default destructible;
  ASSERT_FALSE(std::is_trivially_destructible<algorithms::RedBlackTree>::value);
  ASSERT_TRUE(std::is_nothrow_destructible<algorithms::RedBlackTree>::value);
}

TEST(RedBlackTree, IsNotCopyable) {
  ASSERT_FALSE(std::is_copy_assignable<algorithms::RedBlackTree>::value);
  ASSERT_FALSE(std::is_copy_constructible<algorithms::RedBlackTree>::value);
  ASSERT_FALSE(std::is_trivially_copy_constructible<algorithms::RedBlackTree>::value);
  ASSERT_FALSE(std::is_nothrow_copy_constructible<algorithms::RedBlackTree>::value);
}

TEST(RedBlackTree, IsNotMovable) {
  ASSERT_FALSE(std::is_move_assignable<algorithms::RedBlackTree>::value);
  ASSERT_FALSE(std::is_move_constructible<algorithms::RedBlackTree>::value);
  ASSERT_FALSE(std::is_trivially_move_constructible<algorithms::RedBlackTree>::value);
  ASSERT_FALSE(std::is_nothrow_move_constructible<algorithms::RedBlackTree>::value);
}
