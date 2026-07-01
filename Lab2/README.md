# DCIT 204 – Lab 2: Interactive Array Algorithms

## Overview
This lab implements two fundamental array algorithms as interactive
console applications using Java's `Scanner` class:

1. **FindMax.java** – Finds the maximum value in an array and its index.
2. **PairSum.java** – Uses a brute-force nested-loop search to find a
   pair of numbers in an array whose sum equals a user-supplied target.

## Files
```
Lab2/
│
├── FindMax.java
├── PairSum.java
└── README.md
```

## How to Compile and Run

### Find Maximum
```bash
javac FindMax.java
java FindMax
```
Example session:
```
Enter the number of elements in the array: 5

Enter 5 integer value(s):
  Element[0]: 12
  Element[1]: 45
  Element[2]: 3
  Element[3]: 78
  Element[4]: 22

===================================
        FIND MAXIMUM - RESULTS
===================================
Array Entered : [12, 45, 3, 78, 22]
Maximum Value : 78
Found At Index: 3
===================================
```

### Pair Sum (Brute Force)
```bash
javac PairSum.java
java PairSum
```
Example session:
```
Enter the number of elements in the array: 4

Enter 4 integer value(s):
  Element[0]: 2
  Element[1]: 7
  Element[2]: 11
  Element[3]: 15

Enter the Target Sum: 9

===================================
         PAIR SUM - RESULTS
===================================
Array Entered : [2, 7, 11, 15]
Target Sum    : 9
Pair Found!
  Index 1 : 0  ->  Value: 2
  Index 2 : 1  ->  Value: 7
  Equation: 2 + 7 = 9
===================================
```

## Algorithm Notes

### Find Maximum – O(n)
The array is scanned once, keeping track of the index of the largest
value seen so far. Each element is compared exactly one time, so the
algorithm runs in linear time.

### Pair Sum (Brute Force) – O(n²)
Two nested loops compare every possible pair of elements `(i, j)` with
`j > i`. If a pair whose sum equals the target is found, its indices,
values, and the equation are displayed immediately. If the loops
complete without finding a match, the program reports that no pair
exists.

## Input Validation
Both programs validate user input:
- Array size must be a positive integer (Pair Sum requires at least 2
  elements to form a pair).
- Non-integer input is rejected and the user is re-prompted.

## Author
Completed as part of DCIT 204 – Lab 2 Assignment.
