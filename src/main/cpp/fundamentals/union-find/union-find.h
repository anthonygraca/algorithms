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
    int find(int p) {
      return quickFind(p);

    }
    int quickFind(int p) {
      return m_id[p];
    }
    void qunion(int p, int q) {
      int pID = find(p);
      int qID = find(q);
      if (pID == qID) return;
      for (int i = 0; i < m_id.size(); i++) {
        if (m_id[i] == pID) m_id[i] = qID;
      }
      m_number_of_components--;
    }
  private:
    int m_number_of_components = 0;
    std::vector<int> m_id;

};
} // namespace algorithms

#endif
