var homework = {};

//1. nth Fibonacci sequence
//------------------------------------------------------
homework.fibonacci = function(n)
{
	if(n===0)
	{
		return 0;
	}
	else if (n ===1  || n===2)
	{
		return 1;
	}
	else
	{
		var fib1 = 1;
		var fib2 = 1;
		var temp;
		for(var i = 2; i <n; i++)
		{
			temp = fib2;
			fib2 = fib1 + fib2;
			fib1 = temp;
		}
		return fib2;
	}
};
//------------------------------------------------------------



//2. Array sort
//------------------------------------------------------------
homework.sort = function(array)
{
	var min;
	for(var i = 0; i < array.length; i++)
	{
		min = array[i];
		for(var j = i; j < array.length; j++)
		{
			if(array[j] < array[i])
			{
				min = array[j];
				array[j] = array[i];
				array[i] = min;
			}
		}
	}
	return array;
};
//----------------------------------------------------------------

//3.factorial of n
//----------------------------------------------------------------
homework.factorial = function(n)
{
	if(n === 0) return 1;
	else
	{
		var running = 1;
		for(var i = 1; i <= n; i++)
		{
			running = running * i;
		}
		return running;
	}
};
//---------------------------------------------------------------


//4.Rotate array left
//---------------------------------------------------------------
homework.rotateLeft = function(array, n){
	var oldArray = array;
	for(var i = 0; i < n; i++){
		var newArray = [];
		for(var j = oldArray.length-1; j > 0; j--){
			newArray[j - 1] = oldArray[j];
		}
		newArray[oldArray.length-1] = oldArray[0];	
		oldArray = newArray;
	}
	return newArray;
};


//5. Balanced Brackets
//----------------------------------------------------------------
homework.balancedBrackets = function(bracketsString){
	var mrStack = [];
	for(var i = 0; i < bracketsString.length; i++){
		//push cases
		if(bracketsString.charAt(i) === "("){
			mrStack.push("(");
		}
		
		else if(bracketsString.charAt(i) === "{"){
			mrStack.push("{");
		}
		
		else if(bracketsString.charAt(i) === "["){
			mrStack.push("[");
		}
		
		
		//empty stack cases
		else if(bracketsString.charAt(i) === ")" && mrStack.length===0){
			break;
		}
		
		else if(bracketsString.charAt(i) === "}" && mrStack.length===0){
			break;
		}
		
		else if(bracketsString.charAt(i) === "]" && mrStack.length===0){
			break;
		}
		
		
		//pop cases
		else if(bracketsString.charAt(i) === ")"){
			if(mrStack[mrStack.length - 1] === "("){
				mrStack.pop();
			}
		}
		
		else if(bracketsString.charAt(i) === "}"){
			if(mrStack[mrStack.length - 1] === "{"){
				mrStack.pop();
			}
		}
		
		else if(bracketsString.charAt(i) === "]"){
			if(mrStack[mrStack.length - 1] === "["){
				mrStack.pop();
			}
		}
	}
	
	if (mrStack.length === 0) return true;
	else return false;
};