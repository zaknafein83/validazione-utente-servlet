package it.dstech.gestione_libreria.model;

public class Utente {

	private String username;

	private String password;

	private boolean active;

	private String image;

	public Utente(String username, String password, boolean active, String image) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
		this.image = image;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
