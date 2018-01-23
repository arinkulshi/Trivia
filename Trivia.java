/**
 * This class is used to store the Trivia Object. It will take the Trivia obj get 5 random questions must be stored into a collection, from the main quiz admin.
 * It will also return the next question object in the collection. will make sure if the answer correct or not also make sure to ignore case
 *
 * @author Arindam Kulshi
 * File Name: Trivia.java
 */

import java.util.ArrayList;
import java.util.Random;

public class Trivia {

    /**
     * Arraylist of questions
     */
    private ArrayList<Question> qArr;
    /**
     * ArrayList of 5 random questions
     */
    private ArrayList<Question> tArr;

    /**
     * score stored as int
     */
    private int score;

    /**
     * Random object gen
     */
    private Random randgen = null;

    /**
     * Pramater constructor taking the trivia objects.
     * @param qArr
     * @param TArr
     * @param score
     */

    public Trivia(ArrayList qArr, ArrayList TArr, int score) {
        setqArr(qArr);
        setTArr(TArr);
        randgen = new Random();
        setScore(0);

    }

    /**
     * Takes the question array and stores 5 random questions into a new ArrayList.
     * @param qArr
     * @return ArrayList
     */

    public ArrayList StoreQuestions(ArrayList qArr) // Will use a random number generation to read 5 questions from the bank.
    {
        for (int i = 0; i < 5; i++) {
            int index = randgen.nextInt(qArr.size());
            tArr.add((Question) qArr.get(index));
        }
        return tArr;
    }

    /**
     * resturns the next questions in the tArr.
     * @param index
     * @return Question
     */

    public Question NextQuestion(int index) { //Will pull the next question from the array.
        Question q = new Question();

        return tArr.get(index);


    }

    /**
     * Evalues the specified questions
     * @param q
     * @param answer
     * @return boolean
     */

    public boolean Evaluate(Question q, String answer) { // Evaluates the question given the question and answer.  And updates the score.
        if (q.getAnswer().equalsIgnoreCase(answer)) {
            score = q.getValue() + score;
            System.out.println("That is correct");
            System.out.println("Your score is " + score);
            return true;

        } else {
            System.out.println("That is not correct, the correct answer is" + q.getAnswer());
            System.out.println("Your score is " + score);
            return false;
        }

    }

    /**
     * gets the array of all the questions
     * @return qArr
     */

    public ArrayList getqArr() {

        return qArr;
    }

    /**
     * sets the array of all the questions
     * @param qArr
     */

    public void setqArr(ArrayList qArr) {
        this.qArr = qArr;
    }

    /**
     * returns the trivia question
     * @return tArr
     */

    public ArrayList getTArr() {
        return tArr;
    }

    /**
     * sets the trivia question
     * @param TArr
     */

    public void setTArr(ArrayList TArr) {
        this.tArr = TArr;
    }

    /**
     * gets the score value
     * @return score
     */

    public int getScore() {
        return score;
    }

    /**
     * sets the score value.
     * @param score
     */

    public void setScore(int score) {
        this.score = score;
    }


}

