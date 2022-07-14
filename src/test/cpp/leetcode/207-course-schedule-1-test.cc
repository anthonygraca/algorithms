#include <leetcode/207-course-schedule-1.h>

#include <vector>

#include <gtest/gtest.h>

TEST(CourseSchedule1, FirstExample) {
  std::vector<std::vector<int>> prereq {
    {1,0}
  };
  int num_courses{2};
  leetcode::Solution solution;
  bool result = solution.canFinish(num_courses, prereq);
  EXPECT_TRUE(result);
}

TEST(CourseSchedule1, SecondExample) {
  std::vector<std::vector<int>> prereq {
    {1,0}, {0,1}
  };
  int num_courses{2};
  leetcode::Solution solution;
  bool result = solution.canFinish(num_courses, prereq);
  EXPECT_FALSE(result);
}

TEST(CourseSchedule1, ThirdExample) {
  std::vector<std::vector<int>> prereq {
    {0,1}
  };
  int num_courses{2};
  leetcode::Solution solution;
  bool result = solution.canFinish(num_courses, prereq);
  EXPECT_TRUE(result);
}
