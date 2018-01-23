/**
 * This class is used to make the QuizAdmin object. It will store a collection of questions.
 * It  can add and delete questions from a random access file it can also print all the elements of the file to a string.
 *
 * @author Arindam Kulshi
 * File Name: QuizAdmin.java
 */


import java.io.EOFException;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class QuizAdmin {

    /**
     * ArrayList of questions
     */
    private ArrayList<Question> qArr;

    /**
     * Constructor to initalize QuizAdmin class
     * @param qArr
     */
    public QuizAdmin(ArrayList qArr) {

        setqArr(qArr);
    }

    /**
     * returns the  array of questions
     * @return qArr
     */

    public ArrayList getqArr() {
        return qArr;
    }

    /**
     * sets the array of questions
     * @param qArr
     */
    public void setqArr(ArrayList qArr) {
        this.qArr = qArr;
    }

    /**
     * Adds the specified question to the arraylist and to the Random access file.
     * @param q
     */

    private static int RECORD_SIZE = 0;

    public void addQuestion(Question q) { // Will add a question to the random access file. and to the arraylist.

        qArr.add(q); // Will add questions 1 by 1 to the array and to the random access file.

        int numberID = q.getQuestionID();   // gets all the values and stores them.
        String question = q.getQuestion();
        question = String.format("%-" + 50 + "s", question);
        QuizExcept quiz = new QuizExcept();
        try {
            quiz.checkQuestionLength(question);  //Will check to see if all values are the correct number of spaces. if not throws exception
        } catch (QuizExcept quizExcept) {
            quizExcept.getMessage();
        }

        String answer = q.getAnswer();
        answer = String.format("%-" + 20 + "s", answer);
        try {
            quiz.checkQuestionLength(answer);
        } catch (QuizExcept quizExcept) {
            quizExcept.getMessage();
        }

        int points = q.getValue();
        try {
            quiz.checkQuestionLength(answer);
        } catch (QuizExcept quizExcept) {
            quizExcept.getMessage();
        }


        try {
            RandomAccessFile ioStream = new RandomAccessFile("Quiz", "rw"); // Will store the values in a RAF file.
            //ioStream.seek((int) ioStream.length()); //Looks for the last position that the iostream stopped and will add the next q there.
            ioStream.writeInt(numberID);
            ioStream.writeUTF(question);
            ioStream.writeInt(points);
            ioStream.writeUTF(answer);
            RECORD_SIZE = (int) ioStream.length();

        } catch (FileNotFoundException e) {
            System.out.println("Problem opening file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problems with file I/O.");
        }


    }

    /**
     * Deletes a specified question using the questionID from the Random Access File.
     * @param ID
     */

    public void deleteQuestion(int ID) { //We need to figure out how to delete from a random access file.

        int index = ID - 1001; //Array elements are index values.
        qArr.get(index); // Will  get the ID element from the array and delete it from the random access file.


        try {

            RandomAccessFile ioStream = new RandomAccessFile("Quiz", "rw");
            long num = index / RECORD_SIZE; //This will calculate the number of entries.
            ioStream.seek(num); //Will give you how many accounts there are.
            int result = ioStream.readInt();
            if (result == ID)
                System.out.print("Question" + ID + " Has been DELETED");

        } catch (EOFException e) {
            System.out.println("No more numbers in the file.");
        } catch (
                FileNotFoundException e)

        {
            System.out.println("Problem opening file.");
        } catch (
                IOException e)

        {
            e.printStackTrace();
            System.out.println("Problems with file I/O.");
        }

        qArr.remove(index);
    }

    /**
     * prints out all eleements to a String
     * @return String
     */

    public String DisplayAllQuestions() {
        String s = "";
        int x = 1;
        for (Question q : qArr) {
            System.out.printf("Question Number: %2d Question: %s %n Answer: %2s %n Question Value: %d %n%n", x, q.getQuestion(), q.getAnswer(), q.getValue());
            x++;
        }
        return s;
    }


}

