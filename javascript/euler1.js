'use strict';

function euler1(n) {
  var i, sum = 0;
  for(i = 0; i < n; i++) {
    if(i % 3 === 0 || i % 5 === 0) {
      sum += i;
    }
  }
  return sum;
}

console.log(euler1(1000));
