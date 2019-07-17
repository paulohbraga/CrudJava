package CrudJava;

public class Contato {
	
	private String nome;
	private String sobrenome;
	private String email;
	private String date;
	
	
	public Contato() {
	}
	
	public Contato( String nome, String sobrenome, String email, String date) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.date = date;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
