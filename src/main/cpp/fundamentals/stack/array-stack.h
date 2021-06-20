#ifndef ALGORITHMS_PRINCETON_STACK_ARRAY_BASED_H_
#define ALGORITHMS_PRINCETON_STACK_ARRAY_BASED_H_

#include <utility>

namespace algorithms {
template <typename T>
class ArrayStack {
public:
  ArrayStack() : m_size{0}, m_capacity{1}, m_collection{new T[m_capacity]} {};
  ~ArrayStack() { delete[] m_collection; };
  bool isEmpty() {
    return m_size == 0;
  }
  void push(T item) {
    if (m_size == m_capacity)
      resize(2 * m_capacity);
    m_collection[m_size++] = item;
  }
  int getSize() { return m_size; }
  int getCapacity() { return m_capacity; }
  T pop() {
    T item = std::move(m_collection[--m_size]);
    if (m_size > 0 && m_size == m_capacity / 4)
      resize(m_capacity / 2);
    return std::move(item);
  }
private:
  int m_size = -1;
  int m_capacity = -1;
  T *m_collection;
  void resize(int max) {
    m_capacity = max;
    T *new_array = new T[m_capacity];
    for (int i = 0; i < m_size; i++) {
      new_array[i] = std::move(m_collection[i]);
    }
    delete[] m_collection;
    m_collection = new_array;
  }
};
} // namespace algorithms
#endif
