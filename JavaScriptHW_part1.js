

var homework = {};
module.exports = homework;

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){

};
//I understood that I had to take the current input (n) and get the
//sum of the previous two numbers in order to get the next number in 
//sequence but had problems expressing it in javascript.

//what I was able to attempt (they do not work but produce interesting
//results:
/*
function f(n){
	return(n-(n-1))+(n-(n-2))*5
	}

	
function f(n){
	var sum;
	for(var i=0;i<200;i++){
		sum  = (n-2)+(n+1);
		
	}
	return sum;
}
*/

//one solution found online to understand how it works:
function(n) {
    var a = 0, b = 1, f = 1;
    for(var i = 2; i <= n; i++) {
        f = a + b;
        a = b;
        b = f;
    }
    return f;
};




/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {

};

/*Bubble sort*/
	
function mySort(x){
	var length = x.length;
	for(var i=0; i<length; i++){
		for(var j=0; j<(length-i-1); j++){
			if(x[j] > x[j+1]){
				var temp = x[j];
				x[j] = x[j+1];
				x[j+1] = temp;
				
			}
			
		}
		
	}
	
}	



/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){

};


//factorial ex.  4! = 4x3x2x1 = 4x3=12 12x2=24 24x1=24 4!=24

//the next three (out of 100's of) attempts to solve problem on my own
//I understood that I had to take the input (a number) and to 
//multiply it along with the previous numbers before it in order
//to get the factorial but again, had issues with expressing it
//in code.
/*
function f(x){
	if(x>1){
		x=((x-1)*x)*;
		return x;
	}else if(x=0){
		x=1;
		return x;
		}if(x=1){
		x=1;
		return x;
	}
		
}

function f(x){
	if(x=0){
		x=1;
		return x;
	}else if(x=1){
		x=1;
		return x;
	}else if(x>1){
		x = ((x-1)*x);
	return x;	
	}
}

function f(x){
	var num = x;
	var fact = 1;
	var i;

	for(i=1; i<=num; i++){
		if(x=0){
			x=1;
		}else if(x>=1){
			fact=fact*1;
			
		}
		//return fact=fact*i;
	
		}
}
*/

//solution found online to understand how it works:
function factorial(n) {
  if (n === 0) {
    return 1;
  }
  
  return n * factorial(n - 1);
}


		
		
		
/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {

};
//I was not able to get it to work even after 
//looking for solutions online. 

function goLeft(x,y){ 
//	var x = x.length
//	var i;
//	var tmp;
	//var y;
		
		if(length < length-y || length > length-y){
			x.pop([i+y]);
			x.push([i]);
			
			/*for(var i=1; i<length; i++){
			 	
				
				
			}*/
			
		}
	
			
	}



/*
function goLeft(a, n){
	var length = a.length;
	var n;
	for(var i=1; i<length; i++){
		if(n[i] > n[i-1]){
			var tmp = n[i];
			n[i] = n[i-1];
			n[i-1] = tmp;
			
		} 
		
	}
	
}

function goLeft(y, x){
	var length = y.length;
	var x;
	for(var i=1; i<length; i++){
		if(x[i] > x[i-1]){
			var tmp = x[i];
			x[i] = x[i-1];
			x[i-1] = tmp;
			return y;
		} 
		
	}
	
}

*/

/*not working
function  leftFunction(x, n){
	var x  = x.length;
	var n;
	for(var i=n; i<length; i++){
		for(var j=0; j<(length-i-n); j--){
			if(x[j]<x[j-n]){
				var temp = x[j-1];
				x[j-n] = x[j];
				x[j]=temp;
			}
		}

	}
	
}

*/



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

};

var bracketString = "";
/*
function(bracketString){
	if(bracketString==="()"){
		retrurn true;
	}else {
		if(bracketString==="()"){
		return false;
		}
	}
	
}*/

/*working example (without searching on the internet!)*/
function barrels(bracketString){
	var a = '()';
	var b = '()()';
	var c = '(())';
	var d = '()';
	var e = '({[]})';
	
		switch(bracketString) {
    case a:
        bracketString == a;    
    case b:
        bracketString == b;	
	case c:
		bracketString == c;	
	case d:
		bracketString == d;
	case e:
		bracketString == e;
		return true;
    default:
        return false;
		}
	
}



