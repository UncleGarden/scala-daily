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


===========================================

Expansion of Multiple Parameter Lists

In general, a definition of a function with multiple parameter Lists
		def f(args1)...(argsn) = E
		
where n > 1, is equivalent to 
		def f(args1)...(argsn-1) = { def g(argsn) = E; g}
where g is a fresh identifier. Or even shorter using anonymous function:
		def f(args1)...(argsn-1) = (argsn => E)


repeat the process n times
		def f = (args1 => (args2 => ..(argsn => E)))
		
This style of definition and function application is called currying.

Exercise:
def product(f: Int => Int)(a: Int, b: Int): Int = 
	if (a > b) 1
	else f(a) * product(f)(a+1, b)
product(x => x*x)(3, 4) //144
	
def fact(n: Int) = product(x => x)(1, n)
fact(5) //120

def mapReduce(f: Int: Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
	if(a > b) zero
	else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

=== re-write product
def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x*y, 1)(a, b)
===


===========================================


