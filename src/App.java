/*
    Michel Aguilera
    June 11, 2023
    Group Project Version 1.0

----------------------------------------------

    My general plan for this program:

    Since there are multiple question
    objects needed for this program,
    here are the classes I would create:

    Question Class:
    Contains the question, the possible
    answers, the correct answer and
    point value.

    User Class:
    Contains the current score of the
    user.

    Window Class:
    Displays the current values from the
    User Class.

----------------------------------------------

    In order to avoid hard-coding in the
    questions, I would make an array
    that contains a dictionary. The
    dictionary will store the string
    for the question and the strings for the
    possible answers.

----------------------------------------------

    Logic Flow (for V1):

    On run;
    1. Display an Introduction to the Game.
    1a. Promt user for their name
    2. Display the main menu.
    2a (1 is pressed) See Rules: Display the rules
    2b (2 is pressed) Play Game: Move to step 3
    2c (3 is pressed) Exit: No function at the moment
    2_temp1: (PERFORM STEP 2a regardless of input)
    3. Display a question, await user response. 
        * Repeat until all questions are answered.

*/

/*

    PSEUDOCODE:

    Variables:
    String name
    String questionOne, questionTwo, questionThree
    String introduction
    String rules
    String goodbyeMessage

    Logic:
    Promt name
    Display introduction + rules
    For each question in quiz:
        Display question
        Promt answer
    Display goodbyeMessage

*/

// DEPENDENCIES
import javax.swing.JOptionPane; // Needed for dialogue boxes

// MAIN
public class App {
    public static void main(String[] args) throws Exception { // this line says the magic words apperently needed to compile (java is weird) -- Michel

        // Declaring the variables (temporarily violating OOP, and only three questions)
        String name; 
        String answerOne, answerTwo, answerThree;

        String introduction =   "WELCOME TO THE JAVA PROGRAMMER GAME!";
        String goodbyeMessage = "Thanks for playing the JAVA PROGRAMMER GAME!";

        String rules =          "demz da rulez.. (placeholder for actual rules later)";

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

        // Main logic
        name = JOptionPane.showInputDialog(null, "Please input your name below.");
        JOptionPane.showMessageDialog(null, introduction + "\n" + rules);
        answerOne = JOptionPane.showInputDialog(null, questionOne);
        answerTwo = JOptionPane.showInputDialog(null, questionTwo);
        answerThree = JOptionPane.showInputDialog(null, questionThree);
        JOptionPane.showMessageDialog(null, goodbyeMessage);
    }
}


/*
 * /*Mahith Allu
 * 06/11/2023
 * Program is a game show app
 

import java.util.Scanner;
public class Project {

	public static void main(String[] args) {
		//Declare necessary variables
		String name;
		int choice;
		String questionOne;
		String questionTwo;
		String questionThree;
		//Introduction
		System.out.println("WELCOME TO THE JAVA PROGRAMMER GAME!!\n");
		Scanner keyboard = new Scanner(System.in);
		//Input of player
		System.out.print("What is your name player? ");
		name = keyboard.nextLine();
		//Player Choice
		System.out.println("\nWould you like to: \n" + "1)See Rules\n" + "2)Play game\n" + "3)Exit\n");
		
		//User Choice 
		System.out.print("Please enter your choice here: ");
		choice = keyboard.nextInt();
		
		//Rules for game
		System.out.println("\nYou have chosen to see the rules. The game will give you a set of 10 questions about Java. Answer correctly and earn points. Have fun!\n");
		
		//Question1
		System.out.println("Question 1:\n" + "What happens to a variable's current value in memory when a new value is stored in the same storage location\n"
				+ "A)An error occurs\n" + "B)Variables value will remain unchanged\n" + "C)Variables value is changed to zero\n"
						+ "D)New value will take the place of current value\n");
		System.out.print("Please enter your answer here: \n");
		questionOne = keyboard.next();
		
		//Question2
		System.out.println("\nQuestion 2\n" + "An error in a program that involves a violation of language rules will be detected at ____ time\n"
				+ "A)translation\n" + "B)runtime\n" + "C)save\n" + "D)compile\n");
		System.out.print("Please enter your answer here: \n");
		questionTwo = keyboard.next();
		
		//Question 3
		System.out.println("\nQuestion 3\n" + "In Java, an argument is\n" + "A)information provided to a method\n" + "B)information that a method provides to its caller\n"
				+ "C)verbal dispute\n" + "D)logical sequence of statements\n");
		System.out.print("Please enter your answer here: \n");
		questionThree = keyboard.next();
		
		//End
		System.out.println("Thanks for playing! Have a nice day!");

	}

}
 */