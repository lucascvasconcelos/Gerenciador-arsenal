package aplicacao;

import com.db4o.ObjectContainer;

import fachada.Fachada;


//CADASTRANDO UMA CONTA E CRIANDO UM PERSONAGEM;
//CADASTRANDO UMA CONTA E CRIANDO UM PERSONAGEM;
//CADASTRANDO UMA CONTA E CRIANDO UM PERSONAGEM;
//CADASTRANDO UMA CONTA E CRIANDO UM PERSONAGEM;
//CADASTRANDO UMA CONTA E CRIANDO UM PERSONAGEM;
//CADASTRANDO UMA CONTA E CRIANDO UM PERSONAGEM;

public class Cadastrar {

	protected static ObjectContainer manager;
	
	public Cadastrar() {
		
		try {
			Fachada.inicializar();
			//Criando a conta//
			Fachada.criarConta("usuario", "senha", "email");
			//Fazendo o Login//
			Fachada.login("usuario", "senha");
			//Os tipos de personagens serão descritos por nós Administradores do jogo//
			Fachada.criarTipoPersonagem("descricao");
			//Criando o Personagem na conta, por isso foi feito o Login//
			Fachada.criarPersonagem("nome", "descricao");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}

	public static void main(String[] args) {
		new Cadastrar();
	}
}

