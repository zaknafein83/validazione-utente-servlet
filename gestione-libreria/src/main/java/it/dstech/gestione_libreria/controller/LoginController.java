package it.dstech.gestione_libreria.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.gestione_libreria.model.Utente;
import it.dstech.gestione_libreria.repository.DBManagment;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/home_page.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// chiedere al db i dati dell'utente
		try {
			DBManagment database = new DBManagment();
			Utente utente = database.getUtente(username, password);
			if (utente == null) {
				// utente non esiste
				req.setAttribute("message", "Utente non ancora registrato");
				database.close();
				req.getRequestDispatcher("/home_page.jsp").forward(req, resp);
			} else {
				if (!utente.isActive()) {
					// utente esiste ma non è stato attivato
					req.setAttribute("message", scriviRispostaUtenteNonAttivo(utente));
					database.close();
					req.getRequestDispatcher("/home_page.jsp").forward(req, resp);
				} else {
					req.setAttribute("username", username);
					database.close();
					req.getRequestDispatcher("/profilo_utente.jsp").forward(req, resp);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private String scriviRispostaUtenteNonAttivo(Utente utente) {
		String mailUtente = utente.getUsername();
		int indexOf = mailUtente.indexOf('@');
		String parteFinaleMail = mailUtente.substring(indexOf);
		// franksisca@gmail.com
		// frxxxxxxxx@gmail.com
		String primiDueCaratteri = mailUtente.substring(0, 3);
		String mailFinale = primiDueCaratteri + contaX(indexOf - 2) + parteFinaleMail;
		return "L'utente " + mailFinale + " non ha ancora validato l'email";
	}

	private String contaX(int numeri) {
		String x = "";
		for (int i = 0; i < numeri; i++) {
			x += "x";
		}
		return x;
	}

}
