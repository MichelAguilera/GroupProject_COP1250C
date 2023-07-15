/*
    Michel Aguilera
    July 15, 2023
    Group Project Verson 4.0

----------------------------------------------
PSEUDOCODE:

- Create variables point, menuChoice, name, player_answer, introduction, goodbyeMessage, menu, finalMenu, rules.
- Create boolean variable exit_game_loop and set it to false.

START
  - Ask the user for their name and store the value in the variable name.
  - Create the introduction message using the name and assign it to introduction variable.
  - Display the introduction and menu to the user.

  LOOP until exit_game_loop is true:
    - Open and read questions from file "questions.txt".

    - Ask user to choose a menu item and assign the choice to menuChoice.
    - Based on the value of menuChoice do the following:

      - IF menuChoice is 1:
        - Display the rules.

      - IF menuChoice is 2:
        - LOOP through each question in the questions file.
          - For each question, read 5 lines for the question text and the following 2 lines for the answer and point value.
          - Display the question and current score to the user and ask for an answer.
          - LOOP until a valid answer is given:
            - IF the answer is correct, add the point value to the user's score and display a message indicating the answer was correct.
            - IF the answer is incorrect but valid (A, B, C, D), display a message with the correct answer.
            - IF the answer is invalid, display an error message.

        - After all questions have been asked, display the final score and finalMenu to the user.
        - LOOP until a valid final menu choice is made:
          - IF choice is 1, set break_last_menu_loop to true to exit the final menu loop.
          - IF choice is 2, display the goodbye message and final score, set break_last_menu_loop and exit_game_loop to true to exit both the final menu loop and game loop.
          - IF choice is invalid, display an error message.

        - Check if the current score is greater than the high score in the "highscore.txt" file. If it is, overwrite the highscore in the file with the current score.
        - Reset the current score to 0.

      - IF menuChoice is 3:
        - Display the goodbye message and set exit_game_loop to true to exit the game loop.

      - IF menuChoice is neither 1, 2, nor 3:
        - Display an error message asking for a valid input.

    - Close the questions file.


----------------------------------------------
*/

// DEPENDENCIES
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

// MAIN
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        // Declaring the variables
        int point = 0;
        int menuChoice = 0;

        String name = JOptionPane.showInputDialog(null, "Please input your name below.");
        String player_answer;

        String introduction =   name.toUpperCase() + ", WELCOME TO THE JAVA PROGRAMMER GAME!";
        String goodbyeMessage = "Thanks for playing the JAVA PROGRAMMER GAME!";

        String menu =           "MENU:\n[1] See the rules\n[2] Start the game\n[3] Exit";
        String finalMenu =      "Would you like to play again?\n[1] Yes, I'd like to play again\n[2] No, please exit";
        String rules =          "You have chosen to see the rules. The game will give you a set of 10 questions about Java. If you answer correctly, points will be added to your score. Have fun!";

        // Main logic 
        boolean exit_game_loop = false;
        do {
            File questions_file = new File("questions.txt");
            Scanner read_questions = new Scanner(questions_file);

            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(null, introduction + "\n" + menu));
            switch (menuChoice) {
                case 1: // See the rules
                    JOptionPane.showMessageDialog(null, rules);
                    break; // Prevents jump to the questions after selecting to see the rules
                case 2: // Play the game
                
                    /* 
                        VERSION 4 CHANGES

                        - REMOVED: Hard-coded questions inside the code
                        + ADDED: External file to store the questions with the strings and metadata (correct answer and point worth)
                    */

                    while (read_questions.hasNextLine()) {
                        // INITIALIZES THE VARIABLES FOR USE BY THE PROGRAM
                        String question_text = "";
                        String question_answer;
                        int question_point_value;

                        // LOADS THE QUESTION INTO THE PROGRAM
                        for (int line = 1; line <= 5; line++) {
                            String next_line = read_questions.nextLine();
                            question_text = question_text.concat(next_line + "\n");
                        }

                        // LOADS THE METADATA INTO THE PROGRAM
                        question_answer = read_questions.nextLine();
                        question_point_value = Integer.parseInt(read_questions.nextLine());

                        // DEBUG
                        System.out.println(question_text + " " + question_answer + " " + question_point_value);

                        // LOGIC
                        do {
                            player_answer = JOptionPane.showInputDialog(null, question_text + "\nYour current score is: " + point);
                            if (player_answer.equalsIgnoreCase(question_answer)) {
                                point += question_point_value;
                                JOptionPane.showMessageDialog(null, "Correct!");
                                break;
                            } else if (player_answer.equalsIgnoreCase("A") || player_answer.equalsIgnoreCase("B") || player_answer.equalsIgnoreCase("C") || player_answer.equalsIgnoreCase("D")) {
                                JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: " + question_answer);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid input.");
                            }
                        } while (true);
                    }

                    boolean break_last_menu_loop = false;
                    do {
                        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Your score was: " + point + "\n\n" + finalMenu));
                        switch (choice) {
                            case 1: // Continue game
                                break_last_menu_loop = true; // Sets exit condition for the final menu to true; will stop the loop after case 1 is broken.
                                break;
                            case 2: // Exit game: display the score
                                JOptionPane.showMessageDialog(null, goodbyeMessage + "\nYour score was: " + point);
                                break_last_menu_loop = true; // Sets exit condition for the last menu to true; will stop the loop after case 2 is broken.
                                exit_game_loop = true;       // Sets exit condition for the game loop to true; will stop the loop after case 2 is broken.
                                break;
                            default:
                                // If the user inputs an unavaiable integer
                                JOptionPane.showMessageDialog(null, "Invalid input.");
                        }
                    } while (!break_last_menu_loop);

                    // CHECK HIGH-SCORE AND UPDATE IF NECESSARY
                    /* 
                        NEW IN V4
                        + ADDED: Highscore checker and logger
                    */
                    File highscore_file = new File("highscore.txt");
                    Scanner read_highscore = new Scanner(highscore_file);

                    if (Integer.parseInt(read_highscore.nextLine()) < point) {
                        PrintWriter print_highscore = new PrintWriter(highscore_file);
                        print_highscore.print(point);
                        print_highscore.close();
                    }

                    point = 0; // Resets score to 0 so that the player does not accumulate points from different attemts.
                    break;

                case 3: // Exit the game: no score to display
                    JOptionPane.showMessageDialog(null, goodbyeMessage);
                    exit_game_loop = true;
                    break;

                default:
                    // If the user inputs an unavaiable integer
                    JOptionPane.showMessageDialog(null, "Invalid input, please restart the game and input an integer from 1 to 3.");
            }
            read_questions.close(); // Prevent data leak
        } while (!exit_game_loop);
    }   
}