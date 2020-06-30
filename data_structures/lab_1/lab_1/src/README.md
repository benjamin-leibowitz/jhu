# LAB 1 - Stacks - Benjamin Leibowitz

## About this program
This lab tests 6 different languages, for input strings from any number of input files.
For a given string, w, the following are the rules for which the program tests.

1. w contains equal numbers of A&#39;s and B&#39;s (in any order) and no other characters
2. w is of the form A^n B^n , for some n > 0
3. w is of the form A^n B^2n , for some n > 0
4. w is of the form (A^n B^m )^p , for some m,n,p > 0
5. w is a palindrome with the letter A in the middle (can only contain one "A")
6. w has no identical consecutive letters

If a given string follows the language, the program will print true, otherwise false.

## Running this program
The java code has already been compiled, to run it, please navigate to the src folder
and run the following command:
```
java Test.java {file-name-1} {file-name-2} ... {file-name-n}
```
where file-name-i is a .txt file with one row per string to be tested.
