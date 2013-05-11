'use strict';

function fib(n) {
  if (n < 2) {
    return 1;
  }
  return fib(n-1) + fib(n-2);
}

var i = 1, fibVal = 1, sum = 0;
while (fibVal < 4000000) {
  fibVal = fib(i++);
  if (fibVal % 2 === 0) {
    sum += fibVal;
  }
}

console.log(sum);
