add_executable(selection-sort-test selection-sort-test.cpp)
target_link_libraries(selection-sort-test gtest_main selection-sort)
add_test(NAME selection-sort-test COMMAND selection-sort-test)
