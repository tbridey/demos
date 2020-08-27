/**
 * AJAX: Asynchronous JavaScript And XML
 *
 * We will leverage AJAX through a class called
 * XMLHttpRequest
 *
 * We will be sending an HTTP Request through this XMLHttpRequest object
 *
 * We will be sending a request to some other server, and we will receive
 * a response with some data, that we can then use to dynamically populate
 * our webpage.
 *
 * This will be done with HTTP, so we will use specific HTTP verbs/methods
 * as well as pay attention to HTTP Response Status Codes.
 */

let button = document.getElementById("btn");

button.addEventListener("click", tempFunc);

let input = document.getElementById("input");

input.addEventListener("keydown", (event) => {
  if(event.key === "Enter") {
    ajax();
  }
});

function ajax() {

  // STEP 1: Create an XMLHttpRequest Object

  let xhr = new XMLHttpRequest();
  // console.log(xhr);

  /**
   * The readyState property defines the current status of our request
   * There are 5 states (0 through 4)
   *
   * 0: UNSENT - The open() method has yet to be called
   * 1: OPENED - The open() method has been called
   * 2: HEADERS_RECEIVED - The request has received a response,
   *      and the headers have been recceived, as well as the status
   * 3: LOADING - Currently downloading the response. The responseText property
   *      contains the actual response
   * 4: DONE - Operation is complete
   */

   // STEP 2: Define the function that will be executed every time the readyState changes

   xhr.onreadystatechange = function() {
     if(this.readyState == 4 && this.status == 200) {
       let data = JSON.parse(xhr.responseText);

      //  console.log(data);

      placeImage(data);
     }
   }


   // STEP 3: Open the XMLHttpRequest
   // Define the HTTP Verb and URL
   xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/" + input.value);

   // STEP 4: Send the Request
   xhr.send();
}


function placeImage(data) {
  let shiny_url = data.sprites.front_shiny;
  let default_url = data.sprites.front_default;

  let output = document.getElementById("output");

  let info = document.createElement("p");

  info.innerHTML = "Name: " + data.name + "<br/>ID: " + data.id;

  let default_image = document.createElement("img");
  default_image.setAttribute("src", default_url);
  default_image.setAttribute("style", "height: 200px; width: 200px");

  let shiny_image = document.createElement("img");
  shiny_image.setAttribute("src", shiny_url);
  shiny_image.setAttribute("style", "height: 200px; width: 200px");

  output.append(info);
  output.append(default_image);
  output.append(shiny_image);

  output.append(document.createElement("hr"));
}


function promiseFetch() {
  // Promise
  // let p = new Promise();

  // let p2 = new Promise();


  // Promise.all(p, p2).then( ( response) => {

  // }).catch( (error) => {

  // });

  // A Promise an object that "promises" to respond at some point in the future
  // The API is designed to avoid "callback hell" which methods such as Promise.all, etc.

  // Promises follow a functional programming paradigm, which sequential function calls.

  // You invoke a .then() method to define the callback if the promise succeeds
  // and a .catch() method to define the callback if the promise rejects

  // The Fetch API is an API surrounding AJAX that leverages Promises.

  fetch("https://pokeapi.co/api/v2/pokemon/" + input.value).then( (response) => {
    return response.json();
    // We use this .json() method, which returns a Promise of the parsed JSON string
    // instead of the JSON.parse function due to some issues with being inside a Promise
  }).then( (data) => {
    placeImage(data);
  }).catch( (error) => {
    console.log(error);
  });
}

async function asyncFetch() {
  // The async/await keywords were introduced in ES7

  // It allows us to declare an entire function as an asynchronous function

  // This will turn any remaining statements after the await keyword into a callback
  // in response to the promise the await keyword is used on.

  try {
    let response = await fetch("https://pokeapi.co/api/v2/pokemon/" + input.value);

    let data = await response.json();

    placeImage(data);
  } catch(error) {
    console.log(error);
  }
}

function tempFunc() {
  asyncFetch();
  // ajax();
  console.log("Hello, this happens before anything else!");
}
