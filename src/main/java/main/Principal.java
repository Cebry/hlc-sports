package main;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Player;
import dominio.PlayerDao;
import dominio.Role;
import dominio.RoleDao;
import dominio.Team;
import dominio.TeamDao;
import menu.Keyboard;
import menu.Menu;
import menu.Option;

public class Principal {

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;

	private static Player player = null;
	private static PlayerDao playerDao = null;

	private static Team team = null;
	private static TeamDao teamDao = null;

	private static Role role = null;
	private static RoleDao roleDao = null;

	public static void main(String[] args) {

		emf = Persistence.createEntityManagerFactory("sports");
		em = emf.createEntityManager();
		playerDao = new PlayerDao(em);
		teamDao = new TeamDao(em);
		roleDao = new RoleDao(em);

		ArrayList<Option> options = new ArrayList<Option>();

		options.add(new Option("ListarEquipos", () -> {
			listTeams();
		}));

		options.add(new Option("Listar jugadores", () -> {
			listPlayers();
		}));

		options.add(new Option("Listar roles", () -> {

			listRoles();
		}));

		options.add(new Option("Crear equipo", () -> {

			createTeam();
		}));

		options.add(new Option("Crear jugador", () -> {

			createPlayer();
		}));

		options.add(new Option("Crear rol", () -> {

			createRole();
		}));

		options.add(new Option("Eliminar equipo", () -> {

			try {
				deleteTeam();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}));

		options.add(new Option("Eliminar jugador", () -> {

			try {
				deletePlayer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}));

		options.add(new Option("Eliminar rol", () -> {

			try {
				deleteRole();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}));

		options.add(new Option("Actalizar equipo", () -> {

			try {
				updateTeam();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}));

		options.add(new Option("Actualizar jugador", () -> {

			try {
				updatePlayer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}));

		options.add(new Option("Actualizar rol", () -> {

			try {
				updateRole();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}));

		Menu menu = new Menu(options);
		menu.exec();
	}

	private static void listTeams() {
		teamDao.findAll().forEach(t -> System.out.println(t));

	}

	private static void listPlayers() {

		playerDao.findAll().forEach(p -> System.out.println(p));
	}

	private static void listRoles() {

		roleDao.findAll().forEach(r -> System.out.println(r));
	}

	public static void createTeam() {

		String name = Keyboard.getString("nombre");
		String initials = Keyboard.getString("iniciales");

		em.getTransaction().begin();
		teamDao.create(new Team(name, initials));
		em.getTransaction().commit();
	}

	public static void createPlayer() {

		String name = Keyboard.getString("nombre");
		String dorsal_name = Keyboard.getString("nombre en dorsal");
		Integer dorsal_number = Keyboard.getInt("número en dorsal");

		em.getTransaction().begin();
		playerDao.create(new Player(name, dorsal_name, dorsal_number));
		em.getTransaction().commit();
	}

	public static void createRole() {

		String name = Keyboard.getString("nombre");
		String description = Keyboard.getString("descripción");

		em.getTransaction().begin();
		roleDao.create(new Role(name, description));
		em.getTransaction().commit();
	}

	public static void deleteTeam() throws Exception {

		int id = Keyboard.getInt("id");
		teamDao.checkExists(id);

		em.getTransaction().begin();
		team = teamDao.find(id);
		teamDao.delete(team);
		em.getTransaction().commit();
	}

	public static void deletePlayer() throws Exception {

		int id = Keyboard.getInt("id");
		playerDao.checkExists(id);

		em.getTransaction().begin();
		player = playerDao.find(id);
		playerDao.delete(player);
		em.getTransaction().commit();
	}

	public static void deleteRole() throws Exception {

		int id = Keyboard.getInt("id");
		roleDao.checkExists(id);

		em.getTransaction().begin();
		role = roleDao.find(id);
		roleDao.delete(role);
		em.getTransaction().commit();
	}

	public static void updateTeam() throws Exception {

		int id = Keyboard.getInt("id");
		teamDao.checkExists(id);
		team = teamDao.find(id);

		if (Keyboard.getBoolean("¿Actualizar nombre?")) {
			team.setName(Keyboard.getString("nombre"));
		}
		if (Keyboard.getBoolean("¿Actualizar iniciales?")) {
			team.setInitials(Keyboard.getString("iniciales"));
		}

		em.getTransaction().begin();
		em.merge(team);
		em.getTransaction().commit();

	}

	public static void updatePlayer() throws Exception {

		int id = Keyboard.getInt("id");
		playerDao.checkExists(id);
		player = playerDao.find(id);

		if (Keyboard.getBoolean("¿Actualizar nombre?")) {
			player.setName(Keyboard.getString("nombre"));
		}
		if (Keyboard.getBoolean("¿Actualizar nombre en dorsal")) {
			player.setDorsal_name(Keyboard.getString("nombre en dorsal"));
		}
		if (Keyboard.getBoolean("¿Actualizar número en dorsal?")) {
			player.setDorsal_number(Keyboard.getInt("número en dorsal"));
		}

		em.getTransaction().begin();
		em.merge(player);
		em.getTransaction().commit();

	}

	public static void updateRole() throws Exception {

		int id = Keyboard.getInt("id");
		roleDao.checkExists(id);
		role = roleDao.find(id);

		if (Keyboard.getBoolean("¿Actualizar nombre?")) {
			role.setName(Keyboard.getString("nombre"));
		}
		if (Keyboard.getBoolean("¿Actualizar descripción?")) {
			role.setDescription(Keyboard.getString("descripción"));
		}

		em.getTransaction().begin();
		em.merge(role);
		em.getTransaction().commit();

	}

	public static void showTeam() throws Exception {

		int id = Keyboard.getInt("id");
		teamDao.checkExists(id);

		team = teamDao.find(id);
		System.out.println(team);
	}

	public static void showPlayer() throws Exception {

		int id = Keyboard.getInt("id");
		playerDao.checkExists(id);

		player = playerDao.find(id);
		System.out.println(player);
	}

	public static void showRole() throws Exception {

		int id = Keyboard.getInt("id");
		roleDao.checkExists(id);

		role = roleDao.find(id);
		System.out.println(role);
	}

}
