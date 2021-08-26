#ifndef ALGORITHMS_PRINCETON_SORTING_BINARY_HEAP_PRIORITY_QUEUE_H_
#define ALGORITHMS_PRINCETON_SORTING_BINARY_HEAP_PRIORITY_QUEUE_H_

#include <vector>

namespace algorithms {
class MaxPriorityQueue {
  public:
    /* Add element to end of the array and let the element "swim" up the tree
     * to its proper place */
    void insert(const char c) {
      m_binary_heap.push_back(c);
      swim(m_size++);
    }
    std::vector<char> getHeap(void) {
      return m_binary_heap;
    }
    char removeMax(void) {
      char max = m_binary_heap[0];
      auto temp = max;
      m_binary_heap[0] = m_binary_heap.back();
      m_binary_heap.pop_back();
      m_size--;
      sink(0);
      return max;
    }
  private:
    /*
     * Check if the parent node of index is bigger or smaller. If the parent
     * node is bigger, then we are in correct heap representation. If the
     * parent node is bigger, swap and do the same thing up a level.
     *
     *        0
     *     /     \
     *    1       2
     *   / \     / \/ 
     *  3   4   5   6
     *
     *  For each parent k, the children can be found at 2(k+1)-1 and 2(k+1)
     *
     *  For each child k, the parent can be found at (k-1)/2
     */
    void swim(int child) {
      int parent = (child-1)/2;
      while (child > 0 && m_binary_heap[parent] < m_binary_heap[child]) {
        auto temp = m_binary_heap[child];
        m_binary_heap[child] = m_binary_heap[parent];
        m_binary_heap[parent] = temp;
        child = child/2;
        parent = (child-1)/2;
      }
    }
    void sink(int parent) {
      int child = 2*(parent+1)-1;
      while (child < m_size) {
        if (child < m_size && m_binary_heap[child] < m_binary_heap[child+1]) {
          child++;
        }
        if (m_binary_heap[parent] > m_binary_heap[child]) break;
        auto temp = m_binary_heap[child];
        m_binary_heap[child] = m_binary_heap[parent];
        m_binary_heap[parent] = temp;
        parent = child;
        child = 2*(parent+1)-1;
      }
    }
    std::vector<char> m_binary_heap;
    int m_size = 0;
};
} // namespace algorithms

#endif
