#ifndef ALGORITHMS_PRINCETON_QUICK_FIND_H_
#define ALGORITHMS_PRINCETON_QUICK_FIND_H_

namespace algorithms {
class QuickFind : public UnionFind {
  public:
    QuickFind(int n = 0) : UnionFind(n) {};
    int find(int p) {
      return m_id[p];
    }
    void merge(int p, int q) {
      int pID = find(p);
      int qID = find(q);
      if (pID == qID) return;
      for (int i = 0; i < m_id.size(); i++) {
        if (m_id[i] == pID) m_id[i] = qID;
      }
      m_number_of_components--;
    }

};

} // namespace algorithms

#endif
