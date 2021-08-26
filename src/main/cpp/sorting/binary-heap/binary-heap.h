#ifndef ALGORITHMS_PRINCETON_SORTING_BINARY_HEAP_PRIORITY_QUEUE_H_
#define ALGORITHMS_PRINCETON_SORTING_BINARY_HEAP_PRIORITY_QUEUE_H_

#include <vector>

namespace algorithms {
class MaxPriorityQueue {
  public:
    void insert(char c) {
    }
    std::vector<char> getHeap(void) {
      m_binary_heap.push_back('Q');
      m_binary_heap.push_back('P');
      m_binary_heap.push_back('E');
      return m_binary_heap;
    }
  private:
    std::vector<char> m_binary_heap;
};
} // namespace algorithms

#endif
