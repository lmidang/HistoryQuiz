import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Jeremy Trejos Period 2
 * 
 *         This class creates the question bank and creates another list of 5
 *         questions randomly picked in the bank
 */
public class QuestionBank {
	Scanner sc;
	Random rand;
	ArrayList<Question> questions = new ArrayList<Question>();

	/**
	 * constructor that uses Question class and creates the question bank
	 * 
	 * @param f
	 *            - question file
	 * @param a
	 *            - correct answers file
	 * @param c
	 * 			  - choices file	
	 */
	public QuestionBank(int seed, String f, String a, String c) {
		rand = new Random(seed);
		
		try {
			Scanner scq = new Scanner(new File(f + ".txt"));
			Scanner sca = new Scanner(new File(a + ".txt"));
			Scanner scc = new Scanner(new File(c + ".txt"));
			
			while (sca.hasNext()) {//scq.hasNext() && sca.hasNext() && scc.hasNext()) {
				String num = scc.nextLine();
				String[][] choices = new String[5][2];
				for (int i = 0; i < 5; i++) {
					choices[i][0] = scc.nextLine();
					choices[i][1] = scc.nextLine();
				}
				
				String ans = sca.next();
				if (!ans.equals("A") &&
					!ans.equals("B") &&
					!ans.equals("C") &&
					!ans.equals("D") &&
					!ans.equals("E") ) {
					throw (new Exception());
				}
				
				questions.add(new Question(scq.nextLine(), ans, choices));
			}
		} catch (Exception e){
			System.out.println("Problem with text");
		}
	}

	/**
	 * method that takes 5 random questions and adds them to another list of
	 * questions
	 * 
	 * @param randQuestions
	 *            - the list of randomized questions
	 */
	public void randomizer(ArrayList<Question> randQuestions) {
		ArrayList<Question> qs = new ArrayList<Question>(questions);
		for (int i = 0; i < 5; i++) {
			int a = rand.nextInt(qs.size()) + 1;
			randQuestions.add(qs.get(a));
			qs.remove(a);
		}
	}

}
