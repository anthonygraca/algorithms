/*
 * =============================================================================
 *
 *       Filename:  linked-list-stack.h
 *
 *    Description:  Stack with Linked List
 *
 *        Version:  1.0
 *        Created:  06/11/2021 23:50:58
 *       Revision:  none
 *       Compiler:  clang
 *
 *         Author:  Anthony Graca (ag), anthonygraca.io
 *
 * =============================================================================
 */

#ifndef ALGORITHMS_PRINCETON_STACK_LINKED_LIST_BASED_H_
#define ALGORITHMS_PRINCETON_STACK_LINKED_LIST_BASED_H_

namespace algorithms {
template<typename T>
struct Node {
  T item;
  Node<T>* next = nullptr;
};

template<typename T>
class LinkedListStack {
public:
  ~LinkedListStack() { while (!isEmpty()) pop(); }
  bool isEmpty() { return first == nullptr; }
  void push(T item) {
    Node<T>* new_node = new Node<T>();
    new_node->item = item;
    new_node->next = first;
    first = new_node;
    m_size++;
  }
  int getSize() {
    return m_size;
  }
  T pop() {
    Node<T>* popped_node = first;
    first = first->next;
    T item = popped_node->item;
    delete popped_node;
    m_size--;
    return item;
  }
private:
  Node<T>* first = nullptr;
  int m_size = 0;
};
} // namespace algorithms

#endif
