#include "sorting/binary-heap/binary-heap.h"

#include "gtest/gtest.h"

TEST(BinaryHeap, VerifyInsertOrder) {
  algorithms::MaxPriorityQueue pq;
  pq.insert('P');
  pq.insert('Q');
  pq.insert('E');
  auto heap = pq.getHeap();
  ASSERT_EQ('Q', heap[0]);
  ASSERT_EQ('P', heap[1]);
  ASSERT_EQ('E', heap[2]);
}
