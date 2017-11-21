package pacoteClassesUsuario;

public class Usuario {


	private String nick;
	private String email;
	private String senha;

	public Usuario() {
		this.nick = null;
		this.email = null;
		this.senha = null;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
