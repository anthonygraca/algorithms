#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_GRAPH_MINIMUM_SPANNING_TREE_EDGE_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_GRAPH_MINIMUM_SPANNING_TREE_EDGE_H_

#include <limits>
#include <stdexcept>

namespace algorithms {
  class Edge {
  public:
    Edge(int vertex_a, int vertex_b, double weight)
      : vertex_a_{vertex_a}, vertex_b_{vertex_b}, weight_{weight} {}
    double getWeight() const { return weight_; }
    int either() const { return vertex_a_; }
    int other(int v) const {
      if (v == vertex_a_) return vertex_b_;
      else if (v == vertex_b_) return vertex_a_;
      else throw std::invalid_argument("Invalid Vertex");
    }
    bool operator>(const Edge& that) const {
      return this->getWeight() > that.getWeight();
    }
    bool operator==(const Edge& that) const {
      return this->getWeight() == that.getWeight();
    }
    bool operator<(const Edge& that) const {
      return !(*this > that) && !(*this == that);
    }
    bool operator>=(const Edge& that) const {
      return (*this > that) || (*this == that);
    }
    bool operator<=(const Edge& that) const {
      return (*this < that) || (*this == that);
    }
    
  private:
    int vertex_a_{-1};
    int vertex_b_{-1};
    double weight_{std::numeric_limits<double>::max()};
  };
} // namespace algorithms

#endif
