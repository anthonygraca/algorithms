add_executable(queue-test queue-test.cpp)
target_link_libraries(queue-test gtest_main queue)
add_test(NAME queue-test COMMAND queue-test)
