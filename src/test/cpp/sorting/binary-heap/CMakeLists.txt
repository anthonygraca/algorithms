add_executable(binary-heap-test binary-heap-test.cpp)
target_link_libraries(binary-heap-test gtest_main binary-heap)
add_test(NAME binary-heap-test COMMAND binary-heap-test)
