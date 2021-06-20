#ifndef ALGORITHMS_PRINCETON_QUEUE_H_
#define ALGORITHMS_PRINCETON_QUEUE_H_

namespace algorithms {
template<typename T>
struct Node {
  T item;
  Node<T>* next = nullptr;
};

template<typename T>
class Queue {
public:
  Queue() = default;
  ~Queue() { while (!isEmpty()) dequeue(); }
  bool isEmpty() { return first == nullptr; }
  void enqueue(T item) {
    Node<T>* old_last = last;
    last = new Node<T>();
    last->item = item;
    last->next = nullptr;
    if (isEmpty()) first = last;
    else           old_last->next = last;
    m_size++;
  }
  int getSize() { return m_size; }
  T dequeue() {
    Node<T>* old_first = first;
    first = first->next;
    if (isEmpty()) last = nullptr;
    m_size--;
    T item = old_first->item;
    delete old_first;
    return item;
  }
private:
  Node<T>* first = nullptr;
  Node<T>* last = nullptr;
  int m_size = 0;
};
} // namespace algorithms

#endif
