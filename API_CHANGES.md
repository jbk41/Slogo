## API Changes so Far
1. We decided to have a TurtleState Object in the backend to be able to have the
turtle state and be able to update it directly, without having to send raw data to front 
end for them to deal with it as they want. This in one way keeps the design API 
as we had it, where the backend deals with the parsing and front end deals with 
visualization. However, this change gives the backend access to the state of the 
turtle, without directly giving access to the turtle itself. 