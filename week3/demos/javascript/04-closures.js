'use strict'; // Enable strict mode

var x = function cake() {

  var flour = true;
  var cornMeal = false;
  var cupsOfSugar = 1;

  function bake() {
    var heat = 350;

    console.log("Baking cake at " + heat + " degrees");
    console.log("Do we have flour? " + flour);
    console.log("Do we have corn meal? " + cornMeal);
    console.log("We have " + cupsOfSugar + " cups of sugar");

    heat += 25;
    flour = !flour;
    cornMeal = !cornMeal;
    cupsOfSugar++;
  }

  return bake;
}

// Originally, x is a reference to the outer function
// By reassigning it to the return value
// x becomes instead, a reference to the inner function
// After this statement, we NO LONGER have a reference to the outer function
x = x(); // invoking cake()
// We will LOSE access to the outer function
// And now, the ONLY way to interact with the flour, cornMeal, and cupsOfSugar fields
// is through the inner method

x(); // invoking bake()
x(); // invoking bake()
x(); // invoking bake()


let y = {
  age: 18,

  birthday: function() {
    this.age++;
  }
}

console.log(y)
y.birthday();
console.log(y)

function Person(name, age) {
  this.name = name;
  this.age = age;

  this.f = function() {
    console.log("My Person method");
  }
}

let sally = new Person("Sally", 23);

sally.f();

// class keyword was introduced in ES6 in 2005;
class PersonClass {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  func() {
    console.log("Inside class declaration");
  }
}

let larry = new PersonClass("Larry", 44);

larry.func();

console.log(larry);

var testValue = 33;

testValue = 14;

console.log(testValue);

/**
 * If the this keyword is used alone, it refers to the global window object
 *
 * Inside a function, this refers still to the global window object
 *
 * If in strict mode, inside a function, this is undefined
 *
 * Inside an object's method, the this keyword refers to the owning object
 */

console.log(this);
