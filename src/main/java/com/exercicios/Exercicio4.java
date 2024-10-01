package com.exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Exercicio4
 */
@WebServlet("/Exercicio4")
public class Exercicio4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int contador = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercicio4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      synchronized (this) {
	    	  contador++;
	        }

	        response.setContentType("text/html");
	        
	        response.getWriter().println("<html>");
	        response.getWriter().println("<head><title>Contador de Acessos</title></head>");
	        response.getWriter().println("<body>");
	        response.getWriter().println("<h1>Número de acessos: " + contador + "</h1>");
	        response.getWriter().println("</body>");
	        response.getWriter().println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
