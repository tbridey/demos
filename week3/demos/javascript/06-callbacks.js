// A callback function is simply a function that is passed in as a parameter
// to another function
// This is a very common use-case for functions in JavaScript


// Pre-assumption: callback function can accept 2 number parameters
function caller(callback) {
  console.log(`Caller function invoked with param ${callback}`);
  callback(5, 6);
}

function other(one, two) {
  console.log(`First param: ${one}`);
  console.log(`Second param: ${two}`);
  console.log(`The result is: ${one + two}`);
}

caller(other);

caller( (one, two) => {
  console.log(one);
  console.log(two);
});
