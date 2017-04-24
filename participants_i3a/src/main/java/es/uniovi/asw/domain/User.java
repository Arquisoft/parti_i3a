package es.uniovi.asw.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String login;
	private String password;
	private String firstname;
	private String lastname;
	private String address;
	private String nationality;
	private String DNI;
	private Date birthday;
	
	@OneToMany(mappedBy = "owner")
	private List<Proposal> proposals;
	
	@OneToMany(mappedBy = "user")
	private List<Vote> votes;

	public User() {
	}

	public User(Long id, String login, String password, String firstname, String lastname, String address,
			String nationality, String dNI, Date birthday) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.nationality = nationality;
		this.DNI = dNI;
		this.birthday = birthday;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String toStringLogin() {
		return "User [" + login + "," + password + "]";
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", firstName=" + firstname
				+ ", lastName=" + lastname + ", address=" + address + ", nationality=" + nationality + ", DNI=" + DNI
				+ ", birthday=" + birthday + "]";
	}

	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposal(List<Proposal> proposals) {
		this.proposals = proposals;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVote(List<Vote> votes) {
		this.votes = votes;
	}
}
