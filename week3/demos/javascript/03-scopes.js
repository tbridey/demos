/**
 * JSDoc Comments
 *
 * or JavaDoc (if used in Java, same syntax)
 *
 * Will display this information in the popup for
 * whatever code is below this comment.
 */
function testFunc() {
}

/**
 * JavaScript has 2 main scopes:
 *
 * Global and function scope
 *
 * We saw a bit about this early in JavaScript's hoisting
 * feature.
 *
 * Variables of functional scope are only available within that function
 *
 * One feature that ties into this is that JavaScript allows
 *
 * defining functions nested inside other functions.
 */

function outer() {
  var a = 'hello';
  var num = 15;

  function inner() {
    var obj = {
      key1: 'value1'
    };

    console.log(a);
    console.log(num);
    console.log(obj);
  }

  // console.log(obj);
  // The above statement throws an error
  // obj is not available in the outer function

  // Once declared, we can invoke the nested functions

  inner();
}

outer();


// With the introduction of ES6, we have block scope introduced

// So we can have local variables declared inside a block, like
// an if-statement, and the contents will not be hoisted outside the scope

// However, block scope only works with let and const

function myFunc2() {

  if(true) {
    var a = 33;
  }

  console.log(a); // This works, and prints 33
}

myFunc2();

function myFunc3() {

  if(true) {
    let a = 33;
    // const b = 33;
  }

  console.log(a); // This doesn't work
  // console.log(b);
}

// myFunc3();

let other = myFunc3;

console.log(typeof(other));

// other();

other.myVal = 33;

console.log(other.myVal);

console.log(typeof(other));
