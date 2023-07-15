/*
    Michel Aguilera
    July 15, 2023
    Group Project Verson 4.0

----------------------------------------------
----------------------------------------------
*/

// DEPENDENCIES
import java.util.Scanner;
import java.io.File;
import javax.swing.JOptionPane; // Needed for dialogue boxes

// MAIN
public class App {
    public static void main(String[] args) {

        File questions_file = new File("questions.txt");
        Scanner read_questions = new Scanner(questions_file);

        // Declaring the variables
        int point = 0;
        int menuChoice = 0;

        String name = JOptionPane.showInputDialog(null, "Please input your name below.");
        String answerOne, answerTwo, answerThree, answerFour, answerFive, answerSix, answerSeven;

        String introduction =   name.toUpperCase() + ", WELCOME TO THE JAVA PROGRAMMER GAME!";
        String goodbyeMessage = "Thanks for playing the JAVA PROGRAMMER GAME!";

        String menu =           "MENU:\n[1] See the rules\n[2] Start the game\n[3] Exit"; // missing from v1, corrected in v2
        String finalMenu =      "Would you like to play again?\n[1] Yes, I'd like to play again\n[2] No, please exit"; // Added in V3
        String rules =          "You have chosen to see the rules. The game will give you a set of 10 questions about Java. If you answer correctly, points will be added to your score. Have fun!";

        

        // Main logic 
        /*
        boolean exit_game_loop = false;
        do {
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(null, introduction + "\n" + menu));
            switch (menuChoice) {
                case 1: // See the rules
                    JOptionPane.showMessageDialog(null, rules);
                    break; // Prevents jump to the questions after selecting to see the rules
                case 2: // Play the game

                    /*
                        NEW IN V3:
                        * Displays current score in the same window as the question
                          so that the player keeps track of their score without
                          needing too many dialogue boxes
                        ----------------------------------------------------------
                        NEW IN V2.1:
                        * Moved the questions inside case 2
                        ----------------------------------------------------------
                        NEW IN V2:
                        * Algorithm to check for the correct answers to the questions,
                          accumulates a score and shows it to the player at the end.
                    * /

                    // QUESTION 1
                    String question_text;
                    do {
                        String answer;
                        int question_point_value;

                        for (int line = 1; line < 5; line++) {
                            // System.out.println(read_questions.nextLine());
                            
                        }

                        break;
                    } while (true);
    
                    // QUESTION 2
                    // do {
                    //     answerTwo = JOptionPane.showInputDialog(null, questionTwo + "\nYour current score is: " + point);
                    //     if (answerTwo.equalsIgnoreCase("D")) {
                    //         point += 2;
                    //         JOptionPane.showMessageDialog(null, "Correct!");
                    //         break;
                    //     } else if (answerTwo.equalsIgnoreCase("A") || answerTwo.equalsIgnoreCase("B") || answerTwo.equalsIgnoreCase("C") || answerTwo.equalsIgnoreCase("D")) {
                    //         JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: D");
                    //         break;
                    //     } else {
                    //         JOptionPane.showMessageDialog(null, "Invalid input.");
                    //     }
                    // } while (true);


                    // V3 ) Add option to continue the game or to exit
                    /* 
                        This while loop is responsible for wrapping up
                        the game. It asks the player whether to continue
                        or exit the game, informing them of the score.

                        The local boolean variable break_last_menu_loop
                        is needed to set the exit conditions for the menu 
                        that appears at the end of the game.
                            boolean break_last_menu_loop = false;

                        NEW IN V3) Case 2 now always breaks:
                            This is done for 4 reasons;
                            1. Case 3 displays a goodbye message that is 
                               no longer necessary to jump to; the last 
                               menu includes a goodbye message.
                            2. The goodbye message inside case 2 displays
                               the score, which case 3 does not do.
                            3. This reserves the case 3 goodbye message
                               for the person who selects exit without playing
                               the game, while the case 2 goodbye message
                               includes data only available if the player
                               decides to play the game.
                            4. Prevents both goodbye messages from displaying
                               back-to-back; only displaying one goodbye message.

                    * /
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
        } while (!exit_game_loop);
        */

        read_questions.close();
    }   
}