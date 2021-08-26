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

TEST(BinaryHeap, VerifyRemovalOfMax) {
  algorithms::MaxPriorityQueue pq;
  pq.insert('P');
  pq.insert('Q');
  pq.insert('E');
  ASSERT_EQ('Q', pq.removeMax());
}

TEST(BinaryHeap, FullExample) {
  algorithms::MaxPriorityQueue pq;
  pq.insert('P');
  pq.insert('Q');
  pq.insert('E');
  pq.removeMax();
  pq.insert('X');
  pq.insert('A');
  pq.insert('M');
  ASSERT_EQ('X', pq.removeMax());
  pq.insert('P');
  pq.insert('L');
  pq.insert('E');
  ASSERT_EQ('P', pq.removeMax());
  auto heap = pq.getHeap();
  ASSERT_EQ('P', heap[0]);
  ASSERT_EQ('M', heap[1]);
  ASSERT_EQ('L', heap[2]);
  ASSERT_EQ('A', heap[3]);
  ASSERT_EQ('E', heap[4]);
  ASSERT_EQ('E', heap[5]);
}
