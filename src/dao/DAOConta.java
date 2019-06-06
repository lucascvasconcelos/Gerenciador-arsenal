package dao;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Conta;

public class DAOConta  extends DAO<Conta>{
	public Conta read (Object chave) {
		String usuario = (String) chave;
		Query q = manager.query();
		q.constrain(Conta.class);
		q.descend("usuario").constrain(usuario);
		List<Conta> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE PESSOA
	 * 
	 **********************************************************/
	
	public List<Conta> consultarContaPorTipoPersonagem(String descricao){
		Query q = manager.query();
		q.constrain(Conta.class);
		q.descend("personagens").descend("tipo").descend("descricao").constrain(descricao).like();
		List<Conta> result = q.execute();
		return result;
	}
	
	public List<Conta> consultarContaPorItem(String nome){
		Query q = manager.query();
		q.constrain(Conta.class);
		q.descend("personagens").descend("itensPersongem").descend("tipo").constrain(nome).like();
		List<Conta> result = q.execute();
		return result;
	}
	
	
//	public List<Pessoa>  consultarPessoasNTelefones(int n) {
//		Query q = manager.query();
//		q.constrain(Pessoa.class);
//		q.constrain(new Filtro(n));
//		List<Pessoa> result = q.execute(); 
//		return result;
//	}
//	
//	@SuppressWarnings("serial")
//	class Filtro  implements Evaluation {
//		private int n;
//		public Filtro (int n) {this.n=n;}
//		public void evaluate(Candidate candidate) {
//			 p = (Pessoa) candidate.getObject();
//			candidate.include( p.getTelefones().size()==n);
//		}
}

