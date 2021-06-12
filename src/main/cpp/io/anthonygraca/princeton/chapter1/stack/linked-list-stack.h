/*
 * =============================================================================
 *
 *       Filename:  linked-list-stack.h
 *
 *    Description:  
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

#ifndef ALGORITHMS_PRINCETON_STACK_ARRAY_BASED_H_
#define ALGORITHMS_PRINCETON_STACK_ARRAY_BASED_H_

namespace algorithms {
template<typename T>
struct Node {
  T item;
  Node<T>* next = nullptr;
};

template<typename T>
class LinkedListStack {
public:
  bool isEmpty() { return first == nullptr; }
  void push(T item) {
    Node<T>* new_node = new Node<T>();
    new_node->item = item;
    if (first != nullptr) new_node->next = first->next;
    first = new_node;
    m_size++;
  }
private:
  Node<T>* first = nullptr;
  int m_size = 0;

};
} // namespace algorithms

#endif
