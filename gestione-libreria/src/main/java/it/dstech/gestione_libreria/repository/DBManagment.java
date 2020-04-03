package it.dstech.gestione_libreria.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.locks.StampedLock;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import it.dstech.gestione_libreria.model.Utente;

public class DBManagment {

	private Connection connessione;

	public DBManagment() throws ClassNotFoundException, SQLException, IOException {

		Properties properties = new Properties();
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));

		Class.forName(properties.getProperty("database.drive"));
		String password = properties.getProperty("database.password");
		String username = properties.getProperty("database.username");
		String url = properties.getProperty("database.url");
		this.connessione = DriverManager.getConnection(url, username, password);
	}

	public Utente getUtente(String username, String password) throws SQLException {
		PreparedStatement statement = connessione
				.prepareStatement("select * from utente where username = ? and password = ?");
		statement.setString(1, username);
		statement.setString(2, password);
		ResultSet executeQuery = statement.executeQuery();
		while (executeQuery.next()) {
//			String u = executeQuery.getString(1);
			String u = executeQuery.getString("username");
			String p = executeQuery.getString("password");
			boolean ac = executeQuery.getBoolean("active");
			byte[] img = executeQuery.getBytes("image");
			return new Utente(u, p, ac, img);

		}
		return null;
	}

	public void close() throws SQLException {
		this.connessione.close();
	}

	public Utente salvaUtente(String username, String password) throws SQLException {
		PreparedStatement prepareStatement = this.connessione
				.prepareStatement("INSERT INTO utente (username, password, active) VALUES (?, ?, ?);");
		prepareStatement.setString(1, username);
		prepareStatement.setString(2, password);
		prepareStatement.setBoolean(3, false);
		prepareStatement.execute();

		return new Utente(username, password, false, null);

	}

	public void validaUtente(String mailUtente) throws SQLException {
		PreparedStatement prepareStatement = this.connessione.prepareStatement("UPDATE utente SET active = ? WHERE (username = ?);");
		prepareStatement.setBoolean(1, true);
		prepareStatement.setString(2, mailUtente);
		prepareStatement.execute();
		

		
		
	}
}
