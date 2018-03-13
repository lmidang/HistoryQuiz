import java.util.Scanner;

/**
 * 
 * @author Jeremy Trejos 
 * Period 2 
 * This class creates the question for the user
 * to answer and checks to see if user is correct
 */
public class Question {
	private static final Exception Exception = null;
	private String question;
	String[][] choices;
	Scanner input = new Scanner(System.in);
	String answer = "";
	String correct = "";

	/**
	 * Constructor for a question
	 * @param q 
	 * 				- the question itself
	 * @param a 
	 * 				- an answer
	 * @param c 
	 * 				- the array of choices
	 */
	public Question(String q, String a, String[][] c) {
		this.question = q;
		this.correct = a;
		choices = c;
	}
	
	/**
	 * Prints the question and the answer choices
	 */
	public void printQuestion() {
		System.out.println(question);
		System.out.println("A: " + choices[0][0]);
		System.out.println("B: " + choices[1][0]);
		System.out.println("C: " + choices[2][0]);
		System.out.println("D: " + choices[3][0]);
		System.out.println("E: " + choices[4][0]);
	}

	/**
	 * method that checks if the user input matches the correct answer. prints an explanation for the incorrect and correct
	 * answer
	 * 
	 * @return true, if answer is correct, false if it is not
	 */
	public boolean checkAnswer() {
		answer = input.nextLine();
		String explain = (getExplanation(answer));
		while (explain == null) {
			System.out.println("Plese choose a letter between A and E");
			answer = input.next();
			explain = getExplanation(answer);
		}
		if (answer.equals(correct)) {
			System.out.println("Correct: " + explain);
			return true;
		} else {
			System.out.println("Incorrect: " + explain);
			System.out.println("Correct Answer " + correct + ": " + explain);
			return false;
		}
	}	
	
	public String getExplanation(String choice) {
			if (choice.equals("A")) {
				return choices[0][1];
			} else if (choice.equals("B")) {
				return choices[1][1];
			} else if (choice.equals("C")) {
				return choices [2][1];
			} else if (choice.equals("D")) {
				System.out.println("HI");
				return choices[3][1];
			} else if (choice.equals("E")) {
				return choices[4][1];
			}	else {
				return null;
			}
	}
}
