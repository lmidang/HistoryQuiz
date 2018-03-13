/**
 * @author Lynn Dang
 * @period P2
 *
 * This class utilizes Question and QuestionBank to create a full test and record the top highest scores
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main (String[] args) {
		Scanner std = new Scanner(System.in);
		
		boolean continued = true;
		ArrayList<Question> questions = new ArrayList<Question>();
		String[] highestScorers = new String[5];
		int[] highestScores = new int[5];
		
		QuestionBank questionBank = new QuestionBank(10, "questions", "answers", "choices");
		
		while (continued) {
			System.out.print("Enter name here ");
			String name = std.nextLine();
			int score = 0;
			
			questionBank.randomizer(questions);
			
			// Test
			int num = 1;
			while(!questions.isEmpty()) {
				System.out.print(num + ". ");
				questions.get(0).printQuestion();
				if (questions.get(0).checkAnswer() == true) {
					score++;
				}
				questions.remove(0);
				System.out.println();
				num++;
			}
			System.out.println("Your Score is " + score);
			
			// Checks highest score
			for (int i = 0; i < 5; i++) {
				if (score > highestScores[i] || highestScorers[i] == null) {
					for (int j = 4; j > i; j--) {
						highestScores[j] = highestScores[j - 1];
						highestScorers[j] = highestScorers[j - 1];
					}
					highestScores[i] = score;
					highestScorers[i] = name;
					break;
				}
			}
			
			// Prints highest score
			System.out.println("Highest scores");
			for (int i = 0; i < 5; i++) {
				System.out.println(highestScorers[i] + ": " + highestScores[i]);
			}
			
			boolean answered = false;
			while (!answered) {
				System.out.println("Continue Y or N?");
				String an = std.nextLine();
				if (an.equals("N")) {
					continued = false;
					answered = true;
				} else if (an.equals("Y")) {
					answered = true;
				}
			}
		}
	}
}
