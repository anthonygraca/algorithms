#ifndef ALGORITHMS_PRINCETON_STACK_ARRAY_BASED_H_
#define ALGORITHMS_PRINCETON_STACK_ARRAY_BASED_H_

#include <string>

namespace algorithms {
class ArrayStack {
  public:
    bool isEmpty();
    void push(std::string);
    int size();
    std::string pop();
  private:
    std::string collection[1];
    int m_size = 0;
    void resize(int);
    int getArraySize();
};
} // namespace algorithms

#endif
