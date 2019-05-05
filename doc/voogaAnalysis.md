CompSci 308: SLogo Addition
===

# Before

### Estimation

 * How long do you think it will take you to complete this new feature?
 I think it will take about an hour to implement these features.
 

 * How many files will you need to add or update? Why?
I will need to add two command classes, Stamp and ClearStamp. In addition, I will need to update the 
properties file and backend manager to include an API to clear and add turtles. Then I will
also have to implement a function that keep track of which turtles are stamps and which are not.
During the Stamp method, the turtle manager should generate a turtle image and keep track that
it is only a stamp. During the clear method, all of these stamps should be deleted.


# After

### Review

 * How long did it take you to complete this new feature?
 
 It took about 1.5 hours to implement.

 * How many files did you need to add or update? Why?
 
 I had to update the classes I mentioned above. In addition, I edited the TurtleState class
 which is what kept track of the locations and states of each turtle. I had to implement
 a new copy constructor that would make a copy of the current active turtle, while also
 setting its ID to the negative of the current turtle's ID.

 * Did you get it completely right on the first try? If not, why not?

I did not get it on the first try because I ran into some bugs. THe main was that I was
saving the current turtle incorrectly. I would save the state of the turtle BEFORE updating it
so stamping would show a turtle that was one command behind. If I write `fd 100 stamp fd 100` There should
have been a stamp of the turtle that was 100 pixels behind of the active turtle. But because 
the way my code had worked previously, the stamp was 200 pixels behind.

### Analysis

 * What do you feel this exercise reveals about your project's design and documentation --- was it as good (or bad) as you remembered?

I think that this extension revealed that there were some good and some bad design decisions
within my project. I think that adding a command class was extremely simple because I just added
two new classes with very few lines of code each. To implement stamps, I had to tweak a few
already implemented features, which slightly exposed the design flaws. We had not implemented
Turtle shape so to pseudo implement it, I put an inactive turtle in the same position as 
the turtle the stamp was created for. In addition, I used the current active turtle's ID * -1
to get the ID of the stamp.

 * What about the design or documentation could be improved?
 
 I think I could put instructions on how each component could be better extended. I think that
 creating instructions for making a basic command could be useful because although it is simple,
 it would be very difficult for someone who doesn't know how the code works and how the syntax
 tree is formed. In terms of design, I think that the communication between front end and
 back end was not well integrated. For example, I had to know that in order to update a
 turtle's state, you'd have to tell both the front end and backend the state of the turtle
 rather than just keeping track of turtles in the backend and have the front end call methods
 to get information from the backend. This design flaw could have been fixed by having a singular
 object keep track of the state of the turtles and have the front end call methods on the backend
 to retrieve information from the backend rather than telling the backend and front end to 
 update once a turtle's state was changed.
 

 * What would it have been like if you were not familiar with the code at all?
 
 I would have been very confused. Perhaps adding the new command classes would be easy but it
 would not be easy to implement the corresponding backend manager API method. As I mentioned
 earlier, the user had to know that there would need to be two update calls, one to the 
 front end and one to the backend. 