###Part 1
The API that is used for the front end to speak to the backend would 
involve passing an object to the backend that includes some configurations 
and the actual text to parse. This shouldn't be too flexible as the only 
configurations the backend should really need are the language and the actual 
text. The API used for the backend would just convert the text into a list of 
easily read commands by the front end. Some of them include:
* Move(Turtle t, int displacement, int rotation)
    * Moves/rotates the turtle
* Error(String error)
    * If seen by the front end, it should just read out the string of the
    error. This is very flexible because error messages are determined by
    the backend.
    * Some error exceptions could be incorrect variable parameters and 
    spelling
    
I think a could design for API would allow minimal communication between
the front end and backend and only very few method calls are necessary. 
Our API design is good because everything is sent in one large package to
and from the front and back end and control is given to each individually 
based on what they receive from the other

    

###Part 2
One design pattern we recognized is having a running list of the commands.
It would be very easy to save function names because you could just search
your history of commands. So, every time a command is called, add it to the 
running list of past commands. I am most excited and nervous to work on 
building our command tree for parsing. I think this portion would be 
algorithmically tough because it involves trees, but also in terms of design
because we would have to be able to add new types of nodes for each new
syntax that is involved. For example, we could have Variable, Command, and 
Constant nodes, but we would also have to handle a new type of node if 
it were introduced in the next sprint. 

Use cases:
1. Recognize incorrect argument types (ex. Fd fd)
2. Convert list of commands into singular commands (Fd + + 1 2 3 = Fd 6)
3. Return a list of commands to the user.
4. Handle for loops and repeats.
5. Save a running list of all of the user defined functions.