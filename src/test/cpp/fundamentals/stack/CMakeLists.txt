add_executable(array-stack-test array-stack-test.cpp)
target_link_libraries(array-stack-test gtest_main array-stack)
add_test(NAME array-stack-test COMMAND array-stack-test)

add_executable(linked-list-stack-test linked-list-stack-test.cpp)
target_link_libraries(linked-list-stack-test gtest_main linked-list-stack)
add_test(NAME linked-list-stack-test COMMAND linked-list-stack-test)

