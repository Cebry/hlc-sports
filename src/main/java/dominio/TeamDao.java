package dominio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TeamDao extends Dao<Team, Integer> {

	public TeamDao(EntityManager em) {
		super(em);
	}

	@Override
	public Team find(Integer id) {
		return em.find(Team.class, id);
	}

	public List<Team> findAll() {
		Query query = em.createNamedQuery("Team.all", Team.class);
		List<Team> lista = query.getResultList();
		return lista;
	}

	public void checkExists(int id) throws Exception {
		if ((find(id)) == null)
			throw new DaoException("El equipo no existe.");
	}
}
