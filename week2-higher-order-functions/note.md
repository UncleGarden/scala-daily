Functional languages treat functions as 'first-class' values, means like any other value, a function can be pass as a parameter and returned as a result.

Higher order functions - 
	Functions take other functions as parameters or that return functions as results.
	
Example:
def sum(f: Int => Int, a: Int, b: Int): Int = 
	if (a > b) 0
	else f(a) + sum(f, a+1, b)

//we can write:
def sumInts(a: Int, b: Int)       = sum(id, a, b)
def sumCubes(a: Int, b: Int)      = sum(cube, a, b)
def sumFactorials(a: Int, b: Int) = sum(fact, a, b)

//where
def id(x: Int): Int   = x
def cube(x: Int): Int = x * x * x
def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)


Function Type
Type A = > B is the type of a function that takes an argument of type A and returns a result of type B.

Example:
Int => Int is the type of functions that map integers to integers.


Anonymous functions - Function without giving a name
Example:
(x: Int) => x * x * x

(x: Int) is the parameter of the function,
x * x * x is the body.

(x: Int, y: Int) => x + y

====
Based on the two examples above:
def sumInts(a: Int, b: Int)  = sum(x => x, a, b)
def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
====











