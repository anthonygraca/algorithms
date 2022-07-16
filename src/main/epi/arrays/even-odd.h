#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_ARRAYS_EVEN_ODD_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_ARRAYS_EVEN_ODD_H_

#include <vector>

namespace epi {
class EvenOdd {
public:
  std::vector<int> partition(std::vector<int>& input) {
    int i = 0;
    int j = input.size() - 1;
    while (i < j) {
      if (input[i] % 2 == 0) {
        i++;
      }
      else {
        std::swap(input[i], input[j--]);
      }
    }
    return input;
  }
};
} // namespace epi

#endif
