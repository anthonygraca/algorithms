add_executable(insertion-sort-test insertion-sort-test.cpp)
target_link_libraries(insertion-sort-test gtest_main insertion-sort)
add_test(NAME insertion-sort-test COMMAND insertion-sort-test)
