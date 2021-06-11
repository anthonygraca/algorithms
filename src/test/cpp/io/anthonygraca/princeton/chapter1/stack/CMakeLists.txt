add_executable(array-stack-test array-stack-test.cpp)
target_link_libraries(array-stack-test gtest_main array-stack)

add_test(NAME array-stack-test COMMAND array-stack-test)

