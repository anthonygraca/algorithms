#ifndef ALGORITHMS_GRAPH_DIRECTED_SHORTEST_PATH_EDGE_H_
#define ALGORITHMS_GRAPH_DIRECTED_SHORTEST_PATH_EDGE_H_

#include <limits>

namespace algorithms {
class DirectedEdge {
public:
  DirectedEdge(int a, int b, double weight) : a_{a}, b_{b}, weight_{weight} {}
  int from() const { return a_; }
  int to() const { return b_; }
  double weight() const { return weight_; }
  bool operator>(const DirectedEdge& that) const {
    return weight_ > that.weight();
  }
  bool operator==(const DirectedEdge& that) const {
    return (a_ == that.from()) && (b_ == that.to()) && (weight_ == that.weight());
  }
private:
  int a_{-1};
  int b_{-1};
  double weight_{std::numeric_limits<double>::max()};
};
} // namespace algorithms
#endif

