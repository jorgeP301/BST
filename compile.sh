#!/bin/bash --verbose
javac -d bin src/cs2720/bst/NodeType.java
javac -d bin -cp bin src/cs2720/bst/BinarySearchTree.java
javac -d bin -cp bin src/cs2720/bst/BinarySearchTreeDriver.java
java -cp bin src/cs2720/bst/BinarySearchTreeDriver.java string-input.txt
