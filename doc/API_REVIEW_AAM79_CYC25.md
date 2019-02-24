# API Review - aam79, cyc25

* External API get history, display, etc.
* Are gonna use controllers, where the back-end updates stuff and then announces 
the front end about it to display it. 
* Have a method addCommand() that basically adds the command to the list of commands.
* They will update the turtle directly. 
* We discussed how we both think that reflection will be a good way to pinpoint strings
to different commands, as to avoid a HUGE if-statement with every single command possible. 
* We also talked about how it might be necessary to use a tree and recursion to 
actually parse the text commands we get from the front-end. However, a stack, queue, 
or other data objects could work as long as we clearly define each. 
* To use reflection: Define the class, call the constructor with the approrpiate parameters,
and in theory you have the command object you want! I really hope its this simple. 
* We also talked about how the TO functions work and how we would tackle this in each of
our individual groups. We talked about using a getParams() method inside each of the command
classes, and this will be filled with recursion through the list of commands until
all of the arguments are met. Wow this is a lot.
* Think about using maps when doing multiple nested functions and variables.
* Think about checking for integers or variables to override or to dissect the necessary
info. 
