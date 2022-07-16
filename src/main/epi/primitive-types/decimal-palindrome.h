#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_IS_DECIMAL_INTEGER_A_PALINDROME_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_IS_DECIMAL_INTEGER_A_PALINDROME_H_

#include <cmath>

namespace epi {
class DecimalPalindrome {
public:
  bool isPalindrome(int x) {
    int digit_place = std::floor(std::log10(x));

    while (digit_place > 0) {
      int power = std::pow(10, digit_place);
      int a = x / power;
      int b = x % 10;
      if (a != b) return false;
      x -= a * power;
      x /= 10;
      digit_place -= 2;
    }
    return true;
  }
};
} // namespace epi

#endif
