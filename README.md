# Trivia In Java


# Purpose 
Implements a Trivia Game using Object Serialization, Polymorphism, User Exceptions and Random Access Files.
The purpose of the game is to take a list of quiz questions and pick 5 of them at random to ask the user. Then
record the users results and keep track of scores. 

### Serialization 
Serilization is the process of coverting objects into byte format. It is a important form of storing of transferring objects especially among arcitecturalling indepndent environments. Serialization tends to also be very robust.

### Random Access File
RAF's are important because they help access contents of files nonsequentially this is in contrast to the sequential file. RAF tend to be faster and more efficient. If the user remembers the offset it is very easy to find the file the user is looking for. However, the one disadvantage is that if the offset is unknown then it is more difficult to access the contents of the file. In this use case a sequential file may be more beneficial. 

# Classes
### Question
  - Will store the question object and ID
### QuizAdmin
  - Will store a Array of questions
  - Will add and delete question that have been added.
  - Questions will be stored and accessed from a Random Access File
### QuizPlayer
   - Will store the info about each player
   - The player object will be read and written from a serialized Files
### Trivia
   - Will store 5 random questions from the Array of Questions
   - Will check to see if the user inputs a correct answer to the questions
### Trivia Tester
   - Will run the final program
### QuizExcept 
   - Constructs a user defined exception that will check to see if the questions and answers are the correct number of characters.
   
# Instructions to Run

### Getting Started 

In order to run this program you will need JDK
Which can be found here: http://www.oracle.com/technetwork/java/javase/downloads/index.html

## IDE
Next will need a text editor or IDE to display the program
I used Intellji: https://www.jetbrains.com/idea/download/#section=windows



