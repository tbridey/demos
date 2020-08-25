function add(a = 0, b = 0, c) {
  console.log(c);
  return a + b;
}
// We can provide default values for parameters

// We can leave parameters out when invoking, and they
// will receive the default value
// Note however, that any parameters included will
// be interpreted in order as parameters

console.log(add(1, 2));
// As this shows, we can leave off parameters
// the value for that parameter will be undefined, or use the default value

console.log(add(1, 2, "larry"));


// We can also include extra parameters
// These will just be ignored
console.log(add(1, 2, 3, 4, 5, 6, 7, 8));

// This just like lambdas in Java
// It is referred to as arrow notation
let otherAdd = (one, two) => {
  return one + two;
}

console.log(otherAdd(5, 6));

console.log(otherAdd('String1', 'String2'));


// JavaScript's spread operator syntax that lets us accomplish
// varargs
function varargs(...stuff) {
  stuff.forEach( param => {
    console.log(param);
  });
}

// Please explore the use cases for the spread operator
// in your own research

varargs(1, 2, 3, 4, {}, 'Test string', varargs, undefined);
