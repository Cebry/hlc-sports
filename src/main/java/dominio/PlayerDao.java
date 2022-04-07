package dominio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PlayerDao extends Dao<Player, Integer> {

	public PlayerDao(EntityManager em) {
		super(em);
	}

	@Override
	public Player find(Integer id) {
		return em.find(Player.class, id);
	}

	public List<Player> findAll() {
		Query query = em.createNamedQuery("Player.all", Player.class);
		List<Player> lista = query.getResultList();
		return lista;
	}

	public void checkExists(int id) throws Exception {
		if ((find(id)) == null)
			throw new DaoException("El jugador no existe.");
	}
}
