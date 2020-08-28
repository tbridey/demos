# Design Patterns

## Front Controller

The Front Controller Design Pattern for Servlets is a Design Pattern where you have exactly 1 Servlet. This single Servlet will be responsible for processing all requests. Generally, it will further delegate to other layers of the application. At the very least, this Servlet class will organize the processing of every request.

In particular, Spring Framework uses a Front Controller design pattern for its Servlet. For Project 1, you may choose to use a Front Controller design pattern, but it is not required.

## MVC = Model - View - Controller

Model is just the data model. It is a representation of the data that will be passed back and forth. It will be used to populate the View, and is controlled/manipulated by the Controller. The model itself has no logic. It is just data.

View is anything that contributes to what is seen by the user (html, css, etc). It is what represents a web page. The data will populate the view to provide dynamic information.

Controller is the component controls all logic. It manipulates and moves the data. Injects the data into the view, etc.

We can follow this design pattern with our backend design. So we can have static html files that have tables or other html elements that have data injected into them (This used to be done with JSPs and other technologies, but aren't used much anymore). We then control the webpage/view by processing requests sent/received by JavaScript. The data is generally what is sent/received. Then JavaScript can be used to populate the view.

With the introduction of Angular, our backend will no longer have anything to do with the view. Our backend will then solely send/receive JSON data (as a REST API). However Angular itself follows this MVC design pattern internally. Where you have Components (which are the view). There are also services (which act as controllers for the view). And there are typescript classes which act as our model.

## Business Delegate

Explore this on your own.
