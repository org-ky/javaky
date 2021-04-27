package com.orgky.examples.maven;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  //@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Hello World HttpServlet Class Example</h1>");
        printWriter.print("<a href=\"http://www.javaguides.net\">Java Guides</a>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String yourName = request.getParameter("yourName");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello " + yourName + "</h1>");
		writer.close();
		
		//Initialize Request Dispatcher
        /*RequestDispatcher dispatcher = null;
 
 
        //System outs for troubleshooting
        System.out.println("test");
        System.out.println("Now go back to the jsp file and count");
 
        dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);*/
	}

}
