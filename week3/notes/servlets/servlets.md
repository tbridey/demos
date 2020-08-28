## ServletConfig vs ServletContext

Both of these are configurations that can be handed to Servlets. Generally speaking, they are just key-value pairs (of type String). They have differences in which Servlets they apply to.

## ServletConfig

ServletConfig is a collection of key-value pairs of Strings that are configurations for a single Servlet. Every Servlet will have its own ServletConfig.

## ServletContext

ServletContext is a collection of key-value pairs of Strings that are configurations for all Servlets. All Servlets will share a single ServletContext.


## Redirections

There are two kinds: forward() and sendRedirect(). They are both ways to redirect requests, but they do so in different ways. forward() is known as a server-side redirection and sendRedirect() is known as a client-side redirection.

forward method is available on the RequestDispatcher interface, which we obtain from the Request object. `req.getRequestDispatcher().forward(req, resp)`.

forward is generally used when we want to display a static web page as a response from a Servlet. We will effectively redirect to that static resource. However, this redirection is all taking place on the same server. Therefore, the client doesn't have to know/care about the fact that they were redirected. So it all happens exclusively on the server-side, unbenknownst to the client. They will receive the one response from their initial request, and it will be as if everything was as expected.

forward is not exclusively used for static resources. We can redirect to other Servlets, potentially with different attributes set for complex processing.

sendRedirect is available on the HttpServletResponse. `resp.sendRedirect(req, resp)`.

sendRedirect is generally used when we want to redirect to an external source. So if the user had asked our server for some resource at Google, we don't own that information. So we can redirect them to that other resource. For example, you have likely seen some webpages have embedded google search functionality. Often, when you use it, you will be redirected to that external source.

Since the server doesn't own this external resource, we can only send the client to it. sendRedirect is known as a client-side redirect, because the client will see their webpage reload to a new location. sendRedirect will send a response to the client, ending the first request. And then the browser will interpret the 3XX series status code, and automatically trigger _another_ request to navigate to the external resource.

sendRedirect ultimately ends with 2 requests/responses. forward ultimately ends with 1 request/response.
