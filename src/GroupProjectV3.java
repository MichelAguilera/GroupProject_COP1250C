/*
    Michel Aguilera, Mahith Allu, Zach Miller, Jose Mendoza
    July 8, 2023
    Group Project Verson 3.0

----------------------------------------------
PSEUDOCODE V3

Program Start

Import necessary tools for dialogue boxes

Declare variables:
    point = 0
    menuChoice = 0
    name
    answerOne, answerTwo, answerThree, answerFour, answerFive, answerSix, answerSeven
    messages and questions
    
Get name from user input

Create introduction, menu, rules, goodbye messages and questions

Create a loop for the game that will run until user chooses to exit:
    Show menu to user and get menu choice
    Based on menu choice, do the following:
        If choice is 1:
            Show rules
        If choice is 2:
            For each question from 1 to 7 do:
                Repeat until valid input:
                    Show question with current score to user and get user answer
                    If user answer is correct:
                        Increment score, and inform user their answer is correct
                    If user answer is one of the available options but not correct:
                        Inform user their answer is incorrect and show the correct answer
                    If user answer is not one of the available options:
                        Inform user their input is invalid
            Ask user if they want to play again or exit:
                If user wants to play again:
                    Continue with the game loop
                If user wants to exit:
                    Show final score and goodbye message
                    Exit game loop
        If choice is 3:
            Show goodbye message
            Exit game loop
        If choice is not 1, 2, or 3:
            Inform user that their input is invalid and ask them to restart the game and input an integer from 1 to 3

Program End

----------------------------------------------
*/

// DEPENDENCIES
import javax.swing.JOptionPane; // Needed for dialogue boxes

// MAIN
public class GroupProjectV3 {
    public static void main(String[] args) {

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

        String questionOne =    "Question 1:\n" + 
                                "What happens to a variable's current value in memory when a new value is stored in the same storage location\n" + 
                                "A) An error occurs\n" + 
                                "B) Variables value will remain unchanged\n" + 
                                "C) Variables value is changed to zero\n" + 
                                "D) New value will take the place of current value\n";
        String questionTwo =    "Question 2\n" + 
                                "An error in a program that involves a violation of language rules will be detected at ____ time\n" + 
                                "A) translation\n" + 
                                "B) runtime\n" + 
                                "C) save\n" + 
                                "D) compile\n";
        String questionThree =  "\nQuestion 3\n" + 
                                "In Java, an argument is\n" + 
                                "A) information provided to a method\n" + 
                                "B) information that a method provides to its caller\n" +
                                "C) verbal dispute\n" + 
                                "D) logical sequence of statements\n";

        // V2) Added questions 4 and 5
        String questionFour =   "\nQuestion 4\n" +
                                ">,<, and == are____.\n"+
                                "A) relational operators\n"+
                                "B) logical operators\n"+
                                "C) conditional operators\n"+
                                "D) ternary operators\n";

        String questionFive =   "\nQuestion 5\n"+
                                "How does the 'A' character compares to the character 'B'\n"+
                                "A) 'A' is greater than 'B'\n"+
                                "B) 'A' is less than 'B'\n"+
                                "C) 'A' is equal to 'b'\n"+
                                "D) You cannot compare characters\n";

        // V3) Added questions 6 and 7
        String questionSix =   "\nQuestion 6\n"+
                				"A loop that repeats itself a specific number of times is known as a(n)\n"+
                				"A) Finite Loop\n"+
                				"B) Total-Drive Loop\n"+
                				"C) Count-controlled loop\n"+
                				"D) Precise Loop\n";
        
        String questionSeven =  "\nQuestion 7\n"+
                				"The while loop is known as an ___ loop, which means it tests its expression before each iteration\n"+
                				"A) Pretest\n"+
                				"B) Binary\n"+
                				"C) Classic\n"+
                				"D) Posttest\n";

        // Main logic

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
                    */

                    // QUESTION 1
                    do {
                        answerOne = JOptionPane.showInputDialog(null, questionOne + "\nYour current score is: " + point);
                        if (answerOne.equalsIgnoreCase("D")) {
                            point += 1;
                            JOptionPane.showMessageDialog(null, "Correct!");
                            break;
                        } else if (answerOne.equalsIgnoreCase("A") || answerOne.equalsIgnoreCase("B") || answerOne.equalsIgnoreCase("C") || answerOne.equalsIgnoreCase("D")) {
                            JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: D");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.");
                        }
                    } while (true);
    
                    // QUESTION 2
                    do {
                        answerTwo = JOptionPane.showInputDialog(null, questionTwo + "\nYour current score is: " + point);
                        if (answerTwo.equalsIgnoreCase("D")) {
                            point += 2;
                            JOptionPane.showMessageDialog(null, "Correct!");
                            break;
                        } else if (answerTwo.equalsIgnoreCase("A") || answerTwo.equalsIgnoreCase("B") || answerTwo.equalsIgnoreCase("C") || answerTwo.equalsIgnoreCase("D")) {
                            JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: D");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.");
                        }
                    } while (true);
    
                    // QUESTION 3
                    do {
                        answerThree = JOptionPane.showInputDialog(null, questionThree + "\nYour current score is: " + point);
                        if (answerThree.equalsIgnoreCase("A")) {
                            point += 3;
                            JOptionPane.showMessageDialog(null, "Correct!");
                            break;
                        } else if (answerThree.equalsIgnoreCase("A") || answerThree.equalsIgnoreCase("B") || answerThree.equalsIgnoreCase("C") || answerThree.equalsIgnoreCase("D")) {
                            JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: A");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.");
                        }
                    } while (true);
    
                    // QUESTION 4
                    do {
                        // V2) Added questions 4 and 5
                        answerFour = JOptionPane.showInputDialog(null, questionFour + "\nYour current score is: " + point);
                        if (answerFour.equalsIgnoreCase("A")) {
                            point += 4;
                            JOptionPane.showMessageDialog(null, "Correct!");
                            break;
                        } else if (answerFour.equalsIgnoreCase("A") || answerFour.equalsIgnoreCase("B") || answerFour.equalsIgnoreCase("C") || answerFour.equalsIgnoreCase("D")) {
                            JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: A");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.");
                        }
                    } while (true);
    
                    // QUESTION 5
                    do {
                        answerFive = JOptionPane.showInputDialog(null, questionFive + "\nYour current score is: " + point);
                        if (answerFive.equalsIgnoreCase("B")) {
                            point += 5;
                            JOptionPane.showMessageDialog(null, "Correct!");
                            break;
                        } else if (answerFive.equalsIgnoreCase("A") || answerFive.equalsIgnoreCase("B") || answerFive.equalsIgnoreCase("C") || answerFive.equalsIgnoreCase("D")) {
                            JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: B");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.");
                        }
                    } while (true);
    
                    // QUESTION 6
                    do {
                        answerSix = JOptionPane.showInputDialog(null, questionSix + "\nYour current score is: " + point);
                        if (answerSix.equalsIgnoreCase("C")) {
                            point += 6;
                            JOptionPane.showMessageDialog(null, "Correct!");
                            break;
                        } else if (answerSix.equalsIgnoreCase("A") || answerSix.equalsIgnoreCase("B") || answerSix.equalsIgnoreCase("C") || answerSix.equalsIgnoreCase("D")) {
                            JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: C");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.");
                        }
                    } while (true);
    
                    // QUESTION 7
                    do {
                        answerSeven = JOptionPane.showInputDialog(null, questionSeven + "\nYour current score is: " + point);
                        if (answerSeven.equalsIgnoreCase("A")) {
                            point += 7;
                            JOptionPane.showMessageDialog(null, "Correct!");
                            break;
                        } else if (answerSeven.equalsIgnoreCase("A") || answerSeven.equalsIgnoreCase("B") || answerSeven.equalsIgnoreCase("C") || answerSix.equalsIgnoreCase("D")) {
                            JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: A");
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.");
                        }
                    } while (true);


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

                    */
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
    }   
}