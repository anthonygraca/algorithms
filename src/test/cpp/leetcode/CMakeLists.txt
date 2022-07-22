# Arrays & Hashing
add_executable(217-contains-duplicate-test 217-contains-duplicate-test.cc)
target_link_libraries(217-contains-duplicate-test gtest_main 217-contains-duplicate)
add_test(NAME 217-contains-duplicate-test COMMAND 217-contains-duplicate-test)

add_executable(242-valid-anagram-test 242-valid-anagram-test.cc)
target_link_libraries(242-valid-anagram-test gtest_main 242-valid-anagram)
add_test(NAME 242-valid-anagram-test COMMAND 242-valid-anagram-test)

# Graphs
add_executable(200-number-of-islands-test 200-number-of-islands-test.cc)
target_link_libraries(200-number-of-islands-test gtest_main 200-number-of-islands)
add_test(NAME 200-number-of-islands-test COMMAND 200-number-of-islands-test)

add_executable(133-clone-graph-test 133-clone-graph-test.cc)
target_link_libraries(133-clone-graph-test gtest_main 133-clone-graph node)
add_test(NAME 133-clone-graph-test COMMAND 133-clone-graph-test)

add_executable(695-max-area-of-island-test 695-max-area-of-island-test.cc)
target_link_libraries(695-max-area-of-island-test gtest_main 695-max-area-of-island)
add_test(NAME 695-max-area-of-island-test COMMAND 695-max-area-of-island-test)

add_executable(417-pacific-atlantic-water-flow-test 417-pacific-atlantic-water-flow-test.cc)
target_link_libraries(417-pacific-atlantic-water-flow-test gtest_main 417-pacific-atlantic-water-flow)
add_test(NAME 417-pacific-atlantic-water-flow-test COMMAND 417-pacific-atlantic-water-flow-test)

add_executable(130-surrounded-regions-test 130-surrounded-regions-test.cc)
target_link_libraries(130-surrounded-regions-test gtest_main 130-surrounded-regions)
add_test(NAME 130-surrounded-regions-test COMMAND 130-surrounded-regions-test)

add_executable(997-rotting-oranges-test 997-rotting-oranges-test.cc)
target_link_libraries(997-rotting-oranges-test gtest_main 997-rotting-oranges)
add_test(NAME 997-rotting-oranges-test COMMAND 997-rotting-oranges-test)

add_executable(207-course-schedule-1-test 207-course-schedule-1-test.cc)
target_link_libraries(207-course-schedule-1-test gtest_main 207-course-schedule-1)
add_test(NAME 207-course-schedule-1-test COMMAND 207-course-schedule-1-test)

add_executable(210-course-schedule-2-test 210-course-schedule-2-test.cc)
target_link_libraries(210-course-schedule-2-test gtest_main 210-course-schedule-2)
add_test(NAME 210-course-schedule-2-test COMMAND 210-course-schedule-2-test)

add_executable(684-redundant-connection-test 684-redundant-connection-test.cc)
target_link_libraries(684-redundant-connection-test gtest_main 684-redundant-connection)
add_test(NAME 684-redundant-connection-test COMMAND 684-redundant-connection-test)
