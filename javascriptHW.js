var homework = {};
module.exports = homework;

homework.fibonacci = function(n){
	if(n == 0){ return 0;}
	if(n == 1){return 1;}
	n = fibonacci(n-1) + fibonacci(n-2);
	return n;
}

homework.sort = function(arr){
	for(var current = 0; current < arr.length; current++){
		var smallestIndex = current;
		for(var i = current; i < arr.length; i++){
			if(arr[i] < arr[smallestIndex]){
				smallestIndex = i;
			}
		}
		var temp = arr[current]; 
		arr[current] = arr[smallestIndex];
		arr[smallestIndex] = temp;
	}
	return arr;
}

homework.factorial = function(n){
	if(n == 1){return 1;}
	return n*factorial(n-1);
}

homework.rotateLeft = function(array, n){
	var temp = 0;
	var first= 0;
	for(var j = 0; j < n; j++){
		first = array[0];
		for(var i = 1; i < array.length; i++){
			array[i-1] = array[i];
			if(i==array.length-1){
				array[i] = first;
			}
		}
	}
	return arr;
}

homework.balancedBrackets = function(bs){
	if(bs.length%2 != 0){
		return false;
	}else{
		var mid = bs.length/2;
		var count = 0;
		for(var i = 0; i < mid; i++){
			if(bs.charAt(i) == "("){
				if(bs.charAt(bs.length-1-i) == ")"){count++;}
			}
			if(bs.charAt(i) == "{"){
				if(bs.charAt(bs.length-1-i) == "}"){count++;}
			}
			if(bs.charAt(i) == "["){
				if(bs.charAt(bs.length-1-i) == "]"){count++;}
			}
		}
		if(count == mid){return true;}
	}
	return false;
}