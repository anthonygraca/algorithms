#include "stack/array-stack.h"

#include "gtest/gtest.h"

TEST(ArrayStack, InitializedStackIsEmpty) {
  algorithms::ArrayStack stack;
  ASSERT_TRUE(stack.isEmpty());
}

TEST(ArrayStack, PushAString) {
  algorithms::ArrayStack stack;
  std::string example = "dummy string";
  stack.push(example);
  ASSERT_FALSE(stack.isEmpty());
}

TEST(ArrayStack, VerifySize) {
  algorithms::ArrayStack stack;
  std::string example = "dummy string";
  stack.push(example);
  ASSERT_EQ(1, stack.size());
}

TEST(ArrayStack, VerifyPop) {
  algorithms::ArrayStack stack;
  std::string example = "dummy string";
  stack.push(example);
  ASSERT_EQ(example, stack.pop());
}

TEST(ArrayStack, VerifyPopSize) {
  algorithms::ArrayStack stack;
  std::string example = "dummy string";
  stack.push(example);
  stack.pop();
  ASSERT_EQ(0, stack.size());
}

TEST(ArrayStack, VerifyMultiplePop) {
  algorithms::ArrayStack stack;
  std::string example1 = "dummy string 1";
  std::string example2 = "dummy string 2";
  stack.push(example1);
  stack.push(example2);
  ASSERT_EQ(example2, stack.pop());
  ASSERT_EQ(example1, stack.pop());
}


int main(int argc, char **argv) {
  testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
