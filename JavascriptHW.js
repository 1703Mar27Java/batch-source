var homework = {};
module.exports = homework;

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){

if(n  == 0 ){	
	return 0;
}
	
return n + this.fibonacci(n-1);

};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
 
*/
homework.sort = function(array) {
	 var j;
     var flag = true;  
     var temp;   

     while ( flag )
     {
            flag= false;    
            for( j=0;  j < array.length -1;  j++ )
            {
                   if ( array[ j ] > array[j+1] )   
                   {
                           temp = array[ j ];                
                           array[ j ] = array[ j+1 ];
                           array[ j+1 ] = temp;
                          flag = true;             
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
	if(n == 0)
		return 1;

	return n * this.factorial(n-1);

};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	var result = [array.length];
	
	for(var i = 0; i< array.length; i++){
		result[(i+n)%array.length] = array[i];
	}
	
	return result;
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
	var check;
	var stack = [];
	for(var i = 0; i < bracketsString.length ; i++){
		
			if(bracketsString[i] == "("){
				stack.push("(");
			} else if(bracketsString[i] == "{"){
				stack.push("{");
			} else if(bracketsString[i] == "["){
				stack.push("[")
			} else{
				check = stack.pop(); 
				if(check == "("){
					check = ")";
				} else if (check == "{"){
					check = "}";
				} else if (check == "["){
					check = "]";
				}
				if(check != bracketsString[i] || check==null){
					return false;
				}
			}
		}
		
	if(stack.length > 0){
		return false;
	}
		
	return true;
	};
