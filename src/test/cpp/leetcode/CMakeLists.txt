add_executable(number-of-islands-test 200-number-of-islands-test.cc)
target_link_libraries(number-of-islands-test gtest_main number-of-islands)
add_test(NAME number-of-islands-test COMMAND number-of-islands-test)
