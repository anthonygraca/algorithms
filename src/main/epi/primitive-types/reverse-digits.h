#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_REVERSE_DIGITS_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_REVERSE_DIGITS_H_

namespace epi {
class ReverseDigits {
public:
  int reverse(int x) {
    int result = 0;
    while (x > 0) {
      int digit = x % 10;
      x = x / 10;
      result = (result * 10) + digit;
    }
    return result;
  }
};
} // namespace epi

#endif
