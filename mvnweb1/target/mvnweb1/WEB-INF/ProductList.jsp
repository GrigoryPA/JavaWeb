<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Список книг</title>
	</head>
	<body>
		<% 
			//установка кодировки входных параметров
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("name");
			RequestDispatcher dispatcher; 
			if (name == null)
			{ 
				//если имя не указано, то перенаправить запрос на страницу обработки ошибок
				ServletContext servletContext = getServletContext();
				dispatcher = servletContext.getRequestDispatcher("/ErrorManager.jsp");
				dispatcher.forward(request, response); 
			}
		%>
		<h1> Список книг читателя <%=name%></h1>
		<%@include file="ListData.jsp"%>
	</body>
</html>