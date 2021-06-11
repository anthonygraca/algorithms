#include "stack/array-stack.h"

namespace algorithms {

bool ArrayStack::isEmpty() {
  return m_size == 0;
}

void ArrayStack::push(std::string item) {
  if (m_size == getArraySize()) {
    resize(2*getArraySize());
  }
  collection[m_size++] = item;
}

int ArrayStack::size() {
  return m_size;
}

std::string ArrayStack::pop() {
  return collection[--m_size];
}

int ArrayStack::getArraySize() {
  return sizeof(collection)/sizeof(collection[0]);
}

void ArrayStack::resize(int max) {
  int* new_array = new int[2*max];

}
} // namespace algorithms
