package javalab.web;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// библиотечный класс для работы с потоками вывода
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

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
    	 String lang = request.getParameter("lang");
    	 if(lang == null) {
	    	 response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,
	    	"Ожидался параметр lang");
	    	 return;
    	 }
    	 if(!"en".equalsIgnoreCase(lang) && !"ru".equalsIgnoreCase(lang)) {
	    	 response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,
	    	"Параметр lang может принимать значения en или ru");
	    	 return;
    	 }

	     // Задание типа кодировки для параметров запроса
	     request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=UTF-8");
	     // Файлы ресурсов book.properties, book_en.properties и book_ru.properties
	     // Установка локализации в соответствии с выбором пользователя
	     ResourceBundle res = ResourceBundle.getBundle("/Product",
	    		 "en".equalsIgnoreCase(lang) ? Locale.ENGLISH : Locale.getDefault());
	     // Чтение параметров из запроса
	     String name = request.getParameter("name");	//имя покупателя
	     String date = request.getParameter("date");	//дата покупки
	     String place  = request.getParameter("place");		//место покупок
	     // Задание типа содержимого для ответа (в том числе кодировки)
	     // Получение потока для вывода ответа
	     PrintWriter out = response.getWriter();
	     try {
		     // Создание HTML-страницы
		     out.println("<html>");
		     
		     out.println("<head><title>");
		     //Вывод строки с учетом локализации
		     out.print(new String(res.getString("title").getBytes("UTF-8"),"UTF-8" ));
		     out.println("</title></head>");
		     
		     out.println("<body bgcolor='#d0d0ff'>");
		     
		     out.println("<h1>");
		     out.print(new String(res.getString("title").getBytes("UTF-8"),"UTF-8" ));
		     out.println("</h1>");
		     
		     out.println("<h3>" 
		    		 + (name != null ? name :"???") 
				     + "</h3>");
		     
		     out.println("<h3>" );
		     out.print(new String(res.getString("dateTitle").getBytes("UTF-8"),"UTF-8" ));
		     out.print((date != null ? date :"???")
		    		 + "</h3>");
		     
		     out.println("<h3>");
		     out.print(new String(res.getString("placeTitle").getBytes("UTF-8"),"UTF-8" ));
		     out.print((place != null ? place :"???")
		    		 + "</h3>");
		     
		     out.println("<table border='10' bgcolor='#e0e0ff' bordercolor='#b0b0ff'>");
		     out.println("<tr><td><b>");
		     out.print(new String(res.getString("productName").getBytes("UTF-8"),"UTF-8" ));
		     out.print("</b></td>");
		     out.println("<td><b>");
		     out.print(new String(res.getString("productNumber").getBytes("UTF-8"),"UTF-8" ));
		     out.print("</b></td>");
		     out.println("<td><b>");
		     out.print(new String(res.getString("productBuy").getBytes("UTF-8"),"UTF-8" ));
		     out.print("</b></td></tr>");
		     
		     out.println("<tr><td>Греча</td><td>2</td><td>Да</td></tr>");
		     out.println("<tr><td>Бананы</td><td>10</td><td>Нет</td></tr>");
		     out.println("<tr><td>Хлеб</td><td>1</td><td>Да</td></tr>");
		     out.println("<tr><td>Сыр</td><td>500</td><td>Да</td></tr>");
		     out.println("<tr><td>Молоко</td><td>1</td><td>Нет</td></tr>");
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
