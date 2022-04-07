package dominio;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "team")
@NamedQueries({

		@NamedQuery(name = "Team.all", query = "SELECT t FROM Team t"), })
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String initials;
//	@OneToMany(mappedBy = "team_id")
//	private HashSet<Player> players = new HashSet();

	public Team() {
		super();
	}

	public Team(String name, String initials) {
		super();
		this.name = name;
		this.initials = initials;
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

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, initials, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return id == other.id && Objects.equals(initials, other.initials) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", nombre=" + name + ", iniciales=" + initials + "]";
	}

}
