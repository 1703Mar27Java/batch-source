/**
 * 
 */

function makeCount(noun) {
	var count = 0;
	return function() {
		count = count + 1;
		console.log(noun+"count is: "+count);
		return count;

	};
}

