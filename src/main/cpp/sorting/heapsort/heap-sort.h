#ifndef ALGORITHMS_PRINCETON_HEAP_SORT_H_
#define ALGORITHMS_PRINCETON_HEAP_SORT_H_

#include <vector>

namespace algorithms {
class HeapSort {
  public:
    std::vector<int> sort(std::vector<int>& input) {
      int n = input.size()-1;
      for (int k = n/2-1; k >= 0; k--) {
        sink(input, k, n);
      }
      while (n > 0) {
        auto temp{input[0]};
        input[0] = input[n];
        input[n--] = temp;
        sink(input, 0, n);
      }
      return input;
    }
  private:
    std::vector<int> sink(std::vector<int>& input, int k, int endpoint) {
      while (2*(k+1)-1 < endpoint) {
        int j = 2*(k+1)-1;
        if (j < endpoint && input[j] < input[j+1]) j++;
        if (input[k] >= input[j]) break;
        auto temp{input[k]};
        input[k] = input[j];
        input[j] = temp;
        k = j;
      }
      return input;
    }
};
} // namespace algorithms

#endif
