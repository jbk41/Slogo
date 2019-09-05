# Design Document - Slogo Team 07
Bryant Huang 
Justin Kim 
Mark Kang
Alejandro Meza

## High-level Design 
The front end design is as follows.  The visualization is split into several HBoxes and VBoxes, each of which has containers that are able to carry out specific functions as requires.  For example, the displays for command history and user defined commands are different from the display of turtles.  There are several Drop down menus and buttons to enable further user interaction with the program - one can add workspaces, undo commands, and pull up a help menu. From a more technical standpoint, the main class is the TurtleIDE where all of the buttons, displays, and menus, along with styling, is initialized.  Once our IDE receives a list of executable commands from the backend, it separates these based on the tyle of command (change the state of turtles vs. changing the background color) and executes necessary functions respectively. The other major component is the turtle class, which handles all the turtle movements along with animation and drawing on the canvas.

The back end is given a language and a string to parse and interpret. It is first parsed
into Commands and a syntax tree is built from it. Then, the entire tree is executed and if necessary,
commands that affect the front end will add an executable object to a list that is exported
to the front end at the end of the tree's execution. Executables include changing the 
characteristics of the turtle and environment and throwing errors. Commands that do not
actually affect the front end include keeping track of variables set by the user, user 
defined commands, and a running list of active turtles.

## Adding Features 
To add a new command, three things must be done. One, add the name of the command to the resources.language folder. This way, when the command is parsed, the code knows what specific command its talking about. Then, you must add the literal command to the BackendManagerAPI Class and thus the BackendManager Class. In this step, you declare what this command does (e.g left_shift 5, you would set the x coordinate to x_current - 5). Finally, one would have to make a command object with the specific name of the command and add it to the 'commands' package. This commmand must extend MovementCommand, StatementCommand, or GeneralCommand (depending on the type of command it is), and it must follow convention for declaration.


## Major Design Choices
1. An alternate design we thought of (and actually even implemented before having to refactor) was using something called TurtleCommands, which basically held the information of the command inputted by the user (e.g. fd 100, bk 200, etc.). These TurtleCommands, however, did not hold history or the previous state. Therefore, we had to iterate over the list of TurtleCommands and convert them into turtle States before sending to the front end. This, first of all, did not follow the API we designed, and therefore wasn't great design. Second, it wasn't extensible because when we reached the extensions, we did not know how to deal with Error Messages, Background State changes, and any other type of command the user might have thought of adding to the Environment. 

2. Another design decision was deciding whether the back-end should have access to the turtles and the specific movements or not. The discussion broke down into two factors: division of responsibility within the team, and also the whether this aspect was more suited to be fit into the front end or back end. Firstly, placing this responsiblity on the backend added an additional workload that we believed was important to be considered for equal division of work. Secondly, the more important aspect point is regarding design and encapsulation - we decided that all the backend should be able to do is parse a string based on a set of logic, and return a set of executable objects to the frontend to update the visualization. While there is a benefit of keeping the front end clean and simply responsible for the initial display, we found more benefit in adding the movement to the frontend.  Though this places more burden on the front end, and one may argue this is responsibility past just visualization, there are several reasons why we stuck to our design. The first is that it definitively separates the frontend and backend and simplifies communication through the method getCommands(). The backend strictly parses, and returns a list from which the front end can loop through and update the turtle.  The backend doesn't know anything about the IDE, which we thought was optimal design, whereas if turtle movement was implemented in the backend, Turtle objects would have to be passed through and raise questions about whether the backend should have access to these objects. The other reason is that it is a simple implementation on the front end due to the scope of variables - rather than have the backend change the aspects of the front end and create more dependencies, the front end has package-private access to the Turtle objects on the screen and the pane which they are on.  I was a strong proponent of the frontend implmentation because it greatly simplified the API implementation and clearly encapsulated frontend vs backend responsibility and access.


## Assumptions and Decisions 

The decision to simplify the API to where the backend and frontend would have very limited points of communication made debugging the functionality a lot simpler. As mentioned above, the decision to leave turtle movement completely up to the front end made it so that the backend would never have to interact with aspects of the Visualization packages. This reduced our dependencies since there were very clear and limited points of communication.

We also assume that the user will input very well written commands as our error checking methods are not very robust. Some errors will not be caught and display the intended error message, but it allows the user to input a different command following the error without crashing the program.


## Backend-Frontend Interaction
The front end holds the characteristics of the turtles and environment. The external
APIs send a language to the back end so it knows how to interpret commands and after the user
types in some commands in the text editor, the entire string is shipped to the backend. Once
the backend gets the string, it parses it into different command objects (more well known
as tokens). 
Each of these command objects has a copy of the same backend manager that allows the commands
to edit and retrieve variables, add and call user defined commands, and add frontend-controlling
executables to the executable list.
These commands are then pieced together continuously into an abstract syntax
tree. Each of these commands has an execute function, which, most of the time, calls execute
on its children before doing anything significant about itself. Once all of the commands are
executed properly, the executable list generated by the the backend is shipped to the front end
who reads these and interprets them accordingly. If the front end wants to change a variable,
it can use an API to directly change the value of a variable that the backend keeps track of.
