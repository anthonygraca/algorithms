#ifndef ALGORITHMS_PRINCETON_UNION_FIND_H_
#define ALGORITHMS_PRINCETON_UNION_FIND_H_

#include <vector>

namespace algorithms {
class UnionFind {
  public:
    UnionFind(int n = 0) {
      m_id = std::vector<int>(n);
      m_number_of_components = n;
      for (int i = 0; i < n; i++) {
        m_id[i] = i;
      }
    }
    int count(void) {return m_number_of_components;};
    bool connected(int p, int q) {
      return find(p) == find(q);
    }
    virtual int find(int p) = 0;
    virtual void merge(int p, int q) = 0;
  protected:
    int m_number_of_components = 0;
    std::vector<int> m_id;

};
} // namespace algorithms

#endif
