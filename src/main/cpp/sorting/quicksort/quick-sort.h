#ifndef ALGORITHMS_PRINCETON_SORTING_QUICK_H_
#define ALGORITHMS_PRINCETON_SORTING_QUICK_H_

#include <vector>

namespace algorithms {
class QuickSort {
  public:
    std::vector<int> sort(std::vector<int>& input) {
      sort(input, 0, input.size()-1);
      return input;
    };

  private:
    void sort(std::vector<int>& input, int low, int high) {
      if (high <= low) return;
      int j = partition(input, low, high);
      sort(input, low, j-1);
      sort(input, j+1, high);
    }
    int partition(std::vector<int>& input, int low, int high) {
      int i = low, j = high + 1;
      auto partition{input[low]};
      while (true) {
        while (input[++i] < partition) if (i == high) break;
        while (partition < input[--j]) if (j == low) break;
        if (i >= j) break;
        auto temp{input[i]};
        input[i] = input[j];
        input[j] = temp;
      }
      auto temp{input[low]};
      input[low] = input[j];
      input[j] = temp;
      return j;
    }
};
} // namespace algorithms

#endif
