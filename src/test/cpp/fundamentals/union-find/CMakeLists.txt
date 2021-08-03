add_executable(union-find-test union-find-test.cpp)
target_link_libraries(union-find-test gtest_main union-find quick-find)
add_test(NAME union-find-test COMMAND union-find-test)
