# Request/Response Cycle

A request is sent to the server, when it arrives:

1. Tomcat will receive the request, and create an empty flat (no file extension) file for the response
2. Tomcat will wrap the files into HttpServletRequest and HttpServletResponse objects
3. Tomcat will consult the Deployment Descriptor (web.xml) to determine which servlet to delegate to
4. Tomcat will send the request and response objects to the servlet
  1. Tomcat calls init() method if needed (only once if needed)
    - When the first request arrives for a Servlet, if it has not been initialized, the init() method will be called
    - If the load-on-startup tag is used, the init() method will be called before any requests arrive for the servlet
  2. Tomcat calls service() method to process the request (every request)
  3. Tomcat calls destroy() method if a long time passes or if server shuts down (only once)
5. Servlet will process the request and build the response by working with the service layer
6. Servlet will hand the request and response objects back to Tomcat
7. Tomcat copies response contents into the response flat file, and send it back as an HTTP Response
