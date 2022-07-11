add_executable(least-significant-digit-first-test least-significant-digit-first-test.cc)
target_link_libraries(least-significant-digit-first-test gtest_main least-significant-digit-first)
add_test(NAME least-signficiant-digit-first-test COMMAND least-significant-digit-first-test)
