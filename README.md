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
4. `mvn install:install-file -Dfile=/path/to/algs4/target/algs4-1.0.0.0.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0 -Dpackaging=jar`

#### Normal Usage
`mvn package` to compile and package. \
`java -jar target/<name-of-file>.jar` to run the compiled code \

`mvn test` to build and run tests.

### C++ Code with CMake
[CMake](https://cmake.org/) (version >= 3.19.7) is the build tool that manages all of the C++
code in this project. Code is compiled with a C++14 compiler.

#### Normal Usage
Do the "cmake dance". \
`mkdir build` to create a separate build folder to isolate generate cmake build
files. \
`cd build` to enter build folder. \
`cmake ..` to tell cmake to look at the CMakeLists.txt at project root. \
`make && make test` to compile source and run tests.

### Python Code with VirtualEnv
`pip3 install virtualenv`

## Table of Contents
### Chapter 1. Fundamentals
| Topic | C++ | Java |
|-------|-----|------|
| Stacks | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/cpp/io/anthonygraca/princeton/chapter1/stack) | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/stack) |
| Queues | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/queue) |
| Bags   | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/bag) |
| Deque  | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/deque/) |
| Union Find | | [:heavy_check_mark:](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/UnionFind.java) |
### Chapter 2. Sorting
Insertion Sort \
Selection Sort \
ShellSort \
QuickSort \
MergeSort \
HeapSort \
Binary Heaps
### Chapter 3. Searching
Binary Search Trees \
Red-Black Trees \
Separate Chaining Hash Tables \
Linear Probing Hash Tables \
Graham Scan \
k-d trees
### Chapter 4. Graphs
Depth-First Search \
Breadth-First Search \
Topological Sort \
Kosaraju−Sharir \
Kruskal \
Prim \
Dijkistra \
Bellman−Ford
### Chapter 5. Strings
LSD Radix Sort \
MSD Radix Sort \
3-Way Radix QuickSort \
Multiway Tries \
Ternary Search Tries \
Knuth−Morris−Pratt \
Boyer−Moore \
Rabin–Karp \
Regular Expression Matching \
Run-Length Coding \
Huffman Coding \
LZW Compression \
Burrows−Wheeler Transform
### Chapter 6. Context
Networking: Ford-Fulkerson

## Coursera Assignments
[1.1 Percolation](https://github.com/anthonygraca/algorithms/tree/main/src/main/java/io/anthonygraca/princeton/chapter1/percolation) \
[1.2 Queue](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/deque/Deque.java)

## Resources Used
### Java
[Sedgewick - Algorithms, Fourth Edition](https://www.amazon.com/Algorithms-4th-Robert-Sedgewick/dp/032157351X) \
[Algorithms, Part 1 on Coursera](https://www.coursera.org/learn/algorithms-part1/home/info)
### C++
[Stroustrup - The C++ Programming Language, Fourth Edition](https://www.amazon.com/C-Programming-Language-4th/dp/0321563840)
