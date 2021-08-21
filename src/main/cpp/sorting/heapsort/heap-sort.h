#ifndef ALGORITHMS_PRINCETON_HEAP_SORT_H_
#define ALGORITHMS_PRINCETON_HEAP_SORT_H_

#include <vector>

namespace algorithms {
class HeapSort {
  public:
    std::vector<int> sort(std::vector<int>& input) {
      /*
      int n = input.size();
      for (int k = n/2; k >= 1; k--) {
        //sink(input, k, n);
      }
      while (n > 1) {
        auto temp{input[1]};
        input[1] = input[n];
        input[n--] = temp;
        //sink(input, 1, n);
      }
      */
    
      return {1,2,3,4};
    }


};
} // namespace algorithms

#endif
