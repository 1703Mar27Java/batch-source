var homework = {};
module.exports = homework;

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/

homework.fibonacci = function(n){
	//yay recursion
	//a super simple algorthm if implemented recursively
	if(n==1) 
		return 1;
	if(n==2)
		return 1;
	else 
		return homework.fibonacci(n-2)+homework.fibonacci(n-1);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	//any sorting algorithm will work here.
    //I will use bubble sort since it's easy to understand
    var length=array.length;
    for (var i =length - 1; i >= 0; i--) {
        for (var j = 0; j <= i; j++) {
            if (array[j + 1] < array[j]) {
                var t = array[j];
                array[j] = array[j + 1];
                array[j + 1] = t;
            }
        }
    }
    return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
	//another easy recursive implementation
	if (n==1) return 1;
	else return n*homework.factorial(n-1);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

	1,2,3,4,5
	2,3,4,5,1
*/
homework.rotateLeft = function(array, n) {
	var len=array.length;
	for(var i = 0; i<n;i++){
		var t=array[0];
		for(var j=0; j<len-1;j++){
			array[j]=array[j+1];
		}
		array[j]=t;
	}
	return array;
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
	//simple operation utilizing a stack
	var len = bracketString.length;
	var stack =[];
	for(var i = 0; i<len;i++){
		//simply check the current val.
		//if opening bracket, we add it to the stack
		//if closing bracket, we pop the stack and compare values.
		if(bracketString[i]=="(") stack.push("(");
		else if(bracketString[i]=="{") stack.push("{");
		else if(bracketString[i]=="[") stack.push("[");
		else if(bracketString[i]==")") {
			if (stack==[]) return false;
			if (stack.pop() != "(") return false;
        }
		else if(bracketString[i]=="}") {
			if (stack==[]) return false;
			if (stack.pop() != "{") return false;
        }
		else if(bracketString[i]=="]") {
			if (stack==[]) return false;
			if (stack.pop() != "[") return false;
        }
    }	
	if (stack.length==0) return true;
	else return false;
};

