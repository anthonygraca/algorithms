add_executable(shell-sort-test shell-sort-test.cpp)
target_link_libraries(shell-sort-test gtest_main shell-sort)
add_test(NAME shell-sort-test COMMAND shell-sort-test)
