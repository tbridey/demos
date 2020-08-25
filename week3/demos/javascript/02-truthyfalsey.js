/*
JavaScript has a lot of type coercion/casting features

Specifically, JavaScript is able to coerce every value into a boolean

Every value will be either a "truthy" or "falsey" value

"truthy" values means that the value will be coerced into true
"falsey" values means that the value will be coerced into false
*/

// The multi-line string using the grave key or backtick
// are called template literals
// They are similar to string literals, except they support
// string interpolation
// Note that they will interpolate the value when the string
// is being constructed and from then on, it is just a static
// string

// The interpolated values will NOT be updated in the future

function checkTruthy(input) {
  console.log(
    `input = ${input}, and the type is ${typeof(input)}
    and the truthy/falsey value is ${!!input}`
  );
}

checkTruthy(true); // truthy

checkTruthy(2); // true?
checkTruthy(1); // true?
checkTruthy(-1); // false?
checkTruthy(0); // false? ===== FALSEY
// All numbers aside from zero are truthy

checkTruthy(-0); // false? ==== FALSEY

checkTruthy(NaN); // true? === falsey
checkTruthy(Infinity); // true? === truthy
checkTruthy(-Infinity);// true? === truthy

checkTruthy(null); // false?
checkTruthy(undefined); // false?
// Yes, null and undefined are falsey

// All of the 4 below are truthy, since all objects are truthy
checkTruthy({}); // true?
checkTruthy([]); // true?
checkTruthy({key1: 'value1'}); // true?
checkTruthy([1,2,3]); // true?

checkTruthy(checkTruthy); // truthy


checkTruthy('true'); // true? Yes, truthy
checkTruthy('false'); // false? true? ==== truthy
checkTruthy(''); // falsey

// Only the empty string is falsey
// all other strings are truthy

// Falsey values:

// false
// empty string
// null
// undefined
// NaN
// zero

// Everything else is truthy


let myObj2 = {};

let myObj3 = myObj2

console.log(myObj3 == myObj2); // comparing memory locations
