package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.TipoPersonagem;

public class DAOTipoPersonagem  extends DAO<TipoPersonagem>{
	public TipoPersonagem read (Object chave) {
		String nom = (String) chave;
		Query q = manager.query();
		q.constrain(TipoPersonagem.class);
		q.descend("descricao").constrain(nom);
		List<TipoPersonagem> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}
