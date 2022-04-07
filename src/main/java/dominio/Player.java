package dominio;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "player")
@NamedQueries({

		@NamedQuery(name = "Player.all", query = "SELECT p FROM Player p"), })
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String dorsal_name;
	private int dorsal_number;
	private boolean is_captain;
	@JoinColumn
	private int team_id;
//	@ManyToMany
//	@JoinTable(name = "player-role", joinColumns = { @JoinColumn(name = "EMPLEADO_NOMBRE") },
//
//			inverseJoinColumns = { @JoinColumn(name = "PROYECTO_CODIGO") })
//	private HashSet<Role> roles = new HashSet<Role>();

	public Player() {
		super();
	}

	public Player(String name, String dorsal_name, int dorsal_number) {
		super();
		this.name = name;
		this.dorsal_name = dorsal_name;
		this.dorsal_number = dorsal_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDorsal_name() {
		return dorsal_name;
	}

	public void setDorsal_name(String dorsal_name) {
		this.dorsal_name = dorsal_name;
	}

	public int getDorsal_number() {
		return dorsal_number;
	}

	public void setDorsal_number(int dorsal_number) {
		this.dorsal_number = dorsal_number;
	}

	public boolean isIs_captain() {
		return is_captain;
	}

	public void setIs_captain(boolean is_captain) {
		this.is_captain = is_captain;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dorsal_name, dorsal_number, id, is_captain, name, team_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(dorsal_name, other.dorsal_name) && dorsal_number == other.dorsal_number && id == other.id
				&& is_captain == other.is_captain && Objects.equals(name, other.name) && team_id == other.team_id;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", dorsal_name=" + dorsal_name + ", dorsal_number="
				+ dorsal_number + ", is_captain=" + is_captain + ", team_id=" + team_id + "]";
	}

}
