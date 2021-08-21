add_executable(quick-sort-test quick-sort-test.cpp)
target_link_libraries(quick-sort-test gtest_main quick-sort)
add_test(NAME quick-sort-test COMMAND quick-sort-test)
