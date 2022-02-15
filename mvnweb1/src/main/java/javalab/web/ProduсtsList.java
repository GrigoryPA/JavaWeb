package javalab.web;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// библиотечный класс для работы с потоками вывода
import java.io.PrintWriter;

/**
 * Servlet implementation class ProduсtsList
 */
//@WebServlet("/ProductsList")
public class ProduсtsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduсtsList() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    		 throws ServletException, IOException {
	     // Задание типа кодировки для параметров запроса
	     request.setCharacterEncoding("utf-8");
	     // Чтение параметров из запроса
	     String name = request.getParameter("name");	//имя покупателя
	     String date = request.getParameter("date");	//дата покупки
	     String place  = request.getParameter("place");		//место покупок
	     // Задание типа содержимого для ответа (в том числе кодировки)
	     response.setContentType("text/html;charset=UTF-8");
	     // Получение потока для вывода ответа
	     PrintWriter out = response.getWriter();
	     try {
		     // Создание HTML-страницы
		     out.println("<html>");
		     out.println("<head><title>Список покупок</title></head>");
		     out.println("<body bgcolor='#d0d0ff'>");
		     out.println("<h1>Список покупок</h1>");
		     out.println("<h3>" 
		    		 + (name != null ? name :"<<Без имени>>") 
				     + "</h3>");
		     out.println("<h3>Список покупок на " 
		    		 + (date != null ? date :"<<Без даты>>")
		    		 + "</h3>");
		     out.println("<h3>Место покупок - " 
		    		 + (place != null ? place :"<<Без места>>")
		    		 + "</h3>");
		     out.println("<table border='10' bgcolor='#e0e0ff' bordercolor='#b0b0ff'>");
		     out.println("<tr><td><b>Навание</b></td>" 
		    		 + "<td><b>Количество</b></td>" 
		    		 + "<td><b>Приобрел</b></td></tr>");
		     out.println("<tr><td>Греча</td><td>2 пачки</td><td>Да</td></tr>");
		     out.println("<tr><td>Бананы</td><td>10 штук</td><td>Нет</td></tr>");
		     out.println("<tr><td>Хлеб</td><td>1 штука</td><td>Да</td></tr>");
		     out.println("<tr><td>Сыр</td><td>500 грамм</td><td>Да</td></tr>");
		     out.println("<tr><td>Молоко</td><td>1 литр</td><td>Нет</td></tr>");
		     out.println("</table>");
		     out.println("</body>");
		     out.println("</html>");
	     } finally {
		     // Закрытие потока вывода
		     out.close();
	     }
     }
    
    
     /**
      * Handles the HTTP
      * <code>GET</code> method.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
      @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  processRequest(request, response);
    }

      /**
       * Handles the HTTP
       * <code>POST</code> method.
       *
       * @param request servlet request
       * @param response servlet response
       * @throws ServletException if a servlet-specific error occurs
       * @throws IOException if an I/O error occurs
       */
       @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
