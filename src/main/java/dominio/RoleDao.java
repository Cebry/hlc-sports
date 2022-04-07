package dominio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class RoleDao extends Dao<Role, Integer> {

	public RoleDao(EntityManager em) {
		super(em);
	}

	@Override
	public Role find(Integer id) {
		return em.find(Role.class, id);
	}

	public List<Role> findAll() {
		Query query = em.createNamedQuery("Role.all", Role.class);
		List<Role> lista = query.getResultList();
		return lista;
	}

	public void checkExists(int id) throws Exception {
		if ((find(id)) == null)
			throw new DaoException("El rol no existe.");
	}
}
