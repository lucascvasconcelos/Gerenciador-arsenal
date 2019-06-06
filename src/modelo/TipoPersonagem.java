package modelo;


import java.util.ArrayList;
import java.util.List;

public class TipoPersonagem {
	private String descricao;
	private List<Personagem> personagens = new ArrayList<Personagem>();

	public TipoPersonagem(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	public void addPersonagem(String nome) {
		for(Personagem p: personagens) {
			if(p.getNome().equals(nome)) {
				personagens.add(p);
			}
		}
	}

	@Override
	public String toString() {
		return "TipoPersonagem [descricao=" + descricao + "]";
	}
	
	
}
