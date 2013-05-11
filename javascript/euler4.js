'use strict';

function isPalindrome(str) {
  return str === str.split('').reverse().join('');
}

var largestPalindrome = 0;
for(var i = 100; i < 1000; i++) {
  for(var j = 100; j < 1000; j++) {
    var num = i * j;
    if (isPalindrome('' + num)) {
       largestPalindrome = Math.max(largestPalindrome, num);
    }
  }
}
console.log(largestPalindrome);
