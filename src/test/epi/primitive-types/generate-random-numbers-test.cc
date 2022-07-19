#include "src/main/cc/data-structures-and-algorithms/primitive-types/generate-random-numbers.h"

#include "gtest/gtest.h"

TEST(GenerateRandomNumbers, FirstExample) {
  epi::GenerateRandomNumbers algo;
  int random_number = algo.generateRandom(1,10);
  ASSERT_TRUE(random_number <= 10 && random_number >= 1);
}

TEST(GenerateRandomNumbers, SecondExample) {
  epi::GenerateRandomNumbers algo;
  int random_number = algo.generateRandom(10,20);
  ASSERT_TRUE(random_number <= 20 && random_number >= 10);
}
