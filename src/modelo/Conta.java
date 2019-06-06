package modelo;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	private String usuario;
	private String senha;
	private String email;
	private List<Personagem> personagens = new ArrayList<Personagem>();
	public Conta(String usuario, String senha, String email) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
	}
	
	public Personagem localizarPersonagem(String nome) {
		for(Personagem p: personagens) {
			if (p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Personagem> getPersonagens() {
		return personagens;
	}
	
	public void setPersonagens(List<Personagem> personagens) {
		this.personagens = personagens;
	}
	
	public void addPersonagem(Personagem personagem) {
		personagens.add(personagem);
	}

	@Override
	public String toString() {
		return "Conta [usuario=" + usuario + "]";
	}
	
	
	
}
