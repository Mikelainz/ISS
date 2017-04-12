/**
 * 
 */
count = 0;
function fibonacci(n){
		if ( n == 1 || n == 2){
			count++
			return 1;
		}
		else{
			count++;
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
console.log(Date());
console.log(fibonacci(55));
console.log(Date());
console.log(count);