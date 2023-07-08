/*
    Michel Aguilera, Mahith Allu, Zach Miller, Jose Mendoza
    June 28, 2023
    Group Project Verson 2.1

----------------------------------------------

    PSEUDOCODE:

    Variables:
    int point
    int menuChoice
    String name
    String answerOne, answerTwo, answerThree, answerFour, answerFive
    String introduction
    String rules
    String goodbyeMessage
    String menu
    String questionOne, questionTwo, questionThree, questionFour, questionFive

    Logic:
    Prompt for name
    Concatenate name with introduction message and store in introduction variable
    Set menu string
    Set rules string
    Set goodbyeMessage string
    Set questionOne string
    Set questionTwo string
    Set questionThree string
    Set questionFour string
    Set questionFive string

    Prompt for menuChoice with introduction and menu

    Switch menuChoice:
        Case 1:
            Display rules
            (Continue to Case 2 to start the game)
        Case 2:
            Prompt for answerOne with questionOne
            If answerOne equals "D" (case insensitive):
                Increment point by 1
                Display "Correct!"
            Else if answerOne is "A", "B", "C" or "D":
                Display "Incorrect, the correct answer was: D"
            Else:
                Display "Invalid input."

            Prompt for answerTwo with questionTwo
            If answerTwo equals "D" (case insensitive):
                Increment point by 2
                Display "Correct!"
            Else if answerTwo is "A", "B", "C" or "D":
                Display "Incorrect, the correct answer was: D"
            Else:
                Display "Invalid input."

            Prompt for answerThree with questionThree
            If answerThree equals "A" (case insensitive):
                Increment point by 3
                Display "Correct!"
            Else if answerThree is "A", "B", "C" or "D":
                Display "Incorrect, the correct answer was: A"
            Else:
                Display "Invalid input."

            Prompt for answerFour with questionFour
            If answerFour equals "A" (case insensitive):
                Increment point by 4
                Display "Correct!"
            Else if answerFour is "A", "B", "C" or "D":
                Display "Incorrect, the correct answer was: A"
            Else:
                Display "Invalid input."

            Prompt for answerFive with questionFive
            If answerFive equals "B" (case insensitive):
                Increment point by 5
                Display "Correct!"
            Else if answerFive is "A", "B", "C" or "D":
                Display "Incorrect, the correct answer was: B"
            Else:
                Display "Invalid input."

            Display goodbyeMessage and final score
            
        Case 3:
            Display goodbyeMessage
        Default:
            Display "Invalid input, please restart the game and input an integer from 1 to 3."


----------------------------------------------

*/

// DEPENDENCIES
import javax.swing.JOptionPane; // Needed for dialogue boxes

// MAIN
public class Project {
    public static void main(String[] args) { // this line says the magic words apperently needed to compile (java is weird) -- Michel

        // Declaring the variables
        int point = 0;
        int menuChoice = 0;

        String name = JOptionPane.showInputDialog(null, "Please input your name below.");
        String answerOne, answerTwo, answerThree, answerFour, answerFive, answerSix, answerSeven;
        
        String againPlay = null;

        String introduction =   name.toUpperCase() + ", WELCOME TO THE JAVA PROGRAMMER GAME!";
        String goodbyeMessage = "Thanks for playing the JAVA PROGRAMMER GAME!";

        String menu =           "MENU:\n[1] See the rules\n[2] Start the game\n[3] Exit"; // missing from v1, corrected in v2
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
                				" A loop that repeats itself a specific number of times is known as a(n)\n"+
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
        do
        {
        	menuChoice = Integer.parseInt(JOptionPane.showInputDialog(null, introduction + "\n" + menu));
        	switch (menuChoice) {
            case 1: 
                JOptionPane.showMessageDialog(null, rules);
                // No break added for case 1; so that the player can play the game after seeing the rules
            case 2:
                // Check the answers (Added in V1, modified in V2, V2.1)

                /*
                * NEW IN V2:
                * 
                * Algorithm to check for the correct answers to the questions,
                * Accumulates a score and shows it to the player at the end.
                * 
                * NEW IN V2.1:
                * 
                * Moved the questions inside case 2
                *
                *NEW IN V3:
                *
                *New questions added 
                *
                */
            	do {
            		answerOne = JOptionPane.showInputDialog(null, questionOne);
                    if ("D".equalsIgnoreCase(answerOne)) {
                        point += 1;
                        JOptionPane.showMessageDialog(null, "Correct!");
                    } else if (answerOne.equalsIgnoreCase("A") || answerOne.equalsIgnoreCase("B") || answerOne.equalsIgnoreCase("C") || answerOne.equalsIgnoreCase("D")) {
                        JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: D");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input.");
                    }

                    answerTwo = JOptionPane.showInputDialog(null, questionTwo);
                    if ("D".equalsIgnoreCase(answerTwo)) {
                        point += 2;
                        JOptionPane.showMessageDialog(null, "Correct!");
                    } else if (answerTwo.equalsIgnoreCase("A") || answerTwo.equalsIgnoreCase("B") || answerTwo.equalsIgnoreCase("C") || answerTwo.equalsIgnoreCase("D")) {
                        JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: D");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input.");
                    }

                    answerThree = JOptionPane.showInputDialog(null, questionThree);
                    if ("A".equalsIgnoreCase(answerThree)) {
                        point += 3;
                        JOptionPane.showMessageDialog(null, "Correct!");
                    } else if (answerThree.equalsIgnoreCase("A") || answerThree.equalsIgnoreCase("B") || answerThree.equalsIgnoreCase("C") || answerThree.equalsIgnoreCase("D")) {
                        JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: A");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input.");
                    }

                    // V2) Added questions 4 and 5
                    answerFour = JOptionPane.showInputDialog(null, questionFour);
                    if ("A".equalsIgnoreCase(answerFour)) {
                        point += 4;
                        JOptionPane.showMessageDialog(null, "Correct!");
                    } else if (answerFour.equalsIgnoreCase("A") || answerFour.equalsIgnoreCase("B") || answerFour.equalsIgnoreCase("C") || answerFour.equalsIgnoreCase("D")) {
                        JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: A");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input.");
                    }

                    answerFive = JOptionPane.showInputDialog(null, questionFive);
                    if ("B".equalsIgnoreCase(answerFive)) {
                        point += 5;
                        JOptionPane.showMessageDialog(null, "Correct!");
                    } else if (answerFive.equalsIgnoreCase("A") || answerFive.equalsIgnoreCase("B") || answerFive.equalsIgnoreCase("C") || answerFive.equalsIgnoreCase("D")) {
                        JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: B");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input.");
                    }
                    
                    answerSix = JOptionPane.showInputDialog(null, questionSix);
                    if("C".equalsIgnoreCase(answerSix)) {
                    	point += 6;
                    	JOptionPane.showMessageDialog(null,  "Correct!");
                    } else if (answerSix.equalsIgnoreCase("A") || answerSix.equalsIgnoreCase("B") || answerSix.equalsIgnoreCase("C") || answerSix.equalsIgnoreCase("D")) {
                    	JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: C");
                    }else {
                    	JOptionPane.showMessageDialog(null,  "Invalid input.");
                    }
                    
                    answerSeven = JOptionPane.showInputDialog(null, questionSeven);
                    if("A".equalsIgnoreCase(answerSeven)) {
                    	point += 7;
                    	JOptionPane.showMessageDialog(null,  "Correct!");
                    } else if (answerSeven.equalsIgnoreCase("A") || answerSeven.equalsIgnoreCase("B") || answerSeven.equalsIgnoreCase("C") || answerSeven.equalsIgnoreCase("D")) {
                    	JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: A");
                    }else {
                    	JOptionPane.showMessageDialog(null,  "Invalid input.");
                    }
            	} while (false);
                
               
           
                JOptionPane.showMessageDialog(null, goodbyeMessage + "\nYour score was: " + point);
                
                againPlay = JOptionPane.showInputDialog(null, "Do you want to play again?(Y/N)");
                break;
            	case 3:
                JOptionPane.showMessageDialog(null, goodbyeMessage);
                break;
            	default:
                JOptionPane.showMessageDialog(null, "Invalid input, please restart the game and input an integer from 1 to 3."); }
        	
        } while (againPlay.equalsIgnoreCase("Y"));
    }   
}