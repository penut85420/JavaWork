package servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import quiz.*;

public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		ArrayList<Quiz> quizArray = (ArrayList<Quiz>) request.getServletContext().getAttribute("quizarray");
		QuizSelector selector = new QuizSelector();
		
		Quiz q = selector.getRandQuiz(quizArray);
		request.setAttribute("quiz", q);
		
		RequestDispatcher view = request.getRequestDispatcher("QuestionPrint.jsp");
		view.forward(request, response);
	}
}
