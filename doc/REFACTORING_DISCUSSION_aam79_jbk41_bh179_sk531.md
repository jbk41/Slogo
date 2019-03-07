## Net-IDS
* aam79
* jbk41
* bh179
* sk531

### Checklist Refactoring
* In BackendModel, we set a default language to "English". We had this default string in a final variable and made a new ParseCleaner object that was set to English when BackendModel is initiated.
* Initially, we had all of the instance variables in GeneralCommand be protected so that its subclasses could access them easily. We refactored all of the Command classes to use getters and setters.
* Before we branched, we changed ArrayLists to Lists for instance variables and return types and HashMaps to Maps for the same.
* In VariableManager, we removed methods that were unnecessary.
* In frontend, we shortened the longest methods.

In the Turtle class, we had methods that were longer and could have been split into smaller methods with more specific responsibilities.  First off, we decided to have the process of drawing the line in the transition to be its own method, greatly shortening the method createTransition (line 123).  We didn't have many issues with duplication, due to the waryness on our part while coding those parts, but moveTurtle() (line 82) was also a bit lengthy and held too much responsibility as a single, lengthy method.  That served as our biggest issue as we had increasingly large responsibility on these methods as the design specifications grew.  There are also some local variables that are only used once and might be unecessary to declare as variables rather than simply have them return the values. We also have a static method in our HelpScreen class that we were advised to change.  Besides these issues, we believe that the methods are well written for the most part. 

The most important issue is definitely the method responsibility and violation of design concepts in certain longer methods.  To fix these issues, our refactoring process included breaking down these larger methods into ones of smaller responsibilities.  This included creating the drawLine() and createPath() methods, which served specific responsibilities and enabled us to shorten our methods down.  It is now easier to read, and methods are more flexibile to be used elsewhere rather than simply all combined into a single method.  The local variables are less of an issue, but one we will pay closer attention to when doing a final refactoring of our code prior to submission.  We've changed the static method back as well - we were trying to implement a utility class but don't think it was done correctly. The most important aspect was to fix the design issues with our unnecessarily long method.  We will look into more on how to achieve the functionality of the utility class that we were trying to implement, as it was recommended during a TA session and we believe it would be a helpful tool to utilize.


