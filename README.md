# JSF-Noticeboard
Small application utilizing Java Server Faces (JSF) to create a virtual noticeboard.

It is possible to create a post but they are currently stored in-memory.
As the Noticeboard class is SessionScoped, the posts will not be available in another session such as in another browser.

## Requirements
Required tools to build and run the application.
- Maven

## Building
Steps for building application:
- Navigate to "noticeboard" folder
- Run `mvn clean install && mvn wildfly:run` in a terminal
- Navigate to http://localhost:8080/noticeboard/noticeboard.xhtml

## Issue
There is an issue with loading in the posts and marking them as new as the posts are retrieved multiple times. Specifically, Noticeboard.getPosts. This causes the `lastSeen` variable to update to a time AFTER the post was created and thus it will be marked as "not new".

Line causing a problem:

```<h:dataTable var="post" value="#{noticeboard.posts}" styleClass="table">```

This can be seen by following these steps:
- Navigate to "noticeboard" folder
- Run `mvn clean install && mvn wildfly:run` in a terminal
- Navigate to http://localhost:8080/noticeboard/noticeboard.xhtml
- Refresh the page and observe the terminal

It will print "True" once or multiple times to represent the post being new but it will also print "False" as the method is called multiple times and the case described in the start of this subsection will occur.