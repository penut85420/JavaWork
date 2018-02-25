<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<%@
    page import = "quiz.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quiz</title>
</head>
<body>
	<form action = "quizrandom.so" method = "post">
		<%
			Quiz q = (Quiz)request.getAttribute("quiz");
			String[] opt = {"A", "B", "C", "D"};
			if (q != null) {
				out.println(q.getQuestion());
				opt = q.getRandomOption();
			}
		%>
		<input type = "radio" name = "opt" value = "<% out.println(opt[0]); %>">
			<% out.println(opt[0]); %><br>
			
		<input type = "radio" name = "opt" value = "<% out.println(opt[1]); %>">
			<% out.println(opt[1]); %><br>
			
		<input type = "radio" name = "opt" value = "<% out.println(opt[2]); %>">
			<% out.println(opt[2]); %><br>
			
		<input type = "radio" name = "opt" value = "<% out.println(opt[3]); %>">
			<% out.println(opt[3]); %><br>
	</form>
</body>
</html>