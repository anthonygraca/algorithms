#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_COMPUTE_POW_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_COMPUTE_POW_H_

namespace epi {
class ComputePow {
public:
  int pow(int x, int y) {
    double result = 1.0;
    long long power = y;
    if (y < 0) {
      power = -power, x = 1.0 / x;
    }
    while (power) {
      if (power & 1) {
        result *= x;
      }
      x *= x, power >>=1;
    }
    return result;
  }
};
} // namespace epi

#endif
