/*
    Michel Aguilera, Mahith Allu, Zach Miller, Jose Mendoza
    August 6, 2023
    Group Project Verson 6.0

    ----------------------------------------------
    PSEUDOCODE:

    IMPORT necessary libraries

    DECLARE QUESTION_COUNT as constant
    DECLARE HIGHSCORE_COUNT as constant

    FUNCTION main():
        DECLARE point, menuChoice
        ASK user for name using JOptionPane
        
        DO:
            OPEN file "questions.txt" for reading
            DISPLAY main menu
            GET user's choice
            
            SWITCH based on user's choice:
                CASE 1:
                    DISPLAY game rules
                CASE 2:
                    DECLARE arrays for question and answers data
                    FOR each question in "questions.txt":
                        READ and store question data
                        PROCESS each question and calculate points
                        DISPLAY current score
                    END FOR
                    
                    DECLARE arrays for high scores data
                    READ current high scores from file
                    COMPARE user's score with current high scores
                    UPDATE the high scores file if necessary
                    RESET player's score
                CASE 3:
                    DISPLAY goodbye message
                DEFAULT:
                    DISPLAY error message for invalid choice
            END SWITCH
            
            CLOSE file "questions.txt"
        WHILE user does not choose to exit the game

    END FUNCTION main()

    FUNCTION displayMainMenu(name):
        DISPLAY welcome message and menu options
        RETURN user's choice as integer
    END FUNCTION

    FUNCTION displayRules():
        DISPLAY the game rules using JOptionPane
    END FUNCTION

    FUNCTION processQuestion(question, answers, correctAnswer, pointValue):
        DISPLAY question and possible answers
        REPEAT:
            GET player's answer
            IF player's answer is correct:
                DISPLAY correct message
                RETURN points for correct answer
            ELSE IF player's answer is one of the options but incorrect:
                DISPLAY incorrect message
                RETURN 0 points
        UNTIL player provides a valid answer
    END FUNCTION

    FUNCTION readInHighScores(nameArray, scoreArray):
        OPEN file "highscore.txt" for reading
        FOR each high score in the file:
            READ and store name and score
        END FOR
        CLOSE file
    END FUNCTION

    FUNCTION compareScore(userScore, userName, highScoreNames, highScores):
        FOR each high score in highScores:
            IF userScore is greater than current high score:
                UPDATE the high scores list
            END IF
        END FOR
    END FUNCTION

    FUNCTION updateHighScores(highNames, highScores):
        OPEN file "highscore.txt" for writing
        FOR each high score:
            WRITE name and score to file
        END FOR
        CLOSE file
    END FUNCTION

    FUNCTION displayScore(score):
        DISPLAY user's current score
    END FUNCTION

    FUNCTION displayGoodbye():
        DISPLAY goodbye message
    END FUNCTION

    END PROGRAM

    -----------------------------------------------------------

    Change-log for Version 6:


    1. General Features and Constants:

    Added: Constants QUESTION_COUNT and HIGHSCORE_COUNT for 
    defining the number of questions in the game and the 
    number of high scores to maintain.
    

    2. Game Logic and Flow:

    Added: Arrays to store questions, multiple choices, 
    correct answers, and point values.

    Changed: In V5.1, the game read questions till the 
    end of the file using while (read_questions.hasNextLine()). 
    In V6, it only reads a fixed number of questions 
    (defined by QUESTION_COUNT).

    Removed: while loop for reading questions. 
    Replaced by a for loop in V6.
    

    3. High Score Handling:

    Changed: In V5.1, there was only one high score (a single value). 
    V6 maintains multiple high scores (defined by HIGHSCORE_COUNT).

    Changed: In the readInHighScores method, V5.1 only read a single 
    high score value. V6 reads multiple high score names and scores into arrays.

    Changed: The compareScore method in V5.1 compared the user 
    score with a single high score. V6 compares the user's score 
    with all stored high scores and inserts it into the appropriate 
    position, pushing other scores down if needed.

    Changed: In V5.1, the updateHighScores method wrote a single 
    score to the highscore.txt file. In V6, the method writes multiple 
    high scores (names and scores) to the highscore.txt file.
*/

// DEPENDENCIES
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class App {

    // NEW IN VERSION 6.0
    // Constants for the number of questions in the game and the number of high scores to maintain
    private static final int QUESTION_COUNT = 10;
    private static final int HIGHSCORE_COUNT = 3;

    // Entry point of the application
    public static void main(String[] args) throws FileNotFoundException {

        // Initialize basic game variables
        int point = 0;
        int menuChoice = 0;

        // Prompt user for their name
        String name = JOptionPane.showInputDialog(null, "Please input your name below.");

        do {
            // Set up scanner to read questions from external file
            File questions_file = new File("questions.txt");
            Scanner read_questions = new Scanner(questions_file);

            // Display main menu and get the user's choice
            menuChoice = displayMainMenu(name);

            // Main game logic based on user's menu choice
            switch (menuChoice) {
                case 1:
                    // Show the game rules
                    displayRules();
                    break;
                case 2:
                    // Initialize arrays to store question and answer data
                    String[] questionArray = new String[QUESTION_COUNT];
                    String[] answerA = new String[QUESTION_COUNT];
                    String[] answerB = new String[QUESTION_COUNT];
                    String[] answerC = new String[QUESTION_COUNT];
                    String[] answerD = new String[QUESTION_COUNT];
                    char[] correctAnswer = new char[QUESTION_COUNT];
                    int[] pointValue = new int[QUESTION_COUNT];

                    // Read and process each question
                    for (int i = 0; i < QUESTION_COUNT; i++) {
                        // NEW IN VERSION 6.0
                        // Parsing each line of question data from the file
                        questionArray[i] = read_questions.nextLine();
                        answerA[i] = read_questions.nextLine();
                        answerB[i] = read_questions.nextLine();
                        answerC[i] = read_questions.nextLine();
                        answerD[i] = read_questions.nextLine();
                        correctAnswer[i] = read_questions.nextLine().charAt(0);
                        pointValue[i] = Integer.parseInt(read_questions.nextLine());

                        // Process and score the question for the user
                        point += processQuestion(   questionArray[i],
                                                    answerA[i],
                                                    answerB[i],
                                                    answerC[i],
                                                    answerD[i],
                                                    correctAnswer[i],
                                                    pointValue[i]
                                                );

                        // Display the current score to the user
                        displayScore(point);
                    }

                    // Arrays to hold high score data
                    String[] highNames = new String[HIGHSCORE_COUNT];
                    int[] highScores = new int[HIGHSCORE_COUNT];

                    // Read current high scores from file
                    readInHighScores(highNames, highScores);

                    // Compare the user's score to the current high scores
                    compareScore(point, name, highNames, highScores);

                    // Update the high scores file with any changes
                    updateHighScores(highNames, highScores);

                    // Reset player's score for potential next round
                    point = 0;  
                    break;
                case 3:
                    // Display a goodbye message
                    displayGoodbye();
                    break;
                default:
                    // Handle invalid menu choice
                    JOptionPane.showMessageDialog(null, "Invalid input, please restart the game and input an integer from 1 to 3.");
            }

            // Close the question scanner
            read_questions.close();

        // Continue until the user selects to exit the game
        } while (menuChoice != 3);
    }

    // Function to display the main menu and return the user's choice
    public static int displayMainMenu(String name) {
        String introduction = name.toUpperCase() + ", WELCOME TO THE JAVA PROGRAMMER GAME!";
        String menu = "MENU:\n[1] See the rules\n[2] Start the game\n[3] Exit";
        return Integer.parseInt(JOptionPane.showInputDialog(null, introduction + "\n" + menu));
    }

    // Function to display the game rules
    public static void displayRules() {
        String rules = "You have chosen to see the rules. The game will give you a set of 10 questions about Java. If you answer correctly, points will be added to your score. Have fun!";
        JOptionPane.showMessageDialog(null, rules);
    }

    // Function to process individual questions and return the points earned
    public static int processQuestion(String question, String ansA, String ansB, String ansC, String ansD, char correctAns, int pointValue) {
        char player_answer;

        String question_text = "" + question + "\n" + ansA + "\n" + ansB + "\n" + ansC + "\n" + ansD;

        // Continue prompting the user until a valid answer is provided
        do {
            player_answer = Character.toUpperCase(JOptionPane.showInputDialog(null, question_text).charAt(0));

            if (player_answer == correctAns) {
                // Correct answer
                JOptionPane.showMessageDialog(null, "Correct!");
                return pointValue;
            } else if (player_answer == 'A' || player_answer == 'B' || player_answer == 'C' || player_answer == 'D') {
                // Incorrect answer
                JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: " + correctAns);
                return 0;
            }
        } while (player_answer != 'A' || player_answer != 'B' || player_answer != 'C' || player_answer != 'D');
        return 0;
    }

    // Function to read in and return the current high scores from file
    // Changed in V6.0, now takes 2 arrays as parameters
    public static void readInHighScores(String[] name, int[] score) throws FileNotFoundException {
        File highscore_file = new File("highscore.txt");
        Scanner highscore_scanner = new Scanner(highscore_file);

        // Parse high scores and associated names from file
        for (int i = 0; i < HIGHSCORE_COUNT; i++) {
            name[i] = highscore_scanner.next();
            score[i] = highscore_scanner.nextInt();
            highscore_scanner.nextLine();
        }

        // Close the high score scanner
        highscore_scanner.close();
    }

    // Function to compare and potentially update the high scores with the user's score
    // Changed in V6.0, now takes 2 primitives and 2 arrays as parameters
    public static void compareScore(int userScore, String userName, String[] name, int[] score) {
        for (int i = 0; i < HIGHSCORE_COUNT; i++) {
            if (userScore > score[i]) {
                // Shift the rest of the scores and names down
                for (int j = HIGHSCORE_COUNT - 1; j > i; j--) {
                    score[j] = score[j - 1];
                    name[j] = name[j - 1];
                }

                // Update with the user's higher score and name
                score[i] = userScore;
                name[i] = userName;
                break;
            }
        }
    }

    // Update the highscores.txt file with current scores and names
    // Changed in V6.0, now takes 2 arrays as parameters, updates 3 lines in highscore.txt
    public static void updateHighScores(String[] highNames, int[] highScores) throws FileNotFoundException {
        File highscore_file = new File("highscore.txt");
        PrintWriter highscorePrinter = new PrintWriter(highscore_file);
        for (int i = 0; i < HIGHSCORE_COUNT; i++) {
            highscorePrinter.println(highNames[i] + " " + highScores[i]);
        }
        highscorePrinter.close();
    }

    // Display the user's score
    public static void displayScore(int score) {
        JOptionPane.showMessageDialog(null, "Your score is: " + score);
    }

    // Display goodbye message when exiting the game
    public static void displayGoodbye() {
        String goodbyeMessage = "Thanks for playing the JAVA PROGRAMMER GAME!";
        JOptionPane.showMessageDialog(null, goodbyeMessage);
    }
}