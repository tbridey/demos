/**
 * As we have seen, JavaScript DOES have some object-oriented features
 *
 * We saw that we can use the new keyword and even the class keyword (as of ES6)
 *
 * And when we printed to the console, it listed the class
 *
 * We do have Inheritance in JavaScript
 * However, it doesn't take the same form as it does in Java
 *
 * JavaScript has "prototypal inheritance"
 * Each object has a property called "__proto__"
 * And this is a reference to some object
 * The default value for this is a built in object that is effectively just an empty object
 *
 * This proto property is the parent or "prototype" of the object
 *
 * Or of any object we make in JavaScript
 *
 * The equivalent to the Object class in Java, is this empty object that will ultimately
 * be at the top of every heirarchy
 */

let car = {
  wheels: 4,
  color: 'blue',
  engine: 'v6',
  fourdoor: true
};

console.log(car);

let camry = {
  make: 'Toyota',
  model: 'Camry',
  year: 1999,
  wheels: 3,
  color: 'black'
}

camry.__proto__ = car;

console.log(camry);

// JavaScript will first look for the property in the object itself, and if not found
// will then look in the proto
console.log(camry.fourdoor);
console.log(camry.engine);

/**
 * JavaScript has the idea of:
 *
 * If it looks like a duck, quacks like a duck, and walks like a duck,
 * then it IS a duck.
 *
 * If any object has ALL of the properties and behaviors of another object,
 * is IS an instance of that object/type.
 */

class Car {
  engine = '';
  fourdoor = false;
  wheels = 0;
  color = '';

  constructor(engine, fourdoor, wheels, color) {
    this.engine = engine;
    this.fourdoor = fourdoor;
    this.wheels = wheels;
    this.color = color;
  }
}

class Camry extends Car {
  make = '';
  model = '';

  constructor(engine, fourdoor, wheels, color) {
    super(engine, fourdoor, wheels, color);
    this.make = 'Toyota';
    this.model = 'Camry';
  }
}

let myCamryObject = new Camry('v4', true, 4, 'silver');

console.log(myCamryObject);
