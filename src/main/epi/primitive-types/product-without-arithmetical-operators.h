#ifndef EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_FIND_PRODUCT_WITHOUT_ARITHMETIC_OPERATORS_H_
#define EPI_SRC_MAIN_DATA_STRUCTURES_AND_ALGORITHMS_PRIMITIVE_TYPES_FIND_PRODUCT_WITHOUT_ARITHMETIC_OPERATORS_H_

namespace epi {
class ProductWithoutArithmeticalOperators {
public:
  int product(int x, int y) {
    int sum = 0;
    while (x) {
      if (x & 1) {
        sum = add(sum, y);
      }
      x >>= 1, y <<= 1;
    }
    return sum;
  }

  int add(int a, int b) {
    while (b) {
      int carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }
    return a;
  }
};
} // namespace epi
#endif
