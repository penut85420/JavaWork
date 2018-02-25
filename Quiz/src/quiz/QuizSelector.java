package quiz;

import java.util.*;

public class QuizSelector {
	public Quiz getRandQuiz(ArrayList<Quiz> quizArray) {
		return quizArray.get((int) Math.floor(Math.random() * quizArray.size()));
	}
}
