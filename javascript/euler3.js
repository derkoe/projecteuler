'use strict';

/**
 * Run callback for all primes below n
 */
function primeSieve(n, callback) {
  var primes = [], i, p;
  var iNotDividableBy = function(p) {
    return i % p !== 0;
  };
  for (i = 2; i <= n; i++) {
    if (primes.every(iNotDividableBy)) {
      primes.push(i);
      if (callback) {
        callback(i);
      }
    }
  }
  return primes;
}

var n = 600851475143, mult = 1;
primeSieve(600851475143 / 2, function(i) { 
  if (n % i === 0) {
    mult *= i;
    if (mult === n) {
      console.log(i); 
      process.exit();
    }
  }
});
