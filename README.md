# ID1021_assignment2 ![Maven build status](https://github.com/Lellalu/ID1021_assignment2/actions/workflows/maven.yml/badge.svg)

This is an assignemnt for the course ID1201, Algorithms and Data Structures, at KTH Royal Institute of Techonology. This assignment is about using various searching methods to implement search an element in an array and search for duplicates between two arrays.

## How run

This is an example of how to compile and test this project.

```bash
mvn clean && mvn compile && mvn test
```

In main, we have implemented a benchmark separately for searching an element in arrays and find duplicates in two arrays, see [Main.java](https://github.com/Lellalu/ID1201_assignmnet2/blob/main/src/main/java/se/kth/id1201/Main.java) for more details. To run this:

```bash
mvn exec:java -Dexec.args="searchBenchmark"
```
or:
```bash
mvn exec:java -Dexec.args="duplicateBenchmark"
```
