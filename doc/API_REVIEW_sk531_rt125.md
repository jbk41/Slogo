What about your API/design is intended to be flexible?
Flexible because all of the subclasses come from one general API and methods that you use can be implemeneted into the API. 

How is your API/design encapsulating your implementation decisions?
All of the different subclasses only communicate with each other with a couple public methods and keep other methods private so other classes cannot mess with them. 

What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
On the front end, there might be errors when we try to play a movement when the text editor is empty. Other than that, the front end should be
getting the exceptionsn from the backend about invalid syntax errors and displaying them in a popup window. 

Why do you think your API/design is good (also define what your measure of good is)?