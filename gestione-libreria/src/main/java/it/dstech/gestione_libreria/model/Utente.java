package it.dstech.gestione_libreria.model;

public class Utente {

	private String username;

	private String password;

	private boolean active;

	private byte[] image;

	public Utente(String username, String password, boolean active, byte[] image) {
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
