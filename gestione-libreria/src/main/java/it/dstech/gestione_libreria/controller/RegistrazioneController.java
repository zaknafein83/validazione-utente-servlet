package it.dstech.gestione_libreria.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.gestione_libreria.model.Utente;
import it.dstech.gestione_libreria.repository.DBManagment;
import it.dstech.gestione_libreria.service.EmailUtility;

@WebServlet(urlPatterns = { "/registrazione" })
public class RegistrazioneController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", "Pagina non accessibile");
		req.getRequestDispatcher("/home_page.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		DBManagment gestioneDB = null;
		try {
			gestioneDB = new DBManagment();
			Utente utente = gestioneDB.salvaUtente(username, password);
			EmailUtility.sendEmail(utente.getUsername(), "Conferma Mail", generaLinkValidazioneUtente(utente));
			gestioneDB.close();
			req.setAttribute("message", "Controlla la mail per attivare l'account");
			req.getRequestDispatcher("/home_page.jsp").forward(req, resp);

		} catch (ClassNotFoundException | SQLException | MessagingException e) {
			try {
				gestioneDB.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			req.setAttribute("message", "Mail già presente nel DB");
			req.getRequestDispatcher("/home_page.jsp").forward(req, resp);

		}

	}

	private String generaLinkValidazioneUtente(Utente utente) {
		String validationPath = "http://localhost:8080/gestione-libreria/validazione?utente=";
		return "Per attivare la mail clicca su questo link: " + validationPath + utente.getUsername();
	}

}
