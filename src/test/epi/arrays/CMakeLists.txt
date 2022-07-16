add_executable(arbitrary-precision-integer-test arbitrary-precision-integer-test.cc)
target_link_libraries(arbitrary-precision-integer-test gtest_main)
add_test(NAME arbitrary-precision-integer-test COMMAND arbitrary-precision-integer-test)
