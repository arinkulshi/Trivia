/**
 * This class is used to store the Quiz Player object. It will take the QuizPlayer object. SerialWriteFile and Serial ReadFile
 * These methods will write the quizplayer object to a serialized file and can read it from a serialized file.
 *
 * @author Arindam Kulshi
 * @version 1.0
 * 
 */


import java.io.*;
import java.lang.Object;

public class QuizPlayer implements Serializable {

    /**
     * Holds the name of the player
     */
    private String name;

    /**
     * Holds the nickname of the player
     */
    private String nickname;
    /**
     * Holds the total score of the player.
     */

    private int totalScore;

    /**
     * Default object constructor
     */
    public QuizPlayer() {
        setName("");
        setNickname("");


    }

    /**
     * Paramater constructors sets to value by user.
     *
     * @param name
     * @param nickname
     * @param totalScore
     */

    public QuizPlayer(String name, String nickname, int totalScore) {
        setName(name);
        setNickname(nickname);
        setTotalScore(totalScore);

    }

    /**
     * gets the name of the player.
     *
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player.
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * get stored nickname of player
     *
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * sets nickname of the player.
     *
     * @param nickname
     */

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * gets total stored score.
     *
     * @return totalScore
     */

    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Sets total scor
     *
     * @param totalScore
     */

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * Will write the object quizplayer to a serialized file.
     */
    public void SerialWriteFile() {

        PrintWriter pwrite = null;
        File fileObject = new File(getName());
        QuizPlayer q = new QuizPlayer(getName(), getNickname(), getTotalScore());

        try {
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(new FileOutputStream(fileObject));

            outputStream.writeObject(q); //Writes the object to the serialized file.
            outputStream.close();


        } catch (IOException e) {
            System.out.println("Problem with file output.");
        }

    }

    /**
     * Will read the file and return the quizplayer object.
     *
     * @return QuizPlayer
     */

    public QuizPlayer serialReadFile() {
        File fileObject = new File(getName());
        QuizPlayer q = new QuizPlayer(); //If any error is caught the program will re ask the user for input.
        try {
            ObjectInputStream inputStream =
                    new ObjectInputStream(new FileInputStream(fileObject));
            q = (QuizPlayer) inputStream.readObject();


        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file. Please Enter a different file Name");

        } catch (ClassNotFoundException e) {
            System.out.println("Problems with file input. Please Enter a different file name");

        } catch (IOException e) {
            System.out.println("Problems with file input. Please Enter a differet file name");
        }


        return q;
    }


/**
 * prints everything to a String.
 *
 * @return String
 */

public String toString(){
        String s="";

        System.out.printf("Name: %s \t Nickname: %s \t",getName(),getNickname());

        return s;
        }
        }

