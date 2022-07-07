# Data Structures & Algorithms

## How to Build
### Java Code with Maven
[Maven](https://maven.apache.org/) is the build tool that manages all of the
Java code in this project. 

#### Building algs4 
Some of the source code written in java will depend on the algs4 library. Here
are the following steps to include the algs4.jar into this project. We are
building this jar from source because the bintray repository has been shutdown,
preventing Maven from easily pulling an already created algs4.jar

1. `git clone https://github.com/kevin-wayne/algs4.git`
2. `cd algs4 && mvn package`
3. `cd </path/of/this-project>`
4. `mvn package`
5. `mvn install:install-file -Dfile=/path/to/algs4/target/algs4-1.0.0.0.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0 -Dpackaging=jar`

#### Normal Usage
1. `mvn package` to compile and package. 
2. `java -jar target/<name-of-file>.jar` to run the compiled code 
3. `mvn test` to build and run tests.

### C++ Code with CMake
[CMake](https://cmake.org/) (version >= 3.23) is the build tool that manages all of the C++
code in this project. Code is compiled with a C++17 compiler.

#### Normal Usage
Do the "cmake dance". 
1. `cmake -S. -Bbuild` to create a separate build folder to isolate generate cmake build
files. 
2. `cmake --build build --parallel && ctest --test-dir build --parallel` to compile source and run tests.

### Python Code with VirtualEnv
1. Install [pyenv](https://github.com/pyenv/pyenv#installation) 
2. Use pyenv to install Python3 (e.g. `pyenv install 3.9.5`) 
3. Use the installed pip3 to install virtualenv `pip install virtualenv` 
4. Create and source virtualenv `virtualenv venv && source venv/bin/activate` 
5. Install [pybuilder](https://pybuilder.io/documentation/tutorial) in virtualenv 
6. Call `pyb` to run all tests

## Table of Contents
### Chapter 1. Fundamentals
| Topic | C++ | Java | Tests |
|-------|-----|------|-------|
| Stacks | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/fundamentals/stack) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/stack) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/tree/main/src/test/cpp/fundamentals/stack) |
| Queues | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/fundamentals/queue) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/queue) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/fundamentals/queue/queue-test.cpp) |
| Bags   | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/bag) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/tree/main/src/test/java/io/anthonygraca/princeton/chapter1/bag) |
| Deque  | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/deque/) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/java/io/anthonygraca/princeton/chapter1/deque/DequeTest.java) |
| Union Find | | [x](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/UnionFind.java) |
### Chapter 2. Sorting
| Topic | C++ | Java | Tests |
|-------|-----|------|-------|
| Insertion Sort | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/sorting/insertion/insertion-sort.h) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter2/Insertion.java) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/sorting/insertion/insertion-sort-test.cpp) |
| Selection Sort | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/sorting/selection/selection-sort.h) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter2/Selection.java) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/sorting/selection/selection-sort-test.cpp) |
| ShellSort | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/sorting/shellsort/shell-sort.h)| [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter2/Shell.java) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/sorting/shellsort/shell-sort-test.cpp) |
| QuickSort | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/sorting/quicksort/quick-sort.h) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter2/Quick.java) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/sorting/quicksort/quick-sort-test.cpp) |
| MergeSort | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/sorting/mergesort/merge-sort.h) || [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter2/Merge.java) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/tree/main/src/test/cpp/sorting/mergesort) |
| HeapSort | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/sorting/heapsort/heap-sort.h) |  | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/sorting/heapsort/heap-sort-test.cpp) | 
| Binary Heaps | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/sorting/binary-heap/binary-heap.h) |  | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/sorting/binary-heap/binary-heap-test.cpp) |
### Chapter 3. Searching
| Topic | C++ | Java |
|-------|-----|------|
| Binary Search Trees | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/searching/binary-search-tree/binary-search-tree.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/searching/binary-search-tree/binary-search-tree-test.cpp) |
| Red-Black Trees | [x](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/searching/red-black-tree/red-black-tree.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/searching/red-black-tree/red-black-tree-test.cpp) |
| k-d trees | | |
| Separate Chaining Hash Tables | | |
| Linear Probing Hash Tables | | |
### Chapter 4. Graphs
| Topic | C++ | Java | Tests |
|-------|-----|------|-------|
| Undirected Graph Data Structure | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/graph/graph.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/graph/graph-test.cpp) |
| Depth-First Search | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/graph/undirected/depth-first-search.h) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter4/WordNet/DeluxeBFS.java) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/graph/undirected/depth-first-search-test.cpp) |
| Connected Components | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/graph/undirected/connected-components.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/graph/undirected/connected-components-test.cpp) |
| Breadth-First Search | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/graph/undirected/breadth-first-paths.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/graph/undirected/breadth-first-paths-test.cpp) |
| Directed Graph Data Structure | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/graph/digraph.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/graph/digraph-test.cpp) |
| Cycle Detection | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/graph/directed/cycle.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/graph/directed/cycle-test.cpp) |
| Topological Sort | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/graph/directed/topological-sort.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/graph/directed/topological-sort-test.cpp) |
| Kosaraju−Sharir | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/graph/directed/kosaraju-sharir.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/graph/directed/kosaraju-sharir-test.cpp) |
| Weighted Edge Data Structure | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/graph/undirected/minimum-spanning-tree/edge.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/graph/undirected/minimum-spanning-tree/edge-weighted-graph-test.cc) |
| Edge Weighted Graph Data Structure | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/graph/undirected/minimum-spanning-tree/edge-weighted-graph.h) | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/test/cpp/graph/undirected/minimum-spanning-tree/edge-weighted-graph-test.cc) |
| Kruskal | | |
| Prim | | |
| Dijkstra | | |
| Bellman−Ford | | |
### Chapter 5. Strings
| Topic | C++ | Java |
|-------|-----|------|
| LSD Radix Sort | | |
| MSD Radix Sort | | |
| 3-Way Radix QuickSort | | |
| Multiway Tries | | |
| Ternary Search Tries | | |
| Knuth−Morris−Pratt | | |
| Boyer−Moore | | |
| Rabin–Karp | | |
| Regular Expression Matching | | |
| Run-Length Coding | | |
| Huffman Coding | | |
| LZW Compression | | |
| Burrows−Wheeler Transform | | |
### Chapter 6. Context
Networking: Ford-Fulkerson

## Coursera Assignments
[1.1 Percolation](https://github.com/anthonygraca/algorithms/tree/main/src/main/java/io/anthonygraca/princeton/chapter1/percolation) \
[1.2 Deque](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/deque/Deque.java) & [Randomized Queue](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/randomized_queue/RandomizedQueue.java) \
[1.3 Collinear Points](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter2/CollinearPoints/FastCollinearPoints.java) \
[1.4 Slider Puzzle](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter2/EightPuzzle/) \
[2.1 WordNet](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter4/WordNet/) 
## Resources Used
### Java
[Sedgewick - Algorithms, Fourth Edition](https://www.amazon.com/Algorithms-4th-Robert-Sedgewick/dp/032157351X) \
[Algorithms, Part 1 on Coursera](https://www.coursera.org/learn/algorithms-part1/home/info) \
[Algorithms, Part 2 on Coursera](https://www.coursera.org/learn/algorithms-part2/home/info)
### C++
[Stroustrup - The C++ Programming Language, Fourth Edition](https://www.amazon.com/C-Programming-Language-4th/dp/0321563840)
