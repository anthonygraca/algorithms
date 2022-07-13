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
