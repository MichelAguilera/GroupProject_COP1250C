/*
    Michel Aguilera, Mahith Allu, Zach Miller, Jose Mendoza
    July 27, 2023
    Group Project Verson 5.1

----------------------------------------------
PSEUDOCODE:

- Declare variables: point, menuChoice, name.
- Declare boolean variable: exit_game_loop and set it to false.

METHODS:

  METHOD getUserName:
    - Prompt the user for their name.
    - Return the entered name.

  METHOD displayIntroduction(name):
    - Construct and display an introduction message using the given name.

  METHOD displayMenu:
    - Display the main menu.
    - Return user's choice.

  METHOD displayRules:
    - Show game rules.

  METHOD askQuestion(question, answerChoices, correctAnswer, pointValue):
    - Display the question and answer choices to the user.
    - Get user's answer.
    - Return the points earned based on the correctness of the answer.

  METHOD readHighScore:
    - Read and return the high score from "highscore.txt" file.

  METHOD updateHighScore(newScore):
    - Overwrite the high score in "highscore.txt" with the newScore if it's higher than the current high score.

  METHOD displayGoodbye:
    - Show a goodbye message.

START:

  - Set name to getUserName.
  - Call displayIntroduction with name.

  LOOP until exit_game_loop is true:

    - Set menuChoice to displayMenu.
    
    - Based on the value of menuChoice do the following:

      - IF menuChoice is 1:
        - Call displayRules.

      - IF menuChoice is 2:
        - Open "questions.txt".
        
        - LOOP through each question in the questions file:
          - Read the question details.
          - Call askQuestion with the read details.
          - Accumulate the score.
          
        - Display accumulated score.
        
        - Call updateHighScore with the accumulated score.
        
        - Reset the accumulated score to 0.

      - IF menuChoice is 3:
        - Call displayGoodbye.
        - Set exit_game_loop to true.

      - IF menuChoice is neither 1, 2, nor 3:
        - Display an error message.

----------------------------------------------

    V5.1 CHANGES

    Refactoring:
        Separated many blocks of logic from the main method into their 
        own individual methods to improve readability and maintainability. 
        This included displayMainMenu, displayRules, processQuestion, 
        readInHighScore, compareScore, displayScore, and displayGoodbye.

    Optimization:
        processQuestion:
            Improved the way questions and answers are loaded from the file. 
            Questions and answers are now loaded into individual variables, 
            making the code easier to understand and modify.

            The data type of player_answer was changed from String to char, 
            simplifying the checks against possible answer options.

            The check for available answers is more straightforward and robust.
*/

// DEPENDENCIES
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class App {

    // Entry point of the application
    public static void main(String[] args) throws FileNotFoundException {

        // Initialize basic game variables
        int point = 0;
        int menuChoice = 0;
        String name = JOptionPane.showInputDialog(null, "Please input your name below.");

        do {
            // Read questions from external file
            File questions_file = new File("questions.txt");
            Scanner read_questions = new Scanner(questions_file);

            menuChoice = displayMainMenu(name);

            // Main game logic based on user's menu choice
            switch (menuChoice) {
                case 1:
                    displayRules();
                    break;
                case 2:
                    while (read_questions.hasNextLine()) {
                        // Parsing each line of question data
                        String question = read_questions.nextLine();
                        String ansA = read_questions.nextLine();
                        String ansB = read_questions.nextLine();
                        String ansC = read_questions.nextLine();
                        String ansD = read_questions.nextLine();
                        char question_answer = read_questions.nextLine().charAt(0);
                        int question_point_value = Integer.parseInt(read_questions.nextLine());

                        // Process and score the question
                        point += processQuestion(question, ansA, ansB, ansC, ansD, question_answer, question_point_value);
                        displayScore(point);
                    }

                    // Compare the player's score to the current high score
                    int high_score = readInHighScore();
                    compareScore(high_score, point);
                    point = 0;  // Reset player's score
                    break;

                case 3:
                    displayGoodbye();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid input, please restart the game and input an integer from 1 to 3.");
            }
            read_questions.close();
        } while (menuChoice != 3);
    }

    // Displays the main menu and returns the user's choice
    public static int displayMainMenu(String name) {
        String introduction = name.toUpperCase() + ", WELCOME TO THE JAVA PROGRAMMER GAME!";
        String menu = "MENU:\n[1] See the rules\n[2] Start the game\n[3] Exit";
        return Integer.parseInt(JOptionPane.showInputDialog(null, introduction + "\n" + menu));
    }

    // Display game rules
    public static void displayRules() {
        String rules = "You have chosen to see the rules. The game will give you a set of 10 questions about Java. If you answer correctly, points will be added to your score. Have fun!";
        JOptionPane.showMessageDialog(null, rules);
    }

    // Process individual questions, return points earned
    public static int processQuestion(String question, String ansA, String ansB, String ansC, String ansD, char correctAns, int pointValue) {
        char player_answer;

        String question_text = "" + question + "\n" + ansA + "\n" + ansB + "\n" + ansC + "\n" + ansD;

        do {
            player_answer = Character.toUpperCase(JOptionPane.showInputDialog(null, question_text).charAt(0));
            if (player_answer == correctAns) {
                JOptionPane.showMessageDialog(null, "Correct!");
                return pointValue;
            } else if (player_answer == 'A' || player_answer == 'B' || player_answer == 'C' || player_answer == 'D') {
                JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: " + correctAns);
                return 0;
            }
        } while (player_answer != 'A' || player_answer != 'B' || player_answer != 'C' || player_answer != 'D');
        return 0;
    }

    // Read and return the current high score
    public static int readInHighScore() throws FileNotFoundException {
        File highscore_file = new File("highscore.txt");
        int highScore = 0;

        Scanner highscore_scanner = new Scanner(highscore_file);
        if (highscore_scanner.hasNextLine()) {
            highScore = Integer.valueOf(highscore_scanner.nextLine());
        }
        highscore_scanner.close();

        return highScore;
    }

    // Compare and potentially update the high score with user's score
    public static void compareScore(int highScore, int userScore) throws FileNotFoundException {
        File highscore_file = new File("highscore.txt");
        if (userScore > highScore) {
            PrintWriter highscorePrinter = new PrintWriter(highscore_file);
            highscorePrinter.print(userScore);
            highscorePrinter.close();
        }
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