package modelo;

import java.util.ArrayList;
import java.util.List;

public class Personagem {
	private String nome;
	private int nivel;
	private double vida;
	private double ataque;
	private double defesa;
	private float gold;
	private TipoPersonagem tipo;
	private List<Item> itensEquipados = new ArrayList<>();
	private List<Item> itensPersonagem = new ArrayList<Item>();
	
	public Personagem(String nome,  TipoPersonagem tipo) {
		super();
		this.nome = nome;
		this.nivel = 1;
		this.vida = 500;
		this.ataque = 100;
		this.defesa = 50;
		this.tipo = tipo;
		this.gold = 1000; 
	}
	
	
	public float getGold() {
		return gold;
	}


	public void setGold(float gold) {
		this.gold = gold;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public double getAtaque() {
		return ataque;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	public double getDefesa() {
		return defesa;
	}

	public void setDefesa(double defesa) {
		this.defesa = defesa;
	}

	public List<Item> getItensPersonagem() {
		return itensPersonagem;
	}
	public List<Item> getItensEquipados(){
		return itensEquipados;
	}

	public void setItensPersonagem(List<Item> itensPersonagem) {
		this.itensPersonagem = itensPersonagem;
	}
	
	public void addItem(Item item) {
		itensPersonagem.add(item);
	}
	public void removerItem(Item item) {
		itensPersonagem.remove(item);
	}

	@Override
	public String toString() {
		return "Personagem [nome=" + nome + ", nivel=" + nivel + ", vida=" + vida + ", ataque=" + ataque + ", defesa="
				+ defesa + ", tipo=" + tipo + ", itensEquipados=" + itensEquipados + ", itensPersonagem="
				+ itensPersonagem + "]";
	}
	
}
