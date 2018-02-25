package listener;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import quiz.Quiz;

public class QuizContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		QuizContextListener qc = new QuizContextListener();
		ServletContext sc = e.getServletContext();
		
		String fileContext = qc.readFile(sc.getRealPath("/WEB-INF/quiz.txt"));
		ArrayList<Quiz> quizArray = qc.setQuiz(fileContext);
		sc.setAttribute("quizarray", quizArray);
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) { }
	
	private String readFile(String filePath) {
		String fileContext = null;
		try {
			FileInputStream fin = new FileInputStream(filePath);
			byte ba[] = new byte[fin.available()];
	        fin.read(ba);
	        fileContext = new String(ba, "UTF-8");
	        fileContext = fileContext.replace("\uFEFF", "");
	        fin.close();
		} catch(IOException e) { e.printStackTrace(); }
		return fileContext;
	}
	
	private ArrayList<Quiz> setQuiz(String context) {
		ArrayList<Quiz> quizArray = new ArrayList<Quiz>();
		
		String[] group = context.split("\r\n");
		
		for (String s: group) {
			String[] item = s.split(" ");
			Quiz q = new Quiz();
			q.setQuestion(item[0]);
			q.setOption(item[1], true);
			for (int i = 2; i < item.length; i++)
				q.setOption(item[i], false);
			quizArray.add(q);
			System.out.println(q);
		}
		
		return quizArray;
	}
}
