package modelo;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
	public List<Item> itensVendedor;
	public String nome;
	
	public Vendedor(String nome) {
		this.nome = nome;
		this.itensVendedor = new ArrayList<>();
		
	}
	
	public Vendedor(String nome, List<Item> itens) {
		this.nome = nome;
		itensVendedor = itens;
	}
	
	public String getNome() {
		return nome;
	}

	public List<Item> getItensVendedor() {
		return itensVendedor;
	}
	
	public void adicionarItem (Item i) {
		itensVendedor.add(i);
	}
	
	public void removerItem (Item i) {
		itensVendedor.remove(i);
	}
	
}
