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

