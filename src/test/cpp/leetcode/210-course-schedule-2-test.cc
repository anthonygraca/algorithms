#include <leetcode/210-course-schedule-2.h>

#include <vector>

#include <gtest/gtest.h>

TEST(CourseSchedule2, FirstExample) {
  int num_courses{2};
  std::vector<std::vector<int>> prereq {
    {1, 0}
  };
  leetcode::Solution solution;
  std::vector<int> order = solution.findOrder(num_courses, prereq);
  EXPECT_EQ(0, order[0]);
  EXPECT_EQ(1, order[1]);
}

TEST(CourseSchedule2, SecondExample) {
  int num_courses{4};
  std::vector<std::vector<int>> prereq {
    {1, 0}, {2, 0}, {3,1}, {3,2}
  };
  leetcode::Solution solution;
  std::vector<int> order = solution.findOrder(num_courses, prereq);
  EXPECT_EQ(0, order[0]);
  EXPECT_EQ(2, order[1]);
  EXPECT_EQ(1, order[2]);
  EXPECT_EQ(3, order[3]);
}
