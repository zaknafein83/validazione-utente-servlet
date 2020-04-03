package it.dstech.gestione_libreria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/scelta","/"})
public class SceltaController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/home_page.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String attribute = req.getParameter("action");
		String path = "/home_page.jsp";
		if("Registra".equalsIgnoreCase(attribute)) {
			
			path = "/registrazione.jsp";
			
		} else {
			
			path = "/accedi.jsp";
		}
		req.getRequestDispatcher(path).forward(req, resp);

		
		
	}
}
