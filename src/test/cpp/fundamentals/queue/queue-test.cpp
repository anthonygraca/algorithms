/*
 * =============================================================================
 *
 *       Filename:  queue-test.cpp
 *
 *    Description:  Test of Queue
 *
 *        Version:  1.0
 *        Created:  06/12/2021 19:35:51
 *       Revision:  none
 *       Compiler:  clang
 *
 *         Author:  Anthony Graca (ag), anthonygraca.io
 *
 * =============================================================================
 */

#include "queue/queue.h"

#include "gtest/gtest.h"

TEST(Queue, InitializedQueueIsEmpty) {
  algorithms::Queue<std::string> queue;
  ASSERT_TRUE(queue.isEmpty());
}

TEST(Queue, EnqueueAString) {
  algorithms::Queue<std::string> queue;
  std::string example = "dummy string";
  queue.enqueue(example);
  ASSERT_FALSE(queue.isEmpty());
}

TEST(Queue, VerifySize) {
  algorithms::Queue<std::string> queue;
  std::string example = "dummy string";
  queue.enqueue(example);
  ASSERT_EQ(1, queue.getSize());
}

TEST(Queue, VerifyDequeue) {
  algorithms::Queue<std::string> queue;
  std::string example = "dummy string";
  queue.enqueue(example);
  ASSERT_EQ(example, queue.dequeue());
}

TEST(Queue, VerifyPopSize) {
  algorithms::Queue<std::string> queue;
  std::string example = "dummy string";
  queue.enqueue(example);
  queue.dequeue();
  ASSERT_EQ(0, queue.getSize());
}

TEST(Queue, VerifyMultipleEnqueue) {
  algorithms::Queue<std::string> queue;
  std::string example1 = "dummy string 1";
  std::string example2 = "dummy string 2";
  queue.enqueue(example1);
  queue.enqueue(example2);
  ASSERT_EQ(example1, queue.dequeue());
  ASSERT_EQ(example2, queue.dequeue());
}

TEST(Queue, VerifyQueueDoesNotOverflow) {
  algorithms::Queue<std::string> queue;
  std::string example1 = "dummy string 1";
  std::string example2 = "dummy string 2";
  std::string example3 = "dummy string 3";
  std::string example4 = "dummy string 4";
  queue.enqueue(example1);
  queue.enqueue(example2);
  queue.enqueue(example3);
  queue.enqueue(example4);
  ASSERT_EQ(4, queue.getSize());
}

TEST(Queue, VerifyTemplateType) {
  algorithms::Queue<int> queue;
  int example = 1234;
  queue.enqueue(example);
  ASSERT_TRUE(example == queue.dequeue());
}

int main(int argc, char **argv) {
  testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
