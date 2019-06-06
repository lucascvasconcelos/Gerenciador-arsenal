package aplicacao;

import com.db4o.ObjectContainer;

import fachada.Fachada;

public class Listar {

	protected static ObjectContainer manager;

	public Listar() {
		Fachada.inicializar();
		
		try {
			
			Fachada.criarVendedor("A");
			Fachada.criarVendedor("B");
			
			//System.out.println(Fachada.listarPersonagens());
			System.out.println(Fachada.listarVendedor());
			System.out.println(Fachada.listarTipo());
//			System.out.println(Fachada.listarItens());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("\tFim do Programa!");
	}



	public static void main (String[] args) {
		new Listar();
	}
}
