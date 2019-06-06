package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Vendedor;

public class DAOVendedor  extends DAO<Vendedor>{
	public Vendedor read (Object chave) {
		String nom = (String) chave;
		Query q = manager.query();
		q.constrain(Vendedor.class);
		q.descend("nome").constrain(nom);
		List<Vendedor> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}
