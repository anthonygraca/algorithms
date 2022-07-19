#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_ARRAYS_INCREMENT_ARBITRARY_PRECISION_INTEGER_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_ARRAYS_INCREMENT_ARBITRARY_PRECISION_INTEGER_H_

/*
 * Write a program that takes as input an array of digits encoding a nonnegative
 * decimal integer D and updates the array the represent the integer D + 1. For
 * example, if the input is <1,2,9> then you should update the array to <1,3,0>
 */

#include <vector>

namespace epi {
class ArbitraryPrecisionInteger {
public:
  std::vector<int> increment(std::vector<int>& input) {
    input.back()++;
    for (int i = input.size()-1; i > 0; i--) {
      if (input[i] == 10) {
        input[i] = 0;
        input[i-1]++;
      }
    }
    if (input[0] == 10) {
      input[0] = 1;
      input.emplace_back(0);
    }
    return input;
  }
};
} // namespace epi

#endif
