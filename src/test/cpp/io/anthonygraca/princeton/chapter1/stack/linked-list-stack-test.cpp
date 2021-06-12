/*
 * =============================================================================
 *
 *       Filename:  linked-list-stack-test.cpp
 *
 *    Description:  Tests of linked list implementation of a stack
 *
 *        Version:  1.0
 *        Created:  06/11/2021 23:47:08
 *       Revision:  none
 *       Compiler:  clang
 *
 *         Author:  Anthony Graca (ag), anthonygraca.io
 *
 * =============================================================================
 */
#include "stack/linked-list-stack.h"

#include "gtest/gtest.h"

TEST(LinkedListStack, InitializedStackIsEmpty) {
  algorithms::LinkedListStack<std::string> stack;
  ASSERT_TRUE(stack.isEmpty());
}

/*
TEST(LinkedListStack, PushAString) {
  algorithms::LinkedListStack<std::string> stack;
  std::string example = "dummy string";
  stack.push(example);
  ASSERT_FALSE(stack.isEmpty());
}

TEST(LinkedListStack, VerifySize) {
  algorithms::LinkedListStack<std::string> stack;
  std::string example = "dummy string";
  stack.push(example);
  ASSERT_EQ(1, stack.getSize());
}

TEST(LinkedListStack, VerifyPop) {
  algorithms::LinkedListStack<std::string> stack;
  std::string example = "dummy string";
  stack.push(example);
  ASSERT_EQ(example, stack.pop());
}

TEST(LinkedListStack, VerifyPopSize) {
  algorithms::LinkedListStack<std::string> stack;
  std::string example = "dummy string";
  stack.push(example);
  stack.pop();
  ASSERT_EQ(0, stack.getSize());
}

TEST(LinkedListStack, VerifyMultiplePop) {
  algorithms::LinkedListStack<std::string> stack;
  std::string example1 = "dummy string 1";
  std::string example2 = "dummy string 2";
  stack.push(example1);
  stack.push(example2);
  ASSERT_EQ(example2, stack.pop());
  ASSERT_EQ(example1, stack.pop());
}

TEST(LinkedListStack, VerifyStackDoesNotOverflow) {
  algorithms::LinkedListStack<std::string> stack;
  std::string example1 = "dummy string 1";
  std::string example2 = "dummy string 2";
  std::string example3 = "dummy string 3";
  std::string example4 = "dummy string 4";
  stack.push(example1);
  stack.push(example2);
  stack.push(example3);
  stack.push(example4);
  ASSERT_EQ(4, stack.getSize());
}

TEST(LinkedListStack, VerifyStackShrinks) {
  algorithms::LinkedListStack<std::string> stack;
  std::string example = "dummy string";
  for (int i = 0; i < 10; i++) {
    stack.push(example);
  }
  for (int i = 0; i < 9; i++) {
    stack.pop();
  }
  ASSERT_TRUE(stack.getSize() > stack.getCapacity()/4);
}

TEST(LinkedListStack, VerifyTemplateType) {
  algorithms::LinkedListStack<int> stack;
  int example = 1234;
  stack.push(example);
  ASSERT_TRUE(example == stack.pop());
}

TEST(LinkedListStack, VerifyIterator) {
  algorithms::LinkedListStack<std::string> stack;
  int count = 0;
  std::string example1 = "dummy string 1";
  std::string example2 = "dummy string 2";
  std::string example3 = "dummy string 3";
  std::string example4 = "dummy string 4";
  for (auto c : stack) {
    count++;
  }
  ASSERT_TRUE(count == stack.getSize());
}
*/

int main(int argc, char **argv) {
  testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}

