#ifndef ALGORITHMS_PRINCETON_UNION_FIND_H_
#define ALGORITHMS_PRINCETON_UNION_FIND_H_

namespace algorithms {
class UnionFind {
  public:
    UnionFind(int n = 0) {
      m_number_of_components = n;
    }
    int count(void) {return m_number_of_components;};
  private:
    int m_number_of_components = 0;

};
} // namespace algorithms

#endif
