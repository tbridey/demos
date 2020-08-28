# REST

REST stands for REpresentational State Transfer. The "REpresentational" refers to the representation of data. In REST, all data is considered a "resource". And we can "represent" that resource in many different ways. For example, we can represent a User resource in JSON. We can also represent the same User resource in XML. Any resource can be "represented" in a variety of different ways. The "State" part of the name refers to the fact that everything that we pass around is simply raw state. It is a "resource" and not "functionality". Everything that we do as a REST API is in regards to this state. We can manipulate it, we can create it, we can destroy it, and we can query it. The "Transfer" part is that the data is being transferred across the internet along some protocol, generally HTTP.

Within HTTP, the HTTP Verb, such as GET, DELETE, PUT, POST indicate what action will be performed against the resources.

You might have a GET request to a url such as `/books/1`, which will indicate that the request is asking to receive a book resource with the id 1. Or it could be a GET request to `/users/moberlies`, which would ask to receive the User resource with the username "moberlies". Generally, REST uses a lot of "Path Variables", which are data embedded into the url, such as the id in the books example or the username in the user example. The url itself has information about the request.

We could also send a DELETE request to `/users/8`, which will ask to delete the user with id 8. The url will often only contain information to identify resources. Using ids, or usernames, or similar.

For POST or PUT requests, it will be required to send data along with the request.

Generally, this information will be stored in the body of the request, in whatever representation is used, often JSON.

We might send a POST request to `/users` with the body of the request containing full JSON about a User resource. In this case, since IDs are most often obtained from the database when inserted, the given id in the body will usually be zero to indicate a new resource. Because zero is usually an invalid id.

A PUT request would be similar, sent to `/users` with the User resource in the body. Except for updates, the id would be non-zero.

In all of these cases, the action being performed is based on the HTTP method, and therefore the url doesn't have any verbs. It only includes nouns, or other means to clarify resources.

## Constraints/Properties/Traits

The specific terminology doesn't matter, but constraints are used most often.

There are 6: 5 being required, and the last being optional.

No particular order:

- Uniform Interface
  - Requests/Responses should constructed in a similar way to develop a "uniform interface" for processing requests. For the response, the structure should be consistent.
  - Has further ties to a concept called HATEOAS
- Should develop a client-server relationship. Most importantly, they should independent enough to evolve separately/independently. The structure of the REST API should not be dependent upon the webpage and vice-versa.
  - Also has further ties to HATEOAS
- Stateless
  - No request should save information about any other request.
  - There should be no relevance to whether a user is "logged in" or other concepts of state within an application
  - This does mean, if we want to be able to log in, we aren't fully following the concept of REST, but for us, that is okay for now
- Cacheable
  - We should be able to cache data to respond quickly to the same request over and over
  - Most primarily for GET requests of course
- Layered System/Architecture
  - We can have different aspects of the application/API on different servers, and that will be hidden from any clients
  - For example, we can have a database on a different server than our REST API
  - We could perform authentication on a different server as well, etc
  - All of this is hidden from any users of the API
  - We can support a layered system/architecture without causing more complexity for the end user
- Code on Demand (optional)
  - Optional constraint
  - In addition to sending back static resources as JSON or XML, we can provide executable code that we can invoke if needed
  - I have seen other interpretations, where instead of executing code directly, they will represent code as its own resource

As mentioned above in regards to Stateless, we will not always be following every constraint every time, and that is okay. We simply won't be "truly" RESTful, but it is just an architectural style, and it isn't absolutely required.
