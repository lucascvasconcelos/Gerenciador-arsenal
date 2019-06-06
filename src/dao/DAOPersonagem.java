package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Personagem;

public class DAOPersonagem  extends DAO<Personagem>{
	public Personagem read (Object chave) {
		String nom = (String) chave;
		Query q = manager.query();
		q.constrain(Personagem.class);
		q.descend("nome").constrain(nom);
		List<Personagem> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}
