add_executable(arbitrary-precision-integer-test arbitrary-precision-integer-test.cc)
target_link_libraries(arbitrary-precision-integer-test gtest_main arbitrary-precision-integer)
add_test(NAME arbitrary-precision-integer-test COMMAND arbitrary-precision-integer-test)

add_executable(dutch-national-flag-test dutch-national-flag-test.cc)
target_link_libraries(dutch-national-flag-test gtest_main dutch-national-flag)
add_test(NAME dutch-national-flag-test COMMAND dutch-national-flag-test)

add_executable(even-odd-test even-odd-test.cc)
target_link_libraries(even-odd-test gtest_main even-odd)
add_test(NAME even-odd-test COMMAND even-odd-test)

add_executable(multiply-two-arbitrary-precision-integers-test multiply-two-arbitrary-precision-integers-test.cc)
target_link_libraries(multiply-two-arbitrary-precision-integers-test gtest_main multiply-two-arbitrary-precision-integers)
add_test(NAME multiply-two-arbitrary-precision-integers-test COMMAND multiply-two-arbitrary-precision-integers-test)
