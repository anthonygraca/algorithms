# Data Structures & Algorithms

## How to Build
### Java Code with Maven
[Maven](https://maven.apache.org/) is the build tool that manages all of the
Java source code in this project. 

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

## Table of Contents
### Chapter 1. Fundamentals
[Binary Search](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/BinarySearch.java) \
[Stacks](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/Stack.java) \
[Queues](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/Queue.java) \
[Bags](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/Bag.java) \
[Deque](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/deque/Deque.java) \
[Union Find](https://github.com/anthonygraca/algorithms/blob/main/src/main/java/io/anthonygraca/princeton/chapter1/UnionFind.java)
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
[Sedgewick - Algorithms, Fourth edition](https://www.amazon.com/Algorithms-4th-Robert-Sedgewick/dp/032157351X) \
[Algorithms, Part 1 on Coursera](https://www.coursera.org/learn/algorithms-part1/home/info)
