/*
There are several datatypes in JS:

string
number (both whole numbers and decimal values)
boolean
object
undefined
null*
function*
*/

function logType(input) {
  console.log('input is:');
  console.log(input);
  console.log('And its type is ' + typeof(input));
}

logType(5);

logType(33.55); // are numbers

/*
JavaScript has a "feature" called hoisting.

So, for any variable declared with var, the actual declaration will be
"hoisted" to the top of its scope. In this particular case, it is hoisted
to the top of the global scope. So the variable "a" is globally accessible,
even before it has a value assigned.
*/

logType(a); // is undefined and type undefined
var a = 'Something';
logType(a);

/*

In 2015, with ES6, there were 2 new declarations that can be
used to declare variables called "let" and "const".

"const" is effectively the same as "final" in java. It just means
the value cannot be reassigned. (However, objects can be modified)

Neither let or const leverage hoisting.
*/

// logType(b);
// logType(c);
// The above 2 statements throw an error.

let b = "other";
const c = "other2";

b = "something else";

logType(b);

// c = "something else 2";
// The above statement throws an error

logType(false); // is a boolean

// In JS, curly braces can indicate object literals
logType({}); // Is an object

// Every use of the object literal syntax will construct a new object

// Objects in JavaScript are sort of like Maps in Java
// Except that the keys are always strings
// They are just key-value pairs.

logType({
  key1: 1,
  key2: true,
  key3: 'value3'
}); // Is an object

let myObj = {
  key1: 1,
  key2: true,
  key3: 'value3', // In JS, trailing commas are allowed
};
// In fact, trailing commas can actually be quite helpful

logType(myObj.key1); // 1 is a number
logType(myObj["key3"]); // value3 is a string
// 2 different ways to access values from a JS Object

// JSON
/*
JavaScript Object Notation

Other languages will be able to interpret this notation
into similar constructs for those specific languages

This allows different programming languages to communicate
with each other through JSON or other language agnostic formats

*/
// Multi-line strings constructed using the grave key: `
let inputString = `
{
  "key1": 1,
  "key2": true,
  "key3": "value3"
}`;

logType(inputString); // JSON is a string or text

let obj = JSON.parse(inputString);

logType(obj); // Objects are objects in memory

logType(JSON.stringify(obj)); // Convert the object back into a string

logType(JSON);
logType(JSON.stringify(JSON));

logType(null); // is an object

logType(NaN); // NaN is a number

console.log(NaN == NaN); // == performs type coercion

console.log('5' == 5); // true
console.log('5' === 5); // false

console.log(NaN === NaN); // === does not perform type coercion
// false

console.log(isNaN(NaN)); // true
// isNaN is a built in global function whose purpose is to check whether a value
// is NaN or not.

let myVar = NaN;
myVar = 1 / 'Hello';

if(isNaN(myVar)) {
  console.log('It was!');
}


logType([1, 2, 3]);

logType([1, 'Larry', undefined, NaN, false]); // Perfectly valid

console.log(JSON.stringify([1, 'Larry', undefined, NaN, false]));

console.log([,,] == ','); // true
console.log([,,] === ','); // false

console.log(1 / 0); // Infinity is a number

logType(Infinity); // Infinity is a number

logType(1 / -Infinity); // -0 and a number

console.log(0 == -0); // true
console.log(0 === -0); // true

logType(Infinity / -Infinity); // NaN

logType(5 + '5'); // 55 and a string

logType(5 + +'5'); // 10 and a number

console.log({} == {}); // false
console.log({} === {});// false

// Objects are not equal to other objects

logType(false + true); // 1 and it's a number

logType(true + true); // 2 and it's a number

/*
  JavaScript's == operator is called "comparison" or "loose comparison"

  and the === operator is called "strict comparison"
*/

console.log(null == {}); // false
console.log(null == []); // false
console.log(null == ''); // false
console.log(null == 0); // false
console.log(null == undefined); // true
console.log(null === undefined); // false
console.log(null === null); // true

logType(logType);

console.log(`${logType}`);
