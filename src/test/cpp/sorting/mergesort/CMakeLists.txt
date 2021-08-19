add_executable(merge-sort-test merge-sort-test.cpp)
target_link_libraries(merge-sort-test gtest_main merge-sort)
add_test(NAME merge-sort-test COMMAND merge-sort-test)
