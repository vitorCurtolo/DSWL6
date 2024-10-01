package com.exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Exercicio9
 */
@WebServlet("/Exercicio9")
public class Exercicio9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> nameList = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Exercicio9() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("nome");
		String userNameToRemove = request.getParameter("remover");

		if (!nameList.isEmpty() && userNameToRemove != null && !userNameToRemove.isEmpty()) {

			synchronized (nameList) {
				nameList.remove(userNameToRemove);
			}

		}

		if (userName != null && !userName.isEmpty()) {
			synchronized (nameList) {
				nameList.add(userName);
			}
		}

		response.setContentType("text/html");
		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>Lista de Nomes</title></head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Nomes Armazenados:</h1>");
		response.getWriter().println("<p>?nome=[nome] : para adicionar nome</p>");
		response.getWriter().println("<p>?remover=[nome] : para remover nome</p>");
		response.getWriter().println("<ul>");

		synchronized (nameList) {
			for (String storedName : nameList) {
				response.getWriter().println("<li>" + storedName + "</li>");
			}
		}

		response.getWriter().println("</ul>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
