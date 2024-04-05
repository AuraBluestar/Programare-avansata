# Homework
* Create a shell that allows reading commands from the keyboard, together with their arguments.
* Represent the commands using classes instead of methods. Use an interface or an abstract class in order to describe a generic command.
* Implement the following commands:
  - view: opens a document using the native operating system application (see the Desktop class);
  - report: creates (and opens) an HTML report representing the content of the repository.
    Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.
  - export: exports the repository to an external file using JSON format; you may use Jackson or other library;
* The application will signal invalid data or the commands that are not valid using custom exceptions.
* The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.
