'use strict';

var http = require('http'), url = require('url');

function maxPathSum(triangle) {
  var calcMaxPathValueCache = {}, calcMaxPathValue, calcMaxPathValueCached, i, max = 0;

  calcMaxPathValue = function(row, col) {
    if (row === 0) {
      return triangle[0][0];
    }
    var curVal = triangle[row][col];
    if (col === 0) {
      return curVal + calcMaxPathValueCached(row - 1, col);
    } else if (col === triangle[row].length - 1) {
      return curVal + calcMaxPathValueCached(row - 1, col - 1);
    } else {
      return curVal + Math.max(calcMaxPathValueCached(row - 1, col - 1), calcMaxPathValueCached(row - 1, col));
    }
  }

  calcMaxPathValueCached = function(row, col) {
    var val = calcMaxPathValueCache[row + ',' + col];
    if (!val) {
      val = calcMaxPathValue(row, col);
      calcMaxPathValueCache[row + ',' + col]= val;
    }
    return val;
  }

  for (i = 0; i < triangle[triangle.length - 1].length; i++) {
    max = Math.max(max, calcMaxPathValueCached(triangle.length - 1, i));
  }
  return max;
}

function parseTriangle(data) {
  var rows = data.split('\n');
  rows.pop(); // remove last empty line
  return rows.map(function(row) {
    return row.split(' ').map(function(col) {
      return parseInt(col, 10);
    });
  });
}

var triangleStr = '';
http.get(url.parse('http://projecteuler.net/project/triangle.txt'), function(res) {
  res.on('data', function (data) {
    triangleStr += data;
  });
}).on('close', function() {
  console.log(maxPathSum(parseTriangle(triangleStr)));
});
