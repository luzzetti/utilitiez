# Utilitiez
Test/Exercise project for JavaCommunity


# FAQs: #

### How do I contribute? ###
- Inside the project, open the package:
  src/main/java/org/javacommunity/utilitiez/services
  
  At the moment of writing, there are 3 subpackages:
  - scavenger
  - analyzer
  - reporting
  
  Open it, and inside everyone of it, there is an Interface that you're going to implement:
  
  - Create a subpackage with your name (in the example, cinghiamenisco)
  - Inside this package, create a class that is going to implement the interface (In the example, NoOpScavengerServiceImpl), and start programming!
  - In your package (the one with your name), feel free to create all the support classes/packages/records etc... that you need.
  
### How do I start it? ###
  
  Just open the Main and launch it. It's in the package:
  - src/main/java/org/javacommunity/utilitiez/Main.java
  
  the main, is its simple form, will launch the *startDebug(String[] args) method, so feel free to delete the code in it, and write your own code to launch your implementations.
  
  Alternatively, you can pass "FX" as argument, to launch the FX application.
  (Or, alternatively, you can locate the FxInit class and launch its Main method.
  - src/main/java/org/javacommunity/utilitiez/fx/FxInit.java
  
### I'm scared I might break something... ###

Good. Breaking stuff is a good way to learn stuff.
Feel free to commit WHATEVER you want with this repo, as long as you have fun!



# Other info #
- The project uses Java 17  (Because why not!)
- JavaFX is already imported, but you have to use the SceneBuilder version for java11+
- Module-info is configured as *open* because...well...'cause I suck with module-info  *shrugs*  ¯\\_(ツ)_/¯

