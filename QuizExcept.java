/**
 * This class is used to define the quiz exceptions. It will store exceptions for questions, answer and value
 * These exceptions make sure the correct value is being entered in.
 *
 * @author Arindam Kulshi
 * File Name: QuizExcept.java
 */


import java.util.Scanner;

public class QuizExcept extends Exception {
    /**
     * Constructor to build QuizExcept object
     */
    public QuizExcept() {
        super();
    }

    /**
     * Will throw an exception if question length greater then 50 character .
     * @param value
     * @throws QuizExcept
     */

    public void checkQuestionLength(String value) throws QuizExcept {
        if (value.length() > 50) {
            try {

                throw new QuizExcept();
            } catch (QuizExcept e) {

                System.out.println("Invalid please enter a value less then 50 characters in length. ");
            }
        } else {
            //All Elements are formmated no message needed.
        }

    }

    /**
     * Will throw an exception if answer greater then 30 characters.
     * @param value
     * @throws QuizExcept
     */
    public void checkAnswerLength(String value) throws QuizExcept {
        if (value.length() > 30) {
            try {

                throw new QuizExcept();
            } catch (QuizExcept e) {

                System.out.println("Invalid please enter a value less then 30 characters in length");
            }
        } else {
            //All elements corrected forrmatted no message needed.
        }
    }


    /**
     * Throws an exception if point value not between 1 and 5.
     * @param value
     * @throws QuizExcept
     */

    public void checkPointValue(int value) throws QuizExcept {
        if (value > 5 || value < 1) {
            try {

                throw new QuizExcept();
            } catch (QuizExcept e) {

                System.out.println("Invalid please enter a number between 1 and 5");
            }
        } else {
            //All elements corrected forrmatted no message needed.
        }

    }

}
