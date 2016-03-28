Evaluation Strategy

1. Call By Value
	It evaluates every function argument only once.

2. Call By Name
	a function argument is not evaluated if the corresponding parameter is unused in the evaluation of the function body.
	
Example:
def Test(x: Int, y: Int) = x * x

Test(7, 8) -> same steps

Test(3+4, 8) -> CBV
CBV - Test(7, 8) - 7*7 - 49
CBN - (3+4) * (3+4) - 7 * (3+4) - 7*7 - 49

Test(7, 2*4) -> CBN
CBV - Test(7, 8) - 7*7 -49
CBN - 7*7 -49

Test(3+4, 2*4) -> same steps
CBV - Test(7, 2*4) - Test(7, 8) - 7*7 -49
CBN - (3+4) * (3+4) - 7 * (3+4) - 7*7 - 49

=========================================

Termination

**If CBV evaluation of an expression e terminates, then CBN evaluation of e terminates, too.
But the other direction is not true.**

Example:
def Test(x: Int, y: Int) = x

Test(1, loop) 

CBN -> 1
CBV -> Test(1, loop)  -Test(1, loop)  - Test(1, loop) ...



* Scala evaluation strategy - CALL-BY-VALUE
But if the type of a function parameter starts with =>, it uses call by name.

Example:
def constOne(x: Int, y: => Int) = 1

constOne(1+2, loop) - constOne(3, loop) - 1
constOne(loop, 1+2) - constOne(loop, 1+2) - constOne(loop, 1+2) - ...

=========================================

Conditionals 

If-else, looks like it in Java, but is used for expressions, not statements.

Example: def abs(x: Int) = if (x >= 0) x else -x

x >= 0 is a predicate, of type Boolean

=========================================

Value Definitions

The '''def''' form is "by-name", its right hand side is evaluated on each use.
The '''val''', is "by-value".

Example:
val x = 2
val y = square(x)

The right-hand side of a val definition is evaluated at the point of the definition itself.
For instance, y above refers to 4, not square(2).


Value Termination

The difference between val and def becomes apparent when the right side does not terminate.

Example:
def loop: Boolean = loop

def x = loop  [OK]
val x = loop  [... lead to an infinite loop]


Example:
re-write without &&: and(x, y) == x&&y

def and(x: Boolean, y: => Boolean) = //y, call be Name
	if (x) y else false

=========================================

Blocks

Example:

val x = 0
def f(y: Int) = y + 1
val result = {
	val x = f(3)
	x * x
} + x

1. The definition inside a block are only visible from within the block.
2. The definition inside a block shadow definition of the same names outside the block.


Lexical Scope
Definition of outer blocks are visible inside a block unless they are shadowed. Therefore, we can eliminate the redundant occurrences of parameters.

=========================================

Tail Recursion
	- If a function calls itself as its last action, the function's stack frame can be reused.
	
Tail Recursion functions are iterative processes.

Example:
[YES]
def gcd(a: Int, b: Int): Int = 
	if (b == 0) a else gcd(b, a%b)

[NO]
def factorial(n: Int): Int = 
	if(n == 0) 1 else n * factorial(n - 1)
	
[re-design]
def factorial(n: Int): Int =
	def loop(current: Int, n: Int): Int = 
		if (n == 0) current
		else loop(current * n, n -1)
	loop(1, n)
	


 

