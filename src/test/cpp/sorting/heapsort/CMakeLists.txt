add_executable(heap-sort-test heap-sort-test.cpp)
target_link_libraries(heap-sort-test gtest_main heap-sort)
add_test(NAME heap-sort-test COMMAND heap-sort-test)
