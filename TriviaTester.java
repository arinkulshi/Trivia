/**
 * This class is used to delete questions, add questions in the quizadmin file.
 * It is also used to play the quiz admin game. If you select the add question it will ask you to
 * give it question, answer and value to add the questions, you can delete questions using the question ID,
 * Once the questions are set you can play trivia become a new or existing user and answer the questions your final score will be
 * posted at the end.
 *
 * @author Arindam Kulshi
 * @version 1.0
 * 
 * 
 * File Name: TriviaTester.java
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TriviaTester {

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in); //Initialize variables
        int choice = 0;
        int ID = 0;
        String entry = "c";
        String entry2 = "c";
        String entry3 = "c";
        String entry4 = "c";
        ArrayList<Question> TriviaQuestions = new ArrayList<>(); // Will make an array of trivia questions
        QuizAdmin qa = new QuizAdmin(TriviaQuestions); //Take that array and store it into a quiz admin object
        ArrayList<Question> Game = new ArrayList<>(); //Arraylist to hold the 5 random questions.

        System.out.println("Welcome to Trivia Game");
        while (!entry.equals("q")) { // Loop to aak if the user would like to continue playing over and over again.

            System.out.println("Please Enter the number of the choice you would like.");
            System.out.println(" 1.List All Questions  \n" +
                    " 2.Delete Question \n" +
                    " 3.Add question \n" +
                    " 4.Play Trivia \n" +
                    " 5.Quit");
            choice = inp.nextInt();

            if (choice == 1) { // Displays all questions in the question array.

                qa.DisplayAllQuestions();

            }


            if (choice == 2) { //Deletes a question using the question ID.
                while (!entry2.equals("q")) {
                    System.out.println("Please Enter the ID of the question you would like to delete");
                    ID = inp.nextInt();
                    qa.deleteQuestion(ID);
                    System.out.println("Press any key to delete another question or press q to quit?");
                    entry2 = inp.next();
                }
            }
            if (choice == 3) { // Adds a question
                String question;
                String answer;
                int value;
                int IDNum;

                while (!entry3.equals("q")) {
                    System.out.println("Please Enter the question you would like to add");
                    inp = new Scanner(System.in);
                    question = inp.nextLine();
                    System.out.println("Please Enter the answer to the question");
                    answer = inp.nextLine();
                    inp = new Scanner(System.in);
                    System.out.println("Please Enter the point value of this question");
                    value = inp.nextInt();
                    inp = new Scanner(System.in);
                    Question addQ = new Question(question, answer, value);
                    qa.addQuestion(addQ);
                    System.out.println("Press any key to add another question or press q to quit?");
                    entry3 = inp.next();

                }
            }

            if (choice == 4) { // Plays trivia game by randomly selecting 5 questions asking these questions to the user and returning the final name and score.
                String name;
                String nickname;
                int score = 0;
                QuizPlayer p = new QuizPlayer();
                Trivia t = new Trivia(TriviaQuestions, Game, score);
                while (!entry4.equals("q")) {
                    System.out.println("Wekcome to Trivia"); // Asks if new user or existing user. If existing will write to same file. If existing will find existing file.
                    System.out.println("If you are a new user press 1 if you are a existing user press 2");

                    int user = inp.nextInt();
                    if (user == 1) {
                        System.out.println("Please enter your name?");
                        name = inp.next();
                        System.out.println("Please enter your nick name");
                        nickname = inp.next();
                        p = new QuizPlayer(name, nickname, 0);
                        p.SerialWriteFile();
                    } else {
                        System.out.println("Please enter the name for your file?");// Will check for existing file
                        name = inp.next();
                        p.setName(name);
                        p = p.serialReadFile();

                    }


                    t.StoreQuestions(TriviaQuestions); //Will store 5 random questions and print them out.
                    for (int x = 0; x < 5; x++) {
                        Question nextquestion = t.NextQuestion(x);
                        int qnum = x + 1;
                        System.out.println("Question Number " + qnum);
                        System.out.println(nextquestion.getQuestion());
                        System.out.println("Please Enter your Answer.");
                        String answer = inp.next();
                        t.Evaluate(nextquestion, answer);
                    }
                    p.setTotalScore(t.getScore() + p.getTotalScore());
                    System.out.println("Press any key to play Trivia again or press q to quit?"); // Asks if the user would like to play again if not presents everything to a String
                    entry3 = inp.next();
                    if (entry3.equalsIgnoreCase("q")) {
                        p.SerialWriteFile();
                        System.out.println(p.toString() + "Round Score: " + t.getScore());
                        System.out.println("Your Total Score is " + p.getTotalScore());
                        break;
                    }
                }
            }


            if (choice == 5) { // Closes the program.
                entry = "q";
                System.out.println("Thanks for playing Trivia, Bye!");

            } else {
                System.out.println("Please Enter a valid option");
            }
        }
        }

}



