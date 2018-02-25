package solution;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import quiz.Quiz;

public class SolutionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException{
		
		Quiz q = (Quiz) request.getAttribute("Quiz");
		String userAns = request.getParameter("opt");
		if (q.isAns(userAns)) {
			request.setAttribute("result", true);
		} else {
			request.setAttribute("result", false);
		}
		RequestDispatcher view = request.getRequestDispatcher("ResultPrint.jsp");
		view.forward(request, response);
		
	}
}
