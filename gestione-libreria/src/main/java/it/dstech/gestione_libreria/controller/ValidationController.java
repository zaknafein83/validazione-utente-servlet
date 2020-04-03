package it.dstech.gestione_libreria.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.gestione_libreria.repository.DBManagment;

@WebServlet(urlPatterns = {"/validazione"})
public class ValidationController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mailUtente = req.getParameter("utente");
		DBManagment gestione;
		try {
			gestione = new DBManagment();
			gestione.validaUtente(mailUtente);
			gestione.close();
			req.setAttribute("message", "L'utente " + mailUtente + " è stato validato");
			req.getRequestDispatcher("/home_page.jsp").forward(req, resp);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
