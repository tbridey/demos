/**
 * Events in HTML will propagate through the DOM.
 *
 * There are 2 phases: bubbling and capturing
 *
 * When we create event listeners, we can have them trigger on the event
 * in either phase.
 *
 * This allows us to define the order that some event listeners will
 * execute (to a certain extent)
 *
 * With bubbling, the innermost element will occur first, followed by
 * the outer elements.
 *
 * With capturing, the outermost element will occur first, then the
 * further nested elements.
 *
 * For any single event, it will start in capturing phase, and once it reaches
 * the target elemeent, it switches to bubbling, and "bubbles back up" to
 * the top of the DOM.
 */

// The addEventListener function has an optional third parameter, which is a boolean
// The default value is false
// This parameter sets the phase that the event listener is on
// false => bubbling
// true => capturing

// If you do not include the third parameter, it will end up on bubbling phase

let capturing = true;
let bubbling = false;


document.getElementById("inner").addEventListener("click", () => {
  alert("INNER - BUBBLING");
}, bubbling);

document.getElementById("middle").addEventListener("click", (event) => {
  alert("MIDDLE - BUBBLING");
  // We can use a stopPropagation() method
  // and stopImmediatePropagation() method
  // to prevent this event from further propagating through the DOM

  // stopPropagation() will prevent the event from hitting any listeners
  // from other elements

  // stopImmediatePropagation() does the same but also stops any other listeners
  // on this same element (stops ties)

  // event.stopPropagation();
  event.stopImmediatePropagation();
}, bubbling);

document.getElementById("outer").addEventListener("click", () => {
  alert("OUTER - BUBBLING");
}, bubbling);



document.getElementById("inner").addEventListener("click", () => {
  alert("INNER - CAPTURING");
}, capturing);

document.getElementById("middle").addEventListener("click", () => {
  alert("MIDDLE - CAPTURING");
}, capturing);

document.getElementById("outer").addEventListener("click", () => {
  alert("OUTER - CAPTURING");
}, capturing);


/**
 * On the target element, if there are event listeners across both phases, they will occur at the same time
 *
 * And the specific browser implementation will decide the order of ties
 *
 * Google Chrome will execute them in the order they were declared.
 */
