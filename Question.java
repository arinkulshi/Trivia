/**
 * This class is used to store the question object. It has all the accessor and mutator methods of the question object.
 *
 * @author Arindam Kulshi
 * @version 1.0
 *
 */


public class Question {
    /**
     * Stores question as a String
     */
    private String question;

    /**
     * Store the answer to the question as String
     */
    private String answer;

    /**
     * Stores the value of the question as a int
     */

    private int value;

    /**
     * Stores the questionID
     */
    private static int QuestionID = 1000;

    /**
     * Default constructor
     */

    public Question() {
        setQuestion("");
        setAnswer("");
        setValue(0);
        setQuestionID(0000);


    }


    /**
     * Paramater Constructor takes input from the user and stores question object.
     *
     * @param question
     * @param answer
     * @param value
     */
    public Question(String question, String answer, int value) {
        setQuestion(question);
        setAnswer(answer);
        setValue(value);
        setQuestionID(getQuestionID() + 1);

    }

    /**
     * Gets and returns question String
     *
     * @return question
     */

    public String getQuestion() {

        return question;
    }

    /**
     * Sets question value
     *
     * @param question
     */

    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * returns the answer of the question
     *
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * sets the answer of the question
     *
     * @param answer
     */

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * gets the value of the Question object
     *
     * @return value
     */

    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the question
     *
     * @param value
     */

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * get the ID of the question
     *
     * @return QuestionID
     */

    public static int getQuestionID() {
        return QuestionID;
    }

    /**
     * Sets the questionID
     *
     * @param questionID
     */

    public static void setQuestionID(int questionID) {
        QuestionID = questionID;
    }
}
