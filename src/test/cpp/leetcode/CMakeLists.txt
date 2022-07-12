add_executable(number-of-islands-test 200-number-of-islands-test.cc)
target_link_libraries(number-of-islands-test gtest_main number-of-islands)
add_test(NAME 200-number-of-islands-test COMMAND number-of-islands-test)

add_executable(clone-graph-test 133-clone-graph-test.cc)
target_link_libraries(clone-graph-test gtest_main clone-graph node)
add_test(NAME 133-clone-graph-test COMMAND clone-graph-test)
