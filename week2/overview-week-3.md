# Week 3 Topics

Client-Side technologies (Frontend) or interacting with Frontend

What is Frontend? Interface for users
In modern times, this is a website

We will cover HTML, CSS, Bootstrap, JavaScript, and Servlets in Week 3
However, HTML, CSS, and Bootstrap will be rather briefly covered

I would like you guys to explore overviews for HTML, CSS, and Bootstrap

HTML = HyperText Markup Language
- It is NOT a programming language
- It is a MARKUP language
- Very similar to XML in structure (XML = eXtensible Markup Language)
  - A Markup Language operates using TAGS
    - These are syntax that is similar to Generics in Java
    - Except instead of a Type, you have a tag name
    - These tags also have a corresponding closing tag
      - There can be data or more tags nested within
    - HTML/XML tags can have *attributes*, which are metadata for a particular tag
- HTML describes the overarching *structure* of a webpage
  - There are tags such as head, body, footer, header, table, div (dividers), a (anchor = hyperlinks), p (paragraph)
  - They are all organized in a nested format

CSS = Cascading Style Sheets
- CSS provides a means of styling a webpage to make it look nice
- CSS has *selectors*
  - They allow to specify certain html *elements* to assign styling
  - Tag selectors
  - Class selector
  - Sibling/Ancestor selectors
  - etc
  - You provide styling in a similar form to HTML styling attributes
    - text-color
    - border-width
    - etc
  - You can imagine that styling can become VERY nuanced
  - CSS Box Model

Bootstrap is a CSS Framework
- Provides a huge collection of HTML *classes*
- Allows very fast styling of webpages
- Has themes
- Bootstrap Grid System

We will primary leverage Bootstrap classes

JavaScript is a programming language
- JavaScript is very different from Java
- JavaScript is loosely typed & dynamically typed
  - loosely typed means you do not have to specify types on variables
  - dynamically typed means that once assigned, variables can then be reassigned to a different type
  - semicolons to end statements are optional
    - Generally, I will try to include semicolons
    - React has a feature called JSX, and JSX does not work properly without proper usage of semicolons
- JavaScript can be directly interpeted by a browser
- However, there are platforms to execute JavaScript without a browser, called NodeJS
  - There are differences between browser-side and server-side JavaScript
  - There is a global window/document variable in browser-side JS
  - There is also a global variable in server-side JS, but they have different features
- JavaScript was initially written in 10 days by a single person
  - Due to this, there are some very strange quirks to the language
  - Since its inception, JavaScript has picked up a standardized structure called ECMAScript
- Primarily, we will be learning basic JavaScript as well as how to manipulate the DOM (Document Object Model)

Servlets are an API in Java to interface with HTTP Requests over the internet

HTTP = HyperText Transfer Protocol
There are many HTTP Methods/Verbs such as GET/POST/PUT/DELETE/etc
These HTTP Methods/Verbs were designed with certain intentions, but technically speaking we do not have to follow these intentions. And for many years, developers in web-development completely ignored these intentions. However, in more modern times, we do now pay attention to these intentions.

There is this idea of HTTP Requests and Responses. It is like a cycle.

It is a means of sending information between computers over the internet

- Servlet Interface
  - GenericServlet Abstract Class
    - HttpServlet Abstract Class
      - We can create our CustomServletClass extending the HttpServlet class

There are interfaces for HttpRequests/HttpResponses that we will use.

In order to receive these HTTP Requests, we need a Web Server, such as Tomcat. Tomcat will then delegate the requests to the Servlets that we create. We will host our Java Application on Tomcat. Specifically, we will change our maven packaging to create a WAR file (Web Archive).

Tomcat will be running on either our local computer or a server somewhere, and we just have to put the WAR file in the `webapps` folder of Tomcat. Our IDE has integration with Tomcat to make that very easy. But when we start provisioning cloud servers, we will have to do this manually.

Postman is a way to send Custom HTTP Requests. Primarily for development purposes.
